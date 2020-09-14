package egovframework.let.shop.review.service;

import java.util.List;

public interface EgovReviewService {

	public List<ReviewVO> selectReviewList(ReviewVO reviewVO) throws Exception;
}
