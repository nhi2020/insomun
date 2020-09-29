package egovframework.let.shop.mng.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import egovframework.let.shop.mng.admin.service.AdminService;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

	@Resource(name="AdminDAO")
	private AdminDAO adminDAO;
	
	@Override
	public String selectLoginCheck(AdminVO adminvo) throws Exception {
		
		return adminDAO.selectLoginCheck(adminvo);
	}

	@Override
	public List<AdminVO> selectListLoginCheck(AdminVO adminvo) throws Exception {
		
		return (List<AdminVO>) adminDAO.selectListLoginCheck(adminvo);
	}

	@Override
	public int selectListCnt(AdminVO vo) {
		int cnt = adminDAO.adminListCnt(vo);
		return cnt;
	}

	@Override
	public List<AdminVO> selectList(AdminVO vo) {
		List<AdminVO> list = adminDAO.selectList(vo);
		return list;
	}

	@Override
	public int delAdminControl(AdminVO adminVO) {
		int result = AdminDAO.adminDelete(adminVO);
		return result;
	}

	@Override
	public AdminVO adminSelect(AdminVO adminVO) {
		adminVO = AdminDAO.adminSelect(adminVO);
		return adminVO;
	}

	@Override
	public int adminUpdate(AdminVO adminVO) {
		int result = AdminDAO.adminUpdate(adminVO);
		return result;
	}

	@Override
	public int insertMngAdminControl(AdminVO vo) {
		int result = AdminDAO.adminInsert(vo);
		return result;
	}

}
