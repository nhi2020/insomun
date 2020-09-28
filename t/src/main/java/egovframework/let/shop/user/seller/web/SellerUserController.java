package egovframework.let.shop.user.seller.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.let.shop.user.seller.service.SellerUserService;
import egovframework.let.shop.user.seller.service.impl.SellerUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class SellerUserController {

	/**
	 * EgovBBSManageService
	 */
	@Resource(name = "SellerUserService")
	private SellerUserService SellerService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	/**
	 * XSS 방지 처리.
	 *
	 * @param data
	 * @return
	 */
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

	/**
	 * 상품 정보
	 *
	 * @param request
	 * @param commandMap
	 * @exception Exception
	 *                Exception
	 */
	
	/*@RequestMapping(value = "/shop/seller/EgovsellerLoginFrom.do")
	public String login( ModelMap model) throws Exception {
		
		return "shop/sellerLogin/sellerLoginFrom";
	}*/
	
	@RequestMapping(value = "/shop/user/seller/EgovsellerLoginPro.do")
	public String login( @RequestParam("id") String id,  @RequestParam("passwd") String passwd, Model model, HttpServletRequest request,@ModelAttribute("searchVO") SellerUserVO vo) throws Exception {
		
		HttpSession session= request.getSession();
		
		System.out.println("user_id"+id);
		System.out.println("password"+passwd);
		
		SellerUserVO sellervo = new SellerUserVO();
		sellervo.setS_id(id);
		sellervo.setS_pass(passwd);
		
		String user_name = (String)SellerService.selectLoginCheck(sellervo);
		System.out.println("나옴"+user_name);
		
		
		if (user_name != null && user_name !=""){
			
			session.setAttribute("userid", id);
			session.setAttribute("status", 2);
			/*request.getSession().setAttribute("user_id", id);*/
			model.addAttribute("msg","성공");
			model.addAttribute("chk",1);
		
		}else {
			System.out.println("오류 남");
			model.addAttribute("msg","사용자 올바르지 않음");
			model.addAttribute("chk",0);
		}
		
		return "shop/user/seller/sellerLogin/sellerLoginPro";
	}
	
	
	
	
	@RequestMapping(value="/shop/user/seller/sellerLogout.do")
	public String egovSellerLogout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/shop/user/main/EgovUserMain.do";
	}
}