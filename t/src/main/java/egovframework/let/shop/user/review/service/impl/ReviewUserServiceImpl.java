package egovframework.let.shop.user.review.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.review.service.ReviewUserService;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovReviewUserService")
public class ReviewUserServiceImpl extends EgovAbstractServiceImpl implements ReviewUserService {

	@Resource(name="EgovReviewUserDAO")
	private ReviewUserDAO egovReviewDAO;
	
	//리뷰 후기 전체보기
	@Override
	public List<ReviewUserVO> selectReviewList(ReviewUserVO reviewVO) throws Exception {
		List<ReviewUserVO> list = egovReviewDAO.selectReviewList(reviewVO);
		return list;
	}

	//사용자가 작성한 후기 삭제
	@Override
	public int delUserReview(ReviewUserVO reviewVO) throws Exception {
		int result = egovReviewDAO.delUserReview(reviewVO);
		return result;
	}

	//사용자가 작성한 후기 수정
	@Override
	public int updateUserReview(ReviewUserVO reviewVO) throws Exception {
		int result = egovReviewDAO.updateUserReview(reviewVO);
		return result;
	}

	@Override
	public List<ReviewUserVO> insertMainUserReview(ReviewUserVO reviewVO) throws Exception {
		List<ReviewUserVO> list = egovReviewDAO.insertMainUserReview(reviewVO);
		return list;
	}

}
