package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;

/*value로 지정한 이름의 변수들은 session에 담아둔다.*/
@SessionAttributes(value= {"memberLoggedIn"})
@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	//리턴 주소와 매핑주소가 가아 return타입을 void로 지정
	@RequestMapping("/member/memberEnroll.do")
	public void memberEnroll() {
		
		
	}
	
	/*@RequestMapping(value="/member/memberEnrollEnd.do", method=RequestMethod.POST)*/
	@PostMapping("/member/memberEnrollEnd.do")
	public String memberEnrollEnd(Model model, Member member) {
		String rawPassword = member.getPassword();
		String encryptedPassword = bcryptPasswordEncoder.encode(rawPassword);
		System.out.println("rawPassword="+rawPassword);
		System.out.println("encryptedPassword="+encryptedPassword);
		
		//비밀번호 암호화 처리
		member.setPassword(encryptedPassword);
		
		
		int result = memberService.insertMember(member);
		System.out.println("result@Controller="+result);
		
		//3.view model : view에서 참조할 수 있는 Map객체
		model.addAttribute("msg", result>0?"등록성공":"등록실패");
		model.addAttribute("loc","/");
		
		return "common/msg";
	}
	
	/**
	 * Model은 mvc패턴의 m(model)이 아니라 viewModel을 가리킨다.
	 * view단에서 처리할 데이터저장소, 하나의 Map 객체.(key - value형식)
	 * 
	 * ModelAndView : viewName과 model을 한번에 처리하는 객체
	 * ModelMap : viewName을 리턴
	 * Model : viewName을 리턴
 	 * 
	 */
	/*@PostMapping("/member/memberLogin.do")
	public String memberLogin(@RequestParam String memberId, @RequestParam String password, Model model, HttpSession session) {
	
		//1. 업무로직
		Member m = memberService.selectOneMember(memberId);
		System.out.println("m@controller="+m);
		
		String msg = "";
		String loc = "/";
		//로그인 분기 처리
		if(m==null) {
			msg="존재하지 않는 아이디입니다.";
		}
		else {
			//DB의 비밀번호와 입력한 비밀번호의 일치여부 확인
			if(bcryptPasswordEncoder.matches(password, m.getPassword())) {
				msg="로그인 성공!";
				
				//세션에 로그인한 Member객체 저장
				//session.setAttribute("memberLoggedIn", m);
				//model에 로그이한 Member객체 저장(로그인 성공이 뜨고 로그인이 풀려있다. = requset에 담겨있기 때문에 풀린다.)
				model.addAttribute("memberLoggedIn", m);
			}
			else {
				msg="비밀번호가 틀렸습니다.";
			}
		}
		
		//2. view모델 처리
		
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		
		return "common/msg";
	}*/
	
	/*ModelAndView객체로 처리*/
	@PostMapping("/member/memberLogin.do")
	public ModelAndView memberLogin(@RequestParam String memberId, @RequestParam String password, ModelAndView mav, HttpSession session) {
	
		//1. 업무로직
		Member m = memberService.selectOneMember(memberId);
		System.out.println("m@controller="+m);
		
		String msg = "";
		String loc = "/";
		//로그인 분기 처리
		if(m==null) {
			msg="존재하지 않는 아이디입니다.";
		}
		else {
			//DB의 비밀번호와 입력한 비밀번호의 일치여부 확인
			if(bcryptPasswordEncoder.matches(password, m.getPassword())) {
				msg="로그인 성공!";
				
				//세션에 로그인한 Member객체 저장
				//session.setAttribute("memberLoggedIn", m);
				//model에 로그이한 Member객체 저장(로그인 성공이 뜨고 로그인이 풀려있다. = requset에 담겨있기 때문에 풀린다.)
				mav.addObject("memberLoggedIn", m);
			}
			else {
				msg="비밀번호가 틀렸습니다.";
			}
		}
		
		//2. view모델 처리
		mav.addObject("msg",msg);
		mav.addObject("loc",loc);
		
		//viewName지정
		mav.setViewName("common/msg");
		
		return mav;
	}
	
	
	
	
	/**
	 * @SessionAttribute를 이용해서 모델에 속성을 저장한 경우는
	 * SessionStatus객체의 setComplete메서드를 통해 세션 폐기.
	 * 
	 * 기존방식 HttpSession.setAttribute한 경우에는
	 * HttpSession.invalidate메서드로 세션 폐기한다.
	 * 
	 */
	
	@RequestMapping("/member/memberLogout.do")
	public String memberLogout(SessionStatus sessionStatus) {
		
		//session invalidate사용했었다.
		//setComplete 메서드 호출로 해당 세션 폐기
		if(!sessionStatus.isComplete()) {
			sessionStatus.setComplete();
		}
		
		//index페이지로 redirect처리
		return "redirect:/";
	}
	
//	@RequestMapping(value="/member/memberView.do", method= {RequestMethod.POST, RequestMethod.GET})
	@RequestMapping("/member/memberView.do")
	public String memberView(@RequestParam String memberId, Model model) {
		
		System.out.println("memberId@Controller="+memberId);
		Member m = memberService.selectOneMember(memberId);
		
		System.out.println(m.getHobby());
		model.addAttribute("m",m);
		
		return "member/memberView";
	}
	
	@PostMapping("/member/memberUpdate.do")
	public String memberUpdate(Model model, Member member) {
		System.out.println("member@controller="+member);
		
		int result = memberService.updateMember(member);
		System.out.println("updateResult@Controller="+result);
		
		Member m = memberService.selectOneMember(member.getMemberId());
		
		model.addAttribute("m",m);
		
		return "member/memberView";
	}
	
}
