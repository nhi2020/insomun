package egovframework.let.shop.user.review.service;

import java.util.List;

public interface ReviewUserService {
	
	//리뷰 전체출력
	public List<ReviewUserVO> selectReviewList(ReviewUserVO reviewVO) throws Exception;
	
	//리뷰 삭제
	public List<ReviewUserVO> delUserReview(ReviewUserVO reviewVO) throws Exception;
}
