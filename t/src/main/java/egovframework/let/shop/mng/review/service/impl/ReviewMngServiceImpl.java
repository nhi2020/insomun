package egovframework.let.shop.mng.review.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.review.service.ReviewMngService;
import egovframework.let.shop.mng.review.service.ReviewVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovReviewService")
public class ReviewMngServiceImpl extends EgovAbstractServiceImpl implements ReviewMngService {

	@Resource(name="EgovReviewDAO")
	private ReviewMngDAO egovReviewwDAO;
	
	@Override
	public List<ReviewVO> selectReviewList(ReviewVO reviewVO) throws Exception {
		List<ReviewVO> list = egovReviewwDAO.selectReviewList(reviewVO);
		return list;
	}

}
