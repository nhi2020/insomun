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

	public int adminListCnt(AdminVO vo) {
		System.out.println("AdminListCnt");
		int count = 0;
		try{
			count = (int)select("AdminListCnt", vo);
		} catch(Exception e) {
			System.out.println("AdminListCnt Exception " + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<AdminVO> selectList(AdminVO vo) {
		System.out.println("selectList");
		return (List<AdminVO>) list ("AdminDAO.adminList",vo);
	}

	public static int adminDelete(AdminVO adminVO) {
		int result = adminDelete(adminVO); 
		return result;
	}

	public static AdminVO adminSelect(AdminVO adminVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int adminUpdate(AdminVO adminVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int adminInsert(AdminVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
