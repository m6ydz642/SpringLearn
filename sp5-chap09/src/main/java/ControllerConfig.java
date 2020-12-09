
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ControllerConfig {
	@Bean // 빈 등록
	public HelloController helloController() {
		return new HelloController();

	}
}
