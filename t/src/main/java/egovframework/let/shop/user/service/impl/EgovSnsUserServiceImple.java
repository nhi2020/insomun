package egovframework.let.shop.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.service.EgovSnsUserService;
import egovframework.let.shop.user.service.SnsProfileVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovSnsUserService")
public class EgovSnsUserServiceImple extends EgovAbstractServiceImpl implements EgovSnsUserService{

	@Resource(name = "EgovSnsUserDAO")
	private EgovSnsUserDAO snsUserDAO;

	
	public List<SnsProfileVO> insertSnsUserList(SnsProfileVO snsProfileVo) throws Exception {
		List<SnsProfileVO> list = snsUserDAO.insertSnsUserList(snsProfileVo);
		return list;
	}
	
}
