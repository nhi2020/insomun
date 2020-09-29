package egovframework.let.shop.user.basket.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.shop.mng.basket.service.impl.BasketBuyerMngVO;
import egovframework.let.shop.mng.basket.web.BasketMngController;
import egovframework.let.shop.user.basket.service.BasketUserService;
import egovframework.let.shop.user.basket.service.impl.BasketProductUserVO;
import egovframework.let.shop.user.basket.service.impl.BasketUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BasketUserController {

	private static final Logger logger = LoggerFactory.getLogger(BasketUserController.class);
	
	@Resource(name="BasketUserService")
	private BasketUserService basketUserService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
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
	
	@RequestMapping("/shop/user/basket/selectBasketUser")
	public String selectBasketUser(BasketUserVO vo, Model model) {
		System.out.println("selectBasketUser ()");
		vo = basketUserService.selectBasketUser(vo);
		model.addAttribute("BasketUser", vo);
		return "shop/user/basket/selectBasketUser";
	}
	
	@RequestMapping("/shop/user/basket/listBasketUser")
	public String listBasketUser(@ModelAttribute("searchVO") BasketProductUserVO vo, Model model, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		vo.setSns_idx((int)session.getAttribute("sns_idx"));

		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = basketUserService.listCntBasketUser(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<BasketProductUserVO> list = basketUserService.listBasketUser(vo);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		logger.info("totCnt => " + totCnt);
		logger.info("list size => " + list.size());
		logger.info("vo.getPageIndex => " + vo.getPageIndex());
		
		return "/shop/user/basket/listBasketUser";
	}
	
}
