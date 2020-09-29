package egovframework.let.shop.mng.review.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.shop.mng.review.service.ReviewMngService;
import egovframework.let.shop.mng.review.service.ReviewMngVO;

@Controller
public class ReviewMngController {
	
	@Resource(name ="EgovMngReview")
	private ReviewMngService reviewMngService;
	
	@RequestMapping(value = "/shop/mng/review.MngSelect.do")
	public String selectMngList(ReviewMngVO mngVO, ModelMap model) throws Exception {
		List<ReviewMngVO> list = reviewMngService.selectMngList(mngVO);
		model.addAttribute("list", list);
		return "/shop/mng/review/EgovMngReview";
	}
}
