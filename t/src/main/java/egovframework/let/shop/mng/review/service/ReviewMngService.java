package egovframework.let.shop.mng.review.service;

import java.util.List;

public interface ReviewMngService {

	public List<ReviewMngVO> selectMngList(ReviewMngVO reviewVO) throws Exception;
	
	public int delMngReview(ReviewMngVO vo) throws Exception;
}
