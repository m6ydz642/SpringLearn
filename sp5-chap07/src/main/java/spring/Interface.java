package spring;

public class Interface {
	public interface InitializingBean {
		void afterPropertiesSet() throws Exception;
	}
	
	public interface DisposableBean {
		void destory() throws Exception;
	}
	
	// 구현을 이렇게 하라는게 아니라 이런식으로 구현되어있다고 설명한거였음 ㅋㅋ
	// 이거 안써도 됨
	
}
