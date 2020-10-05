package egovframework.let.shop.user.snsprofile.service;

import java.util.List;

public interface SnsProfileUserService {
	
	public List<SnsProfileUserVO> selectSnsUserList(SnsProfileUserVO snsProfileVo) throws Exception;
	
	public String insertSnsUser(SnsProfileUserVO snsProfileVo)throws Exception;
	
	public int checkUserLogin(SnsProfileUserVO vo)throws Exception;
}
