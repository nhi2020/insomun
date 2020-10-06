package egovframework.let.shop.mng.log.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.log.service.LogMngDAO;
import egovframework.let.shop.mng.log.service.LogMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovMngLogService")
public class LogMngServiceImpl extends EgovAbstractServiceImpl implements LogMngService {

	@Resource(name = "EgovMngLogDAO")
	private LogMngDAO logMngDAO;

	@Override
	public int selectMngLogListCnt(LogMngVO logVO) throws Exception {
		int cnt = logMngDAO.selectMngLogListCnt(logVO);
		return cnt;
	}

	@Override
	public List<LogMngVO> selectMngLogList(LogMngVO logVO) throws Exception {
		List<LogMngVO> list = logMngDAO.selectMngLogList(logVO);

		return list;
	}

/*	@Override
	public int updateMngLogPro(LogMngVO vo) {
		int result = logMngDAO.updateMngLog(vo);
		return result;
	}

	@Override
	public int insertMngLogPro(LogMngVO vo) {
		int result = logMngDAO.insertMngLog(vo);
		return result;
	}*/

}
