package egovframework.let.shop.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.review.service.ReviewVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("ReviewDAO")
public class EgovReviewDAO extends EgovAbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<ReviewVO> selectReviewList(ReviewVO reviewvo) throws Exception{
		return (List<ReviewVO>) list("EgovReviewDAO.selectReviewList",reviewvo);
	}
	
}
