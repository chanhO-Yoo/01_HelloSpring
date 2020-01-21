package com.kh.spring.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.demo.model.service.DemoService;
import com.kh.spring.demo.model.vo.Dev;
/**
 * Handler가 가질 수 있는 매개변수 타입
 * 
 * HttpServletRequest
 * HttpServletResponse
 * HttpSession
 * Locale - 요청에 대한 Lovale정보
 * InputStream/Reader - 요청에 대한 입력스트림
 * OutputStream/Writer - 응답에 대한 출력스트림
 * @PathVariable - 요청url 중 일부를 매개변수에 담아 사용
 * @RequestParam - 사용자 입력값에 대한 처리
 * @requestHeader
 * @CookieValue
 * @RequestBody
 * @ModelAttribute
 * @SessionAttribute
 *
 * ModelAndView | Model | ModelMap
 * Command객체 - 사용자 입력값을 저장한 vo객체
 * Error | BindingResult - 커맨드객체 매핑 결과를 담은 에러객체
 * SessionStatus
 * MultipartFile
 */
@Controller
public class DemoController {
	
	//private  DemoService demoService = new DemoServiceImpl();

	//의존주입 : DI(Dependency Injection)
	@Autowired
	private  DemoService demoService;
	
	public DemoController() {
		System.out.println("demoService="+demoService);
	}
	
	//매핑주소(요청URL)와 최종 주소가 같을경우에 String -> void / return을 제거 가능하다.
	@RequestMapping("/demo/demo.do")
	public void demo() {
		System.out.println("서버시작후 자바파일수정");
		
//		return "demo/demo";
	}
	
	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest request, HttpServletResponse response) {
		
		//1.파라미터 핸들링
		String devName = request.getParameter("devName");
		int devCareer = Integer.parseInt(request.getParameter("devCareer"));
		String devEmail = request.getParameter("devEmail");
		String devGender = request.getParameter("devGender");
		String[] devLang = request.getParameterValues("devLang");
		
		//2.업무로직
		Dev dev = new Dev(0, devName, devCareer, devEmail, devGender, devLang);
		System.out.println("Dev@controller="+dev);
		
		//3.view model : view에서 참조할 수 있는 Map객체
		request.setAttribute("dev", dev);
		
		
		return "demo/demoResult";
	}
	
	@RequestMapping("/demo/demo2.do")
	public String demo2(HttpServletRequest request, 
						@RequestParam(value="devName") String devName,
						@RequestParam(value="devCareer", defaultValue="3") int devCareer,
						@RequestParam(value="devEmail") String devEmail,
						@RequestParam(value="devGender", required=false) String devGender,
						@RequestParam(value="devLang") String[] devLang) {
		
		//2.업무로직
		Dev dev = new Dev(0, devName, devCareer, devEmail, devGender, devLang);
		System.out.println("Dev@controller="+dev);
		
		//3.view model : view에서 참조할 수 있는 Map객체
		request.setAttribute("dev", dev);
		
		return "demo/demoResult";
	}
	
	@RequestMapping("/demo/demo3.do")
	public String demo3(HttpServletRequest request, Dev dev) {
		

		//3.view model : view에서 참조할 수 있는 Map객체
		request.setAttribute("dev", dev);
		
		return "demo/demoResult";
	}
	
	@RequestMapping("/demo/demo4.do")
	public String demo3(Model model, Dev dev) {
		

		//3.view model : view에서 참조할 수 있는 Map객체
		model.addAttribute("dev", dev);
		
		return "demo/demoResult";
	}
	
	@RequestMapping(value="/demo/demo5.do", method=RequestMethod.POST)
	public String demo5(Model model, Dev dev) {
		
		int result = demoService.insertDev(dev);
		System.out.println("result@controller="+result);

		//3.view model : view에서 참조할 수 있는 Map객체
		model.addAttribute("msg", result>0?"등록성공":"등록실패");
		model.addAttribute("loc","/");
		
		return "common/msg";
	}
	
	@RequestMapping("/demo/selectDevList.do")
	public String selectDevList(Model model) {
		List<Dev> list = demoService.selectDevList();
		System.out.println("list@Controller="+list);
		//model에 등록된 속성은 다시 requestScope에 속성으로 저장된다. -> 뷰단에서 바로 꺼내와서 사용 가능
		model.addAttribute("list",list);
		
		return "demo/devList";
	}
	
}
