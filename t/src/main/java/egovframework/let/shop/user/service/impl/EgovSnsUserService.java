package egovframework.let.shop.user.service;

import java.util.List;

public interface EgovSnsUserService {
	
	public List<SnsProfileVO> selectSnsUserList(SnsProfileVO snsProfileVo)throws Exception;
}
