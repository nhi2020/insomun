package egovframework.let.shop.user.review.service;

import java.util.List;

public interface ReviewUserService {
	
	//리뷰 전체출력
	public List<ReviewUserVO> selectReviewList(ReviewUserVO reviewVO) throws Exception;
	
	//사용자가 작성한 본인 리뷰 삭제
	public int delUserReview(ReviewUserVO reviewVO) throws Exception;
	
	//사용자가 작성한 본인 리뷰 업데이트
	public int updateUserReview(ReviewUserVO reviewVO) throws Exception;
	
	//상품상세에대한 리뷰
	public int insertMainUserReview(ReviewUserVO reviewVO) throws Exception;
}
