package egovframework.let.shop.review.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.review.service.EgovReviewService;
import egovframework.let.shop.review.service.ReviewVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovReviewService")
public class EgovReviewServiceImpl extends EgovAbstractServiceImpl implements EgovReviewService {

	@Resource(name="EgovReviewDAO")
	private EgovReviewDAO egovReviewwDAO;
	
	@Override
	public List<ReviewVO> selectReviewList(ReviewVO reviewVO) throws Exception {
		List<ReviewVO> list = egovReviewwDAO.selectReviewList(reviewVO);
		return list;
	}

}
