package egovframework.let.shop.mng.snsprofile.service;

import java.util.List;

public interface SnsProfileMngSerivce {
	
	public List<SnsProfileMngVO> selectSnsUserList(SnsProfileMngVO snsProfileVo) throws Exception;
	
	public String insertSnsUser(SnsProfileMngVO snsProfileVo)throws Exception;
	
	public int checkUserLogin(SnsProfileMngVO vo)throws Exception;
}
