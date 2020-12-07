package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class ExeTimeAspect {
	
	@Pointcut("execution(public * chap07 ..*(...))") // 공통 기능을 정의할 대상
	private void publicTarget(){ // 얘가 가르키는게 사실 measure를 가르키고 있는거임
							// PointCut으로 인해서 가능 함
		System.out.println("publicTarget호출");
	}
	
	@Around("publicTarget()")
	
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		
		try {
			Object result = joinPoint.proceed(); // 실제 객체 대상 메서드 호출
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s %s(%s) 실행시간 $d ns \n", joinPoint.getTarget().getClass().getSimpleName()
					, sig.getName(), Arrays.toString(joinPoint.getArgs()), (finish-start));
		}
		
	}
}
