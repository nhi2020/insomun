package egovframework.let.shop.user.review.service;

import java.util.List;

public interface ReviewUserService {

	public List<ReviewUserVO> selectReviewList(ReviewUserVO reviewVO) throws Exception;
}
