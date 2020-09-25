package egovframework.let.shop.mng.seller.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.let.shop.mng.seller.service.SellerMngService;
import egovframework.let.shop.mng.seller.service.impl.SellerVO;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * 템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)
 * 
 * @author 실행환경 개발팀 JJY
 * @since 2011.08.31
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.08.31  JJY            최초 생성
 *
 *      </pre>
 */
@Controller
public class SellerMngController {

	/**
	 * EgovBBSManageService
	 */
	@Resource(name = "EgovSellerService")
	private SellerMngService SellerService;

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
	public String forwardPageWithMenuNo(@ModelAttribute("searchVO") SellerVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		
		System.out.println("왔나?");
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = SellerService.selectSellerListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);
														
		List<SellerVO> list = SellerService.selectSellerList(vo);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);

		return "shop/sellerLogin/sellerLoginFrom";
	}*/
	
	
	@RequestMapping(value = "/shop/seller/EgovsellerLoginFrom.do")
	public String login( ModelMap model) throws Exception {
		
		return "shop/sellerLogin/sellerLoginFrom";
	}
	@RequestMapping(value = "/shop/seller/EgovsellerLoginPro.do")
	public String login( @RequestParam("id") String id,  @RequestParam("passwd") String passwd, Model model, HttpServletRequest request,@ModelAttribute("searchVO") SellerVO vo) throws Exception {
		
		HttpSession session= request.getSession();
		
		System.out.println("user_id"+id);
		System.out.println("password"+passwd);
		
		SellerVO sellervo = new SellerVO();
		sellervo.setS_id(id);
		sellervo.setS_pass(passwd);
		
		String user_name = (String)SellerService.selectLoginCheck(sellervo);
		System.out.println("나옴"+user_name);
		
		
		if (user_name != null && user_name !=""){
			
			session.setAttribute("userid", id);
			session.setAttribute("status", 1);
			/*request.getSession().setAttribute("user_id", id);*/
			System.out.println("성공");
		
		}else {
			request.getSession().setAttribute("user_id", "");
			model.addAttribute("msg","사용자 올바르지 않음");
		}
		
		return "shop/sellerLogin/sellerLoginPro";
	}
	
	@RequestMapping(value="/shop/seller/EgovSellerLogout.do")
	public String egovSellerLogout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/shop/product/EgovMngMain.do";
	}
	@RequestMapping(value="/shop/main/EgovMain.do")
	public String main() {
	   
	    return "shop/main/EgovMain.do";
	}
	
	
	@RequestMapping(value = "/shop/seller/sellercheckFrom.do")
	public String sellercheck( ModelMap model) throws Exception {
		
		return "shop/sellerFind/sellercheckFrom";
	}
	@RequestMapping(value = "/shop/seller/EgovsellerFindId.do")
	public String sellerfindid( ModelMap model) throws Exception {
		
		return "shop/sellerFind/sellerFindId";
	}
	@RequestMapping(value = "/shop/seller/EgovsellerFindPassword.do")
	public String sellerfindpasswrod( ModelMap model) throws Exception {
		
		return "shop/sellerFind/sellerFindPassword";
	}
	@RequestMapping(value = "/shop/seller/sellerIdCheckFrom.do")
	public String selleridcheck( ModelMap model) throws Exception {
		
		return "shop/sellerFind/sellerIdCheckFrom";
	}	
	@RequestMapping(value = "/shop/seller/sellerIdCheckFrom2.do")
	public String sellercheck2( ModelMap model) throws Exception {
		
		return "shop/sellerFind/sellercheckFrom2";
	}
	@RequestMapping(value = "/shop/seller/sellerFindPassword.do")
	public String sellerfindpassword( ModelMap model) throws Exception {
		
		return "shop/sellerFind/sellerFindPassword";
	}
	@RequestMapping(value = "/shop/seller/agreeFrom.do")
	public String selleragreeform( ModelMap model) throws Exception {
		
		return "shop/sellerInsert/agreeFrom";
	}
	@RequestMapping(value = "/shop/seller/sellerInsertFrom.do")
	public String sellerainsertform( ModelMap model) throws Exception {
		
		return "shop/sellerInsert/sellerInsertFrom";
	}	
}