package chap09;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // MVc에서 컨트롤러로 사용함 

public class HelloController {
	@GetMapping("/hello") // 메서드가 처리할 요청 경로 지정
	/*ex) /hello경로로 들어온 요청을 hello()메서드를 통해 처리하도록 설정 
	 * http 요청 메서드중 get메서드에 대한 매핑을 설정함
	 * 
	 * */
	public String hello (Model model, // 모델파라미터는 컨트롤러의 처리결과를 뷰에 전달함
		@RequestParam(value = "name", required = false) String name) // 인자 엄청 기네.....
	// RequestParam어노테이션은 http요청 파라미터의 값을 메서드의 파라미터로 전달할때 사용함
	// 위 코드의 경우 name요청 파라미터의 값을 name파라미터로 전달
	
	/*http://로컬호스트/hello?name=name 
	 * @GetMapping("/hello") -> /hello부분 
	 * name 부분 -> @RequestParam(value= "name") 부분 
	 * = name 부분은 인자로 받아옴 즉 
	 * hello?name=어떤이름 으로 받아옴*/ 
	 
	 
	{
		model.addAttribute("att", "안녕하세요 " + name + "님"); // 뷰에 전달할 데이터를 지정하기 위해 사용
		// "att"라는 모델 속성에 값을 설정 // jsp로 가면 att라는 값을 ${} 틀릿기호로 값 로드함
		System.out.println("값 리턴");
		
		return "wow"; // 컨트롤러의 처리결과를 보여줄 뷰 이름으로 "리턴완료"를 사용
		/*리턴시 리턴받은값.jsp를 하기때문에 return값도 jsp파일 이름이랑 맞춰줘야 함
		 * return값을 마음대로 "와우"로 지정할 경우 해당 경로에 와우.jsp가 있어야 함
		 * /sp5-chap09/WEB-INF/view/와우.jsp
		 * 
		 * */
		
	}
			
	
}
