package egovframework.let.shop.mng.deal.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.let.shop.mng.deal.service.DealMng;
import egovframework.let.shop.mng.deal.service.DealMngService;
import egovframework.let.shop.mng.deal.service.impl.DealMngVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class DealMngController {

	private static final Logger logger = LoggerFactory.getLogger(DealMngController.class);

	@Resource(name = "DealMngService")
	private DealMngService dealMngService;

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

	@RequestMapping(value = "/shop/mng/deal/dealBuyerList.do")
	public String listMngBuyer(@ModelAttribute("searchVO") DealMngVO vo, HttpServletRequest request, Model model, 
			@RequestParam(value = "pageIndex", required=false, defaultValue="1") int pageIndex) {
		vo.setPageIndex(pageIndex);
		System.out.println("listMngBuyer pageIndex => " + vo.getPageIndex());
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = dealMngService.selectListCnt(vo); //
		paginationInfo.setTotalRecordCount(totCnt);

		List<DealMngVO> list = dealMngService.selectList(vo); //
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("deallist", list);
		model.addAttribute("paginationInfo", paginationInfo);

		return "shop/mng/deal/dealBuyerMngList";

	}
	@RequestMapping(value="/shop/mng/deal/dealBuyerMngDetail.do")
	public String selectMngDealBuyerDetail(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController selectMngDealBuyerDetail Start...");
		vo = dealMngService.selectMngDealBuyerDetail(vo);
		model.addAttribute("dealMngVO", vo);
		return "shop/mng/deal/dealBuyerMngDetail";	
	}
	
	@RequestMapping(value="/shop/mng/deal/dealBuyerMngIng.do")
	public String updateMngDealBuyerDetail(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController updateMngDealBuyerDetail Start...");
		int result = dealMngService.updateMngDealBuyerDetail(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "redirect:/shop/mng/deal/dealBuyerList.do?d_idx=" + d_idx;	
	}

	@RequestMapping(value="/shop/mng/deal/dealBuyerMngCancel.do")
	public String updateMngDealBuyerCancel(HttpServletRequest request, DealMngVO vo, Model model) {
		System.out.println("DealMngController updateMngDealBuyerCancel Start...");
		int result = dealMngService.updateMngDealBuyerCancel(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "redirect:/shop/mng/deal/dealBuyerList.do?d_idx=" + d_idx;	
	}
	}