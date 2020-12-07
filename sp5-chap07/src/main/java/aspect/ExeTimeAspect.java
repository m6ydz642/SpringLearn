package aspect;

import java.security.Signature;

@Aspect
public class ExeTimeAspect {
	@Poincut("execution(public * chap07 ..*(...))")

	private void publicTarget(){
		
	}
	
	@Around("publicTarget()")
	
	public Object measure(Proceed joinPoint) throws Throwable{
		long start = System.nanoTime();
		
		try {
			Object result = 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			long finish - System.nanoTime();
			Signature sig = joinPoint.
		}
		
	}
}
