package egovframework.let.shop.user.review.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	//리뷰 후기 전체보기 , 페이징 처리
	@RequestMapping(value = "/shop/user/review/reviewList.do")
	public String selectReviewList(ReviewUserVO vo, ModelMap model) throws Exception{
		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		//vo.setP_idx(1);
		List<ReviewUserVO> list = egovReviewService.selectReviewList(vo);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		return "/shop/user/review/EgovShopReview";
	}
	//마이바티스,아이바티스에서는 업데이트할때 결과값을 int(0 , 1) 로 받아주기때문에
	//int 로 받아주어야한다. (0은 실패 1은 성공)
	
	//사용자가 작성한 후기 삭제
	@RequestMapping(value ="/shop/user/review/delUserReview.do")
	public String delUserReview(ReviewUserVO reviewVO) throws Exception{
		
		int result = egovReviewService.delUserReview(reviewVO);
		if (result == 0) {
			System.out.println("후기 삭제 실패");
		}else{
			System.out.println("후기 삭제 성공");
		}
		return "forward:/shop/user/review/reviewList.do";
	}
	//사용자가 작성한 후기 수정
	@RequestMapping(value ="/shop/user/review/updateUserReview.do")
	public String updateUserReview(ReviewUserVO reviewVO) throws Exception{
		int result = egovReviewService.updateUserReview(reviewVO);
		if (result == 0) {
			System.out.println("후기 수정 실패");
		}else{
			System.out.println("후기 수정 성공");
		}
		return "redirect:/shop/user/review/reviewList.do";
	}
	//상품상세애대한 리뷰 작성
	@RequestMapping(value = "/shop/user/review/insertUserReview.do", method = RequestMethod.POST)
	public String list(ReviewUserVO reviewVO, ModelMap model) throws Exception {
		System.out.println("---------------------------mainReview insert Start");
		
		egovReviewService.insertMainUserReview(reviewVO);
		
		return "redirect:/shop/user/review/reviewList.do?p_idx="+reviewVO.getP_idx();
	}
}
