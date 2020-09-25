package egovframework.let.shop.mng.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovReviewDAO")
public class ReviewMngDAO extends EgovAbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<ReviewMngVO> selectReviewList(ReviewMngVO reviewvo) throws Exception{
		return (List<ReviewMngVO>) list("EgovReviewDAO.selectReviewList",reviewvo);
	}
	
}
