package chap03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

		Gretter g = ctx.getBean("gretter",Gretter.class);
		String msg = g.getFormat("스프링");
		System.out.println("빈객체 내용 " + g);
		System.out.println(msg);
		
		Gretter g1 = ctx.getBean("gretter",Gretter.class); // 별도 설정이 없을경우 스프링은 한 개의 빈객체만을 생성
															// 싱글톤 범위임
		Gretter g2 = ctx.getBean("gretter",Gretter.class);
		System.out.println("(g1==g2) = " + (g1==g2) ); // g1, g2는 같은 객체기 때문에 참임
		
		Gretter g3 = ctx.getBean("gretter2",Gretter.class);
		String msg2 = g3.getFormat("두번째 객체");
		System.out.println(msg2);
	}

}
