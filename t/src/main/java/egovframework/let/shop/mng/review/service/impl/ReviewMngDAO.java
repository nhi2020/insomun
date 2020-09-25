package egovframework.let.shop.mng.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.review.service.ReviewVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovReviewDAO")
public class ReviewMngDAO extends EgovAbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<ReviewVO> selectReviewList(ReviewVO reviewvo) throws Exception{
		return (List<ReviewVO>) list("EgovReviewDAO.selectReviewList",reviewvo);
	}
	
}
