package spring;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;



public class Client implements InitializingBean, DisposableBean { // 내부적으로 정의되어있는걸 상속해서 쓰면 됨
	// 만드는거 아님 ㅋㅋ;;

	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public void destroy() throws Exception {
	System.out.println("client.destroy실행 ");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("client.afterPropertiesSet 실행");
		
	}
	
	public void send(){
		System.out.println("client.send() to " + host);
	}

}
