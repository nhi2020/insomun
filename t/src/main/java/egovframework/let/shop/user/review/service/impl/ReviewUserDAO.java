package egovframework.let.shop.user.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovReviewUserDAO")
public class ReviewUserDAO extends EgovAbstractDAO {
	
	//리뷰 후기 전체보기
	@SuppressWarnings("unchecked")
	public List<ReviewUserVO> selectReviewList(ReviewUserVO reviewvo) throws Exception{
		return (List<ReviewUserVO>) list("EgovReviewDAO.selectReviewList",reviewvo);
	}
	//사용자가 작성한 후기 삭제
	@SuppressWarnings("unchecked")
	public List<ReviewUserVO> delUserReview(ReviewUserVO reviewVO) throws Exception{
		return (List<ReviewUserVO>) list("EgovReviewDAO.delUserReview",reviewVO);
		
	}
	
}
