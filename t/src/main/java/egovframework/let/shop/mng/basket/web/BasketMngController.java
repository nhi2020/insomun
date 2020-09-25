package egovframework.let.shop.mng.basket.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.let.shop.mng.basket.service.BasketMngService;
import egovframework.let.shop.mng.basket.service.impl.BasketBuyerMngVO;
import egovframework.let.shop.mng.basket.service.impl.BasketMngVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@SessionAttributes(types = ComDefaultVO.class)

public class BasketMngController {

	private static final Logger logger = LoggerFactory.getLogger(BasketMngController.class);

	@Resource(name = "BasketMngService")
	private BasketMngService basketService;

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

	// requestmapping
	// "/shop/basket/Basket***"

	@RequestMapping(value = "/shop/mng/basket/basketList")
	public String basketList(@ModelAttribute("searchVO") BasketBuyerMngVO vo, HttpServletRequest request, Model model) {
		logger.info("init");
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = basketService.selectListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<BasketBuyerMngVO> list = basketService.selectList(vo);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		logger.info("totCnt => " + totCnt);
		logger.info("list size => " + list.size());
		
		return "shop/mng/basket/listMngBasket";

	}
	
	@RequestMapping("/shop/mng/basket/updateMngBasket")
	public String updateMngBasket(BasketBuyerMngVO vo, Model model){
		logger.info("updateMngBasket");
		int result = basketService.updateMngBasket(vo);
		logger.info("result => " + result);
		return "forward:/shop/mng/basket/basketList.do";
	}
	
	@RequestMapping("/shop/mng/basket/deleteMngBasket")
	public String deleteMngBasket(BasketMngVO vo, Model model){
		logger.info("deleteMngBasket");
		int result = basketService.deleteMngBasket(vo);
		logger.info("result => " + result);
		return "forward:/shop/mng/basket/basketList.do";
	}

}
