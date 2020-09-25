package egovframework.let.shop.mng.admin.service;

import java.util.List;

import egovframework.let.shop.mng.admin.service.impl.AdminVO;


public interface AdminService {

	public String selectLoginCheck(AdminVO adminvo)  throws Exception;

	public List<AdminVO> selectListLoginCheck(AdminVO adminvo)throws Exception;
}
