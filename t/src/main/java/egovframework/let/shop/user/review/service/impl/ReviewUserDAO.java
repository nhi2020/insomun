package egovframework.let.shop.user.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovReviewUserDAO")
public class ReviewUserDAO extends EgovAbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<ReviewUserVO> selectReviewList(ReviewUserVO reviewvo) throws Exception{
		return (List<ReviewUserVO>) list("EgovReviewDAO.selectReviewList",reviewvo);
	}
	
}
