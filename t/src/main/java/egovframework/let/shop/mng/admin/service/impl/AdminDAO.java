package egovframework.let.shop.mng.admin.service.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("AdminDAO")
public class AdminDAO extends EgovAbstractDAO{

	public String selectLoginCheck(AdminVO adminvo) {

		return (String) select("AdminDAO.selectLoginCheck",adminvo);
	}

	public List<AdminVO> selectListLoginCheck(AdminVO adminvo) {
		
		return (List<AdminVO>) list("AdminDAO.selectListLoginCheck",adminvo);
	}

}
