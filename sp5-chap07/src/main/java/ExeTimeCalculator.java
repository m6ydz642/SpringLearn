
public class ExeTimeCalculator implements Calculator{
private Calculator delgate;


	public ExeTimeCalculator(Calculator delgate) {
		this.delgate = delgate;
	}
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		long result = delgate.factorial(num);
		long end = System.nanoTime();
		System.out.printf("%s.factorial (%d) 실행 시간 = %d ", delgate.getClass().getSimpleName(), num, (end-start));
	return result;
	}
	

}
