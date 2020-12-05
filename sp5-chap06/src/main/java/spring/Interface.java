package spring;

public class Interface {
	public interface InitializingBean {
		void afterPropertiesSet() throws Exception;
	}
	
	public interface DisposableBean {
		void destory() throws Exception;
	}
}
