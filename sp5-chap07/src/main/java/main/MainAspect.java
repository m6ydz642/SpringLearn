package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;

public class MainAspect {

	public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
	
	Calculator cal = ctx.getBean("calculator", Calculator);
	long fiveFact = cal.factorial(5);
	System.out.println("cal.factorial(5) = " + fiveFact);
	System.out.println(cal.getClass().geName());
	ctx.close();
	}

}
