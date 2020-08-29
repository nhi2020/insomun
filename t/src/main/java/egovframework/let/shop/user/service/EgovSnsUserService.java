package egovframework.let.shop.user.service;

import java.util.List;

public interface EgovSnsUserService {
	
	public int insertSnsUserList(SnsProfileVO snsProfileVo)throws Exception;
	
	public int checkUserLogin(SnsProfileVO snsProfileVo)throws Exception;
}
