package egovframework.let.shop.mng.notice.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.notice.service.NoticeMngDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("NoticeMngDAO")
public class NoticeMngDAOImpl extends EgovAbstractDAO implements NoticeMngDAO {

	@Override
	public int selectNoticeMngListCnt(NoticeMngVO vo) {
		System.out.println("selectNoticeMngListCnt");
		int count = 0;
		try {
			count = (int) select("selectNoticeMngListCnt", vo);

		} catch (Exception e) {
			System.out.println("selectNoticeMngListCnt Exception" + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeMngVO> selectNoticeMngList(NoticeMngVO vo) {
		List<NoticeMngVO> NoticeList = null;

		try {
			NoticeList = (List<NoticeMngVO>) list("selectNoticeMngList", vo);

		} catch (Exception e) {
			System.out.println("selectNoticeMngList Exception" + e.getMessage());
		}

		return NoticeList;
	}

	@Override
	public NoticeMngVO noticeMngSelect(NoticeMngVO vo) {
		try {
			vo = (NoticeMngVO) select("noticeMngSelect", vo);
		} catch (Exception e) {
			System.out.println("noticeMngSelect Exception" + e.getMessage());

		}
		return vo;
	}

	@Override
	public int noticeMngUpdate(NoticeMngVO vo) {
		System.out.println("NoticeMngDAOImpl noticeMngUpdate");
		int result = 0;
		try {
			result = update("noticeMngUpdate", vo);
		} catch (Exception e) {
			System.out.println("noticeMngUpdate Exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateNoticeMngStateChange(NoticeMngVO vo) {
		System.out.println("NoticeMngDaoImpl updateNoticeMngStateChange()");
		int result = 0;
		try {
			result = update("updateNoticeMngStateChange", vo.getN_idx());
		} catch (Exception e) {
			System.out.println("updateNoticeMngStateChange Exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public String insertNoticeMngPro(NoticeMngVO vo) {
		return (String) insert("insertNoticeMngPro", vo);
	}

	@Override
	public int deleteMngNotice(NoticeMngVO vo) {
		System.out.println("NoticeMngDAOImpl deleteMngNotice");
		int result = 0;
		try {
			result = delete("deleteMngNotice", vo);
		} catch (Exception e) {
			System.out.println("deleteMngNotice Exception" + e.getMessage());
		}
		return result;
	}
}
