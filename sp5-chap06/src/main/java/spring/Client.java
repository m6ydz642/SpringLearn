package spring;

import org.springframework.beans.factory.DisposableBean;

import spring.Interface.InitializingBean;

public class Client implements InitializingBean, DisposableBean {

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
