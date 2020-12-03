package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.WrongIdPasswordException;

public class MainForSpring {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException{
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요 : ");
			String command = reader.readLine();
			
			if (command.equalsIgnoreCase("exit")){
				System.out.println("종료합니다.");
				break;
			}
			
			if(command.startsWith("new ")){ // new 하고 명령어를 입력해야해서 공백으로 띄움
				processNewCommand(command.split(" ")); // 커맨드를 공백으로 나눔
				
				continue;
			}else if (command.startsWith("change ")) { // new 하고 명령어를 입력해야해서 공백으로 띄움
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp(); // 명령어를 잘못 입력한경우
		}

	}



	private static void printHelp() {
		System.out.println("잘못된 명령입니다. 사용법을 확인하세요 ");
		
	}

	private static void processNewCommand(String[] arg) {
		System.out.println("arg길이 : " + arg.length);
	 if(arg.length != 5) {  // 커맨드로부터 입력받은 인자수가 5개가 아니라면 
		 				// 아이디, 이메일, 이름, 암호, 암호(패스워드 확인)
		 // 부분이 배열로 입력받기 때문에 길이로는 5임
		 printHelp();
		 return;
	 }
	 
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		 // memberRegSvc -> AppCtx.java에 있음
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호가 일치하지 않습니다.");
			return;
		}

		try {
			regSvc.regist(req);
			System.out.println("등록이 완료되었습니다.");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는데요? ");
		}

	}
	
	
	
	private static void processChangeCommand(String[] arg) {
		 ChangePasswordService chamgePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		 // changePwdSvc -> AppCtx.java에 있음
		 
		if (arg.length != 4) { // 변경받는 인자가 3자리라서 배열의 길이인 4까지
			printHelp();
			return;
		}

		try {
			chamgePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일 입니다.");
		} catch (WrongIdPasswordException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.");
		}

	}
	
}
