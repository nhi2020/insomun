package egovframework.let.shop.mng.log.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.log.service.impl.LogMngVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovMngLogDAO")
public class LogMngDAO extends EgovAbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<LogMngVO> selectMngLogList(LogMngVO logMngVO) throws Exception {
		return (List<LogMngVO>) list("EgovMngLogDAO.selectMngLogList", logMngVO );
	}
	
	public int selectMngLogListCnt (LogMngVO logMngVO) throws Exception {
		return (Integer)select("EgovMngLogDAO.selectMngLogListCnt", logMngVO);
	}
	
	/*public int updateMngLog(LogMngVO vo) {
		int result = 0;
		try {
			result = update("EgovMngLogDAO.updateMngLog", vo);
		} catch (Exception e) {
			System.out.println("updateMngLog Exception" + e.getMessage());
		}
		return result;
	}
	
	public int insertMngLog(LogMngVO vo) {
		int result =(Integer) insert("EgovMngLogDAO.insertMngLog", vo);
		return result;
	}*/
	

	
}
	
	