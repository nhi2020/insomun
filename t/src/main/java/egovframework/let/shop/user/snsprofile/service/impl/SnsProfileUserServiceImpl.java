package egovframework.let.shop.user.snsprofile.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.snsprofile.service.SnsProfileUserSerivce;
import egovframework.let.shop.user.snsprofile.service.SnsProfileUserVO;

@Service("SnsProfileUserSerivce")
public class SnsProfileUserServiceImpl implements SnsProfileUserSerivce{
	
	@Resource(name = "SnsProfileUserDAO")
	SnsProfileUserDAO sd;

	@Override
	public SnsProfileUserVO selectUserSnsprofile(SnsProfileUserVO vo) {

		return sd.selectUserSnsprofile(vo);
	}
	

}
