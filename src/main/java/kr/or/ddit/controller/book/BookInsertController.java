package kr.or.ddit.controller.book;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.IBookService;

// 등록 페이지와 등록 기능

// @Controller 어노테이션이 있는 클래스는 스프링이 브라우저의 요청(request)을
// 받아들이는 컨트롤러라고 인지해서 자바 빈(Java Bean)으로 등록해서 관리한다.
@Controller
@RequestMapping("/book")
public class BookInsertController {
	// 서비스를 호출하기 위해 IBookService를 의존성을 주입한다.
	// 의존성 주입을 통한 결합도 낮추기
	@Autowired
	private IBookService bookService;
	
	/*
		@RequestMappping과 @GetMapping 등등의 Mapping 어노테이션은 요청 URL을 어떤 메서드가 처리할 지 여부를 결정
		
		method 속석은 http요청 메소드를 의미합니다.
		일반적인 웹 페이지 개발에서 GET 메소드는 데이터를 변경하지 않는 경우에, POST 메서드는 데이터가 변경될 경우 사용됩니다.
		ModelAndView는 컨트롤러가 반환할 데이터를 담당하는 모델(Model)과 화면을 담당하는 뷰(View)의 경로를 합쳐놓은 객체다.
		ModelAndView의 생성자에 문자열 타입 파라미터가 입력되면 뷰의 경로라고 간주한다.
		
		뷰의 경로를 'book/form'과 같은 형태로전달하는 이유는 요청(request)에 해당하는 url의 mapping되는 화면의 경로값을
		viewResolver라는 녀석이 제일 먼저 받는다. 받아서 suffix, prefix 속성에 의해서 앞에는 '/WEB-INF/views/'
		를 붙이고, 뒤에는 '.jsp'를 붙여 최종 위치에 해당하는 jsp 파일을 찾아준다. 
	 */
	// Book 게시판 등록 페이지
	@GetMapping("/form.do")
	public ModelAndView bookForm() {
		return new ModelAndView("book/form");
	}
	
	/*
		데이터의 변경이 일어나므로 HTTP 메서드는 POST 방식으로 처리
		
		@RequestParam은 HTTP 파라미터를 Map 변수에 자동으로 바인딩한다.
		Map 타입의 경우는 @RequestParam을 붙여야만 HTTP 파라미터의 값을 Map안에 바인딩할 수 있다.
	 */
	@PostMapping("/form.do")
	public ModelAndView insertBook(@RequestParam Map<String,Object> map) {
		ModelAndView mav = new ModelAndView();
		
		String bookId = bookService.insertBook(map);
		if(bookId == null) {
			// 데이터 입력이 실패할 경우 다시 데이터를 입력 받아야 하므로 생성 화면으로 redirect 시킴.
			// ModelAndView 객체는 .setViewName() 메소드를 통해 뷰의 경로를 지정할 수 있다.
			mav.setViewName("redirect:/book/form.do");
			// 뷰의 경로가 redirect:로 시작하면 스프링은 뷰 파일을 찾아가는 것이 아니라 웹 페이지의 주소(/form.do)를 변경
		} else {
			// 데이터 입력이 성공하면 상세 페이지로 이동한다.
			mav.setViewName("redirect:/book/detail.do?bookId="+bookId);
		}
		return mav;
		
	}
}
