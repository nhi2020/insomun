package egovframework.let.shop.user.review.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ReviewUserService {
	
	//리뷰 전체출력
	public List<ReviewUserVO> selectReviewList(ReviewUserVO reviewVO) throws Exception;
	
	//사용자가 작성한 본인 리뷰 삭제
	public int delUserReview(ReviewUserVO reviewVO) throws Exception;
	
	//사용자가 작성한 본인 리뷰 업데이트
	public int updateUserReview(ReviewUserVO reviewVO) throws Exception;
	
	//상품상세에대한 리뷰
	public int insertMainUserReview(ReviewUserVO reviewVO) throws Exception;
	
	//구매자 상품사진 리뷰
	public int insertPicReview(HttpServletRequest request) throws Exception;
	
	//사진번호 출력
	public List<String> pic_idx(ReviewUserVO reviewVO) throws Exception;
	
	//상품사진 인덱스 출력
	public List<String> selectReviewAvg(ReviewUserVO reviewVO) throws Exception;
}
