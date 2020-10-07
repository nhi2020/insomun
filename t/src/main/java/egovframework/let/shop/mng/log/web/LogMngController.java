package egovframework.let.shop.mng.log.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import egovframework.let.shop.mng.log.service.LogMngService;
import egovframework.let.shop.mng.log.service.impl.LogMngVO;
import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class LogMngController {

	/**
	 * EgovBBSManageService
	 */
	@Resource(name = "EgovMngLogService")
	private LogMngService mngLogService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	/*
	 * @Resource(name ="EgovReviewService") protected ReviewMngService
	 * reviewService;
	 */
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

	@RequestMapping(value = "/shop/mng/log/EgovMngLogList")
	public String forwardPageWithMenuNo(@ModelAttribute("searchVO") LogMngVO vo, HttpServletRequest request,
			ModelMap model, ReviewMngVO vo2) throws Exception {
		System.out.println("test");
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = mngLogService.selectMngLogListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<LogMngVO> list = mngLogService.selectMngLogList(vo);
		System.out.println("test" + list.get(0).getS_id());
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);

		// 리뷰 관련 //

		/*
		 * List<ReviewVO> list2 = reviewService.selectReviewList(vo2);
		 * model.addAttribute("list2", list);
		 */

		// 리뷰 관련 //
		return "/shop/mng/log/EgovMngLogList";
	}

	/*@RequestMapping(value = "/shop/mng/log/EgovMngLogUpdatePro", method = RequestMethod.POST)
	public String egovMngLogUpdatePro(LogMngVO vo, Model model) throws Exception {
		int result = mngLogService.updateMngLogPro(vo);
		System.out.println("vo Log_Date=> " + vo.getLog_date());
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		model.addAttribute("vo");

		return "forward:/shop/mng/log/EgovMngLogUpdateForm.do";

	}

	@RequestMapping(value = "/shop/mng/log/EgovMngLogInsertForm")
	public String EgovMngLogInsertForm() {
		return "/shop/mng/log/EgovMngLogInsertForm";
	}

	@RequestMapping(value = "/shop/mng/log/EgovMngLogInsertPro", method = RequestMethod.POST)
	public String EgovMngLogInsertPro(LogMngVO vo, Model model, HttpServletRequest request) throws Exception {
		System.out.println("INSERT");
		HttpSession session = request.getSession();
		String a_id = (String) session.getAttribute("A_ID");
		System.out.println("a_id" + a_id);
		System.out.println("INSERT");
		vo.setS_id(a_id);
		mngLogService.insertMngLogPro(vo);

		return "redirect:/shop/mng/log/EgovMngLogInsertForm.do";
*/
	}

