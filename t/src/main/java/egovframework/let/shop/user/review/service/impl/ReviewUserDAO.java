package egovframework.let.shop.user.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

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
	public int delUserReview(ReviewUserVO reviewVO) throws Exception{
		int result = update("EgovReviewDAO.delUserReview",reviewVO);
		return result;
	}
	//사용자가 작성한 후기 수정
	public int updateUserReview(ReviewUserVO reviewVO) throws Exception{
		int result = update("EgovReviewDAO.updateUserReview", reviewVO);
		return result;
	}
	//상품상세에대한 리뷰
	public int insertMainUserReview(ReviewUserVO reviewVO) throws Exception{
		int result = (Integer) insert("EgovReviewDAO.insertMainUserReview",reviewVO);
		return result;
	}
	//상품 후기사진 올리기
	public int insertPicReview(ReviewUserVO reviewVO) throws Exception{
		int result = (Integer) insert("EgovReviewDAO.insertUserPicReview", reviewVO);
		return result;
	}
}
