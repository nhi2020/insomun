package egovframework.let.shop.user.snsprofile.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.user.snsprofile.service.SnsProfileUserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SnsProfileUserDAO")
public class SnsProfileUserDAO extends EgovAbstractDAO {

	public SnsProfileUserVO selectUserSnsprofile(SnsProfileUserVO vo) {
		try {
			vo = (SnsProfileUserVO) select("selectUserSnsprofile", vo);
		} catch (Exception e) {
			System.out.println("SnsProfileUserDAO selectUserSnsprofile Exception : " + e.getMessage());
		}
		return vo;
	}
}
