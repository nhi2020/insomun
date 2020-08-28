package egovframework.let.shop.user.service;

import java.util.List;

public interface EgovSnsUserService {
	
	public int insertSnsUserList(SnsProfileVO snsProfileVo)throws Exception;
	
	public List<String> checkUserLogin(SnsProfileVO snsProfileVo)throws Exception;
}
