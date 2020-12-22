package survey;




import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")

public class SurveyController {
	
	/*@GetMapping // 밑에서 form가 있는데 s또 있으니 오류나서 주석 처리
	public String form(){
		return "survey/surveyForm";
	}*/
	
	@GetMapping
	public ModelAndView form(Model model){
		System.out.println("form호출");
		List<Question> questions = createQustions();
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions",questions);
		mav.setViewName("survey/surveyForm");
		return mav;
	}
	
	private List<Question> createQustions() {
		Question q1 = new Question("당신의 역할은?", Arrays.asList("서버", "프론트", "풀스택"));
		return Arrays.asList(q1);
		
	}

	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		return "survey/submitted";
	}

}
