package egovframework.let.shop.mng.buyer.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.let.shop.mng.buyer.service.BuyerMngService;
import egovframework.let.shop.mng.buyer.service.impl.BuyerVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BuyerMngController {

	@Resource(name = "BuyerService")
	private BuyerMngService buyerService;

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

	@RequestMapping(value = "/shop/buyer/BuyerList")
	public String buyerForwardPage(@ModelAttribute("searchVO") BuyerVO vo, HttpServletRequest request, Model model) {

		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = buyerService.selectListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<BuyerVO> list = buyerService.selectList(vo);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);

		return "shop/buyer/BuyerList";

	}

	@RequestMapping("/shop/buyer/BuyerModifyForm")
	public String buyerModifyForm(BuyerVO vo, Model model){
		System.out.println("BuyerModifyForm ()");
		vo = buyerService.buyerSelect(vo);
		model.addAttribute("BuyerVO", vo);
		return "shop/buyer/BuyerModifyForm";
	}

	@RequestMapping(value= "/shop/buyer/BuyerModifyPro", method=RequestMethod.POST)
	public String BuyerModifyForm(BuyerVO vo, Model model){
		System.out.println("BuyerModifyPro ()");
		System.out.println("vo sns_idx=>" + vo.getSns_idx());
		int result = buyerService.buyerUpdate(vo);
		if (result > 0 ){
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		model.addAttribute("vo");
		
		
		return "forward:BuyerModifyForm.do";
		
	}

}
