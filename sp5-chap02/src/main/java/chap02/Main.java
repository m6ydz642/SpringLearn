package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

		Gretter g = ctx.getBean("gretter",Gretter.class); // 여기서 설정된 gretter는 
											// appcontext에 있는 gretter객체타입 함수
		// g변수에는 %s 님안녕 이라는 내용이 이미 들어간 상태로 getBean으로 호출 됨
		String msg = g.getFormat("스프링");
		System.out.println(msg);
		// 출력결과는 %s 님 안녕
		// getFormat함수에서 인자 반대로 해서 printf문 처럼 호출해주는 String.format함수가 되어 있음
		
	/*	Gretter g1 = ctx.getBean("gretter",Gretter.class); // 별도 설정이 없을경우 스프링은 한 개의 빈객체만을 생성
															// 싱글톤 범위임
		Gretter g2 = ctx.getBean("gretter",Gretter.class);
		System.out.println("(g1==g2) = " + (g1==g2) ); // g1, g2는 같은 객체기 때문에 참임
		
		Gretter g3 = ctx.getBean("gretter2",Gretter.class);
		String msg2 = g3.getFormat("두번째 객체");
		System.out.println(msg2);*/
	}

}
