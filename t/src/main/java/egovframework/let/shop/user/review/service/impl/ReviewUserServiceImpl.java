package egovframework.let.shop.user.review.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.review.service.ReviewMngService;
import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.let.shop.user.review.service.ReviewUserService;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovReviewUserService")
public class ReviewUserServiceImpl extends EgovAbstractServiceImpl implements ReviewUserService {

	@Resource(name="EgovReviewUserDAO")
	private ReviewUserDAO egovReviewDAO;
	
	@Override
	public List<ReviewUserVO> selectReviewList(ReviewUserVO reviewVO) throws Exception {
		List<ReviewUserVO> list = egovReviewDAO.selectReviewList(reviewVO);
		return list;
	}

	@Override
	public List<ReviewUserVO> delUserReview(ReviewUserVO reviewVO) throws Exception {
		List<ReviewUserVO> list = egovReviewDAO.delUserReview(reviewVO);
		return list;
	}

}