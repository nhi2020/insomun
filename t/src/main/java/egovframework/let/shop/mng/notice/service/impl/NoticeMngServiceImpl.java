package egovframework.let.shop.mng.notice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.notice.service.NoticeMngDAO;
import egovframework.let.shop.mng.notice.service.NoticeMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("NoticeMngService")
public class NoticeMngServiceImpl extends EgovAbstractServiceImpl implements NoticeMngService{
	
	@Resource(name ="NoticeMngDAO")
	private NoticeMngDAO NoticeDAO;
	
	@Override
	public int selectNoticeMngListCnt(NoticeMngVO vo) {
		int cnt = NoticeDAO.selectNoticeMngListCnt(vo);
		return cnt;
	}

	@Override
	public List<NoticeMngVO> selectNoticeMngList(NoticeMngVO vo) {
		List<NoticeMngVO> list = NoticeDAO.selectNoticeMngList(vo);
		return list;
	}

	@Override
	public NoticeMngVO noticeMngSelect(NoticeMngVO vo) {
		vo = NoticeDAO.noticeMngSelect(vo);
		return vo;
	}

	@Override
	public int noticeMngUpdate(NoticeMngVO vo) {
		int result = NoticeDAO.noticeMngUpdate(vo);
		return result;
	}

	@Override
	public int updateNoticeMngStateChange(NoticeMngVO vo) {
		int result = NoticeDAO.updateNoticeMngStateChange(vo);
		return result;
	}

	@Override
	public String insertNoticeMngPro(NoticeMngVO vo) {
		return NoticeDAO.insertNoticeMngPro(vo);
	}

	@Override
	public int deleteMngNotice(NoticeMngVO vo) {
		return NoticeDAO.deleteMngNotice(vo);
	}

}
