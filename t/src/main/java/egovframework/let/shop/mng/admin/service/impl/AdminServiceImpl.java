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

}
