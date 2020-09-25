package egovframework.let.shop.user.review.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.shop.user.review.service.ReviewUserService;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class ReviewUserController {

	@Resource(name = "EgovReviewUserService")
	private ReviewUserService egovReviewService;
	
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
	
	@RequestMapping(value = "/shop/user/review/reviewList.do")
	public String list(ReviewUserVO reviewvo, HttpServletRequest request, ModelMap model) throws Exception{
		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(reviewvo.getPageIndex());
		paginationInfo.setRecordCountPerPage(reviewvo.getPageUnit());
		paginationInfo.setPageSize(reviewvo.getPageSize());

		reviewvo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		reviewvo.setLastIndex(paginationInfo.getLastRecordIndex());
		reviewvo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		List<ReviewUserVO> list = egovReviewService.selectReviewList(reviewvo);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		return "/shop/user/review/EgovShopReview";
	}
	
	@RequestMapping(value ="/shop/user/review/delUserReview.do")
	public String delUserReview(ReviewUserVO reviewVO) throws Exception{
		egovReviewService.delUserReview(reviewVO);
		return "forward:/shop/user/review/reviewList.do";
	}
}