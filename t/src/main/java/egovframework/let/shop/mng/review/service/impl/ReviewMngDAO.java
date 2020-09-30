package egovframework.let.shop.mng.review.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovReviewMngDAO")
public class ReviewMngDAO extends EgovAbstractDAO {
	
	/*@Autowired
	private SqlSessionTemplate sqlSessionTemplete;*/
	
	@SuppressWarnings("unchecked")
	public List<ReviewMngVO> selectMngList(ReviewMngVO mngVO) throws Exception{
		return (List<ReviewMngVO>) list("EgovMngReviewDAO.selectMngProList",mngVO);
	}
	
	public int delMngReview(ReviewMngVO vo){
		return update("EgovMngReviewDAO.updateMngUserReview",vo);
	}
}
