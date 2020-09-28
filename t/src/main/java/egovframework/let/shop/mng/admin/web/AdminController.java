package egovframework.let.shop.mng.admin.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.let.shop.mng.admin.service.AdminService;
import egovframework.let.shop.mng.admin.service.impl.AdminVO;


@Controller
public class AdminController {

	@Resource(name="AdminService")
	private AdminService adminService;
	
	protected String unscript(String data) {
		if (data == null || data.trim().equals("")) {
			return "";
		}

		String ret = data;

		ret = ret.replaceAll("<(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;script");
		ret = ret.replaceAll("</(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;/script");

		ret = ret.replaceAll("<(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;object");
		ret = ret.replaceAll("</(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;/object");

		ret = ret.replaceAll("<(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;applet");
		ret = ret.replaceAll("</(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;/applet");

		ret = ret.replaceAll("<(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");
		ret = ret.replaceAll("</(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");

		ret = ret.replaceAll("<(F|f)(O|o)(R|r)(M|m)", "&lt;form");
		ret = ret.replaceAll("</(F|f)(O|o)(R|r)(M|m)", "&lt;form");

		return ret;
	}
	
	@RequestMapping(value="/shop/mng/admin/EgovMngAdminLoginForm.do")
	public String EgovMngAdminLoginForm() {
	   
	    return "/shop/mng/admin/adminLogin/EgovMngAdminLoginForm";
	}
	
	@RequestMapping(value="/shop/mng/admin/EgovMngAdminLoginPro.do")
public String EgovMngAdminLoginPro( @RequestParam("id") String id,  @RequestParam("passwd") String passwd, Model model, HttpServletRequest request,@ModelAttribute("searchVO") AdminVO vo) throws Exception {
		
		HttpSession session= request.getSession();
		
		System.out.println("user_id"+id);
		System.out.println("password"+passwd);
		
		AdminVO adminvo = new AdminVO();
		adminvo.setA_id(id);
		adminvo.setA_pass(passwd);
		
		String user_name = (String)adminService.selectLoginCheck(adminvo);
		List<AdminVO> list = adminService.selectListLoginCheck(adminvo);
		
		System.out.println("나옴"+user_name);
		
//		System.out.println("list"+list.get(0).getA_id());
//		System.out.println("list2"+list.get(0).getA_email());
		
		
		if (user_name != null){
			session.setAttribute("userid", id);
			session.setAttribute("status", 0);
			/*request.getSession().setAttribute("user_id", id);*/
			System.out.println("성공");
			model.addAttribute("chk",1);
		}else {
			System.out.println("실패");
			model.addAttribute("msg","사용자 올바르지 않음");
			model.addAttribute("chk",0);	
		}
		
		return "/shop/mng/admin/adminLogin/EgovMngAdminLoginPro";
	}
	
	
	@RequestMapping(value="/shop/mng/seller/adminLogout.do")
	public String adminLogout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/shop/user/main/EgovMain.do";
	}
}
