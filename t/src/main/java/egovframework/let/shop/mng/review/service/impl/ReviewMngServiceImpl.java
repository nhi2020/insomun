package egovframework.let.shop.mng.review.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.review.service.ReviewMngService;
import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovMngReview")
public class ReviewMngServiceImpl extends EgovAbstractServiceImpl implements ReviewMngService {

	@Resource(name = "EgovReviewMngDAO")
	private ReviewMngDAO reviewMngDAO;
	
	@Override
	public List<ReviewMngVO> selectMngList(ReviewMngVO reviewVO) throws Exception {
		List<ReviewMngVO> list = reviewMngDAO.selectMngList(reviewVO);
		return list;
	}

	@Override
	public int delMngReview(ReviewMngVO vo) throws Exception {
		int result = reviewMngDAO.delMngReview(vo);
		return result;
	}
	
}
