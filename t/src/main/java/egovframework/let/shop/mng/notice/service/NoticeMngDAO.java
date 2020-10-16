package egovframework.let.shop.mng.notice.service;

import java.util.List;

import egovframework.let.shop.mng.notice.service.impl.NoticeMngVO;

public interface NoticeMngDAO {

	int selectNoticeMngListCnt(NoticeMngVO vo);

	List<NoticeMngVO> selectNoticeMngList(NoticeMngVO vo);

	NoticeMngVO noticeMngSelect(NoticeMngVO vo);

	int noticeMngUpdate(NoticeMngVO vo);

	int updateNoticeMngStateChange(NoticeMngVO vo);

	String insertNoticeMngPro(NoticeMngVO vo);

	int deleteMngNotice(NoticeMngVO vo);
}
