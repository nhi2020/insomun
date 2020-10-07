package egovframework.let.shop.mng.log.service;

import java.util.List;

import egovframework.let.shop.mng.log.service.impl.LogMngVO;

public interface LogMngService {
	
	List<LogMngVO> selectMngLogList(LogMngVO logVO) throws Exception;

	int selectMngLogListCnt(LogMngVO logVO) throws Exception;
	
/*	int updateMngLogPro(LogMngVO vo);

	int insertMngLogPro(LogMngVO vo);*/


}
