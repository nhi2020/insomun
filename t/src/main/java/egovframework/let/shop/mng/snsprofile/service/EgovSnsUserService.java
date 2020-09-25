package egovframework.let.shop.mng.snsprofile.service;

import java.util.List;

public interface EgovSnsUserService {
	
	public List<SnsProfileVO> selectSnsUserList(SnsProfileVO snsProfileVo) throws Exception;
	
	public String insertSnsUser(SnsProfileVO snsProfileVo)throws Exception;
	
	public int checkUserLogin(SnsProfileVO vo)throws Exception;
}
