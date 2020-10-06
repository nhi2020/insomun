package egovframework.let.shop.user.deal.web;

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

import egovframework.let.shop.user.deal.service.DealUser;
import egovframework.let.shop.user.deal.service.DealUserService;
import egovframework.let.shop.user.deal.service.impl.DealUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class DealUserController {

	private static final Logger logger = LoggerFactory.getLogger(DealUserController.class);

	@Resource(name = "DealUserService")
	private DealUserService dealUserService;

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

	// 구매자
	@RequestMapping(value = "/shop/user/deal/dealUserBuyerList.do")
	public String listDealUserBuyer(@ModelAttribute("searchVO") DealUserVO vo, HttpServletRequest request, Model model, 
			@RequestParam(value = "pageIndex", required=false, defaultValue="1") int pageIndex) {
		vo.setPageIndex(pageIndex);
		System.out.println("listUserBuyer pageIndex => " + vo.getPageIndex());
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = dealUserService.selectListCntDealUserBuyer(vo); //
		paginationInfo.setTotalRecordCount(totCnt);

		List<DealUserVO> list = dealUserService.selectListDealUserBuyer(vo); //
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("dealUserlist", list);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/shop/user/deal/dealUserBuyerList";

	}
	@RequestMapping(value="/shop/user/deal/dealUserBuyerDetail.do")
	public String selectDealUserBuyerDetail(HttpServletRequest request, DealUserVO vo, Model model) {
		System.out.println("DealUserController selectDealUserBuyerDetail Start...");
		vo = dealUserService.selectDealUserBuyerDetail(vo);
		model.addAttribute("dealUserVO", vo);
		return "/shop/user/deal/dealUserBuyerDetail";	
	}
	
	@RequestMapping(value="/shop/user/deal/dealUserBuyerIng.do")
	public String updateDealUserBuyerDetail(HttpServletRequest request, DealUserVO vo, Model model) {
		System.out.println("DealUserController updateDealUserBuyerDetail Start...");
		int result = dealUserService.updateDealUserBuyerDetail(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "redirect:/shop/user/deal/dealUserBuyerList.do?d_idx=" + d_idx;	
	}

	@RequestMapping(value="/shop/user/deal/dealUserBuyerCancel.do")
	public String updateDealUserBuyerCancel(HttpServletRequest request, DealUserVO vo, Model model) {
		System.out.println("DealUserController updateDealUserBuyerCancel Start...");
		int result = dealUserService.updateDealUserBuyerCancel(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "redirect:/shop/user/deal/dealUserBuyerList.do?d_idx=" + d_idx;	
	}
	@RequestMapping(value="/shop/user/deal/dealUserBuyerComplete.do")
	public String updateDealUserBuyerComplete(HttpServletRequest request, DealUserVO vo, Model model) {
		System.out.println("DealUserController updateDealUserBuyerComplete Start...");
		int result = dealUserService.updateDealUserBuyerComplete(vo);
		int result1 = dealUserService.updateDealUserBuyerD_edate(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "redirect:/shop/user/deal/dealUserBuyerDetail.do?d_idx=" + d_idx;
	}
	
	// 판매자
	@RequestMapping(value = "/shop/user/deal/dealUserSellerList.do")
	public String listDealUserSeller(@ModelAttribute("searchVO") DealUserVO vo, HttpServletRequest request, Model model, 
			@RequestParam(value = "pageIndex", required=false, defaultValue="1") int pageIndex) {
		vo.setPageIndex(pageIndex);
		System.out.println("listUserSeller pageIndex => " + vo.getPageIndex());
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = dealUserService.selectListCntDealUserSeller(vo); //
		paginationInfo.setTotalRecordCount(totCnt);

		List<DealUserVO> list = dealUserService.selectListDealUserSeller(vo); //
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("dealUserlist", list);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/shop/user/deal/dealUserSellerList";
	}	
	
	
	
	
	@RequestMapping(value="/shop/user/deal/dealUserSellerDetail.do")
	public String selectDealUserSellerDetail(HttpServletRequest request, DealUserVO vo, Model model) {
		System.out.println("DealMngController selectDealUserSellerDetail Start...");
		vo = dealUserService.selectDealUserSellerDetail(vo);
		/*vo = dealMngService.selectDealMngBuyerScore(vo);*/
		
		model.addAttribute("dealUserVO", vo);
		return "/shop/user/deal/dealUserSellerDetail";	
	}
	
	@RequestMapping(value="/shop/user/deal/dealUserSellerAccept.do")
	public String updateDealUserSellerAccept(HttpServletRequest request, DealUserVO vo, Model model) {
		System.out.println("DealUserController updateDealUserSellerAccept Start...");
		int result = dealUserService.updateDealUserSellerAccept(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "forward:/shop/user/deal/dealUserSellerDetail.do";
	}
	
	@RequestMapping(value="/shop/user/deal/dealUserSellerCancel.do")
	public String updateDealUserSellerCancel(HttpServletRequest request, DealUserVO vo, Model model) {
		System.out.println("DealUserController updateDealUserSellerCancel Start...");
		int result = dealUserService.updateDealUserSellerCancel(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "forward:/shop/user/deal/dealUserSellerDetail.do";
	}

	@RequestMapping(value="/shop/user/deal/dealUserSellerDeliver.do")
	public String updateDealUserSellerDeliver(HttpServletRequest request, DealUserVO vo, Model model) {
		System.out.println("DealUserController updateDealUserSellerDeliver Start...");
		int result = dealUserService.updateDealUserSellerDeliver(vo);
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		int d_idx = vo.getD_idx();
		return "forward:/shop/user/deal/dealUserSellerDetail.do";
	}

}