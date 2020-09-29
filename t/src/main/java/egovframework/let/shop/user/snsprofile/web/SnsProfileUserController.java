package egovframework.let.shop.user.snsprofile.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.shop.user.snsprofile.service.SnsProfileUserSerivce;
import egovframework.let.shop.user.snsprofile.service.SnsProfileUserVO;

@Controller
public class SnsProfileUserController {
	
	@Resource(name = "SnsProfileUserSerivce")
	SnsProfileUserSerivce snsProfileUserSerivce;
	
	@RequestMapping("/shop/user/snsprofile/loginUserSnsprofileTestForm")
	public String loginUserSnsprofileTest(Model model){
		System.out.println("loginUserSnsprofileTest loginUserSnsprofileTestPro");
		return "/shop/user/snsprofile/loginUserSnsprofileTestForm";
	}
	
	@RequestMapping("/shop/user/snsprofile/loginUserSnsprofileTestPro")
	public String loginUserSnsprofileTestPro(SnsProfileUserVO vo,Model model, HttpServletRequest request){
		System.out.println("SnsProfileUserController loginUserSnsprofileTestPro");
		vo = snsProfileUserSerivce.selectUserSnsprofile(vo);
		model.addAttribute("vo", vo);
		HttpSession session = request.getSession();
		session.setAttribute("sns_idx", vo.getSns_idx());
		session.setAttribute("status", 1);
		return "redirect:/shop/user/main/EgovUserMain.do";
	}
	
}