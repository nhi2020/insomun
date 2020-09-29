package egovframework.let.shop.mng.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovReviewMngDAO")
public class ReviewMngDAO extends EgovAbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<ReviewMngVO> selectMngList(ReviewMngVO mngVO) throws Exception{
		return (List<ReviewMngVO>) list("EgovMngReviewDAO.selectMngProList",mngVO);
	}
}
