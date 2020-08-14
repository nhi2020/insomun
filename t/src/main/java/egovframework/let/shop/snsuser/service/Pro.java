package egovframework.let.shop.snsuser.service;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 게시물에 대한 데이터 처리 모델 클래스
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009.03.06
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.06  이삼섭          최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성 
 *  
 *  </pre>
 */
@SuppressWarnings("serial")
public class Pro implements Serializable {

	private String m_id2;
	private String s_email;
	private int p_idx2;
	private String s_id;
	private int j_idx;
	private String m_phone;
	private String m_addr;
	private String j_pro;
	


	public String getM_id2() {
		return m_id2;
	}



	public void setM_id2(String m_id2) {
		this.m_id2 = m_id2;
	}



	public String getS_email() {
		return s_email;
	}



	public void setS_email(String s_email) {
		this.s_email = s_email;
	}



	public int getP_idx2() {
		return p_idx2;
	}



	public void setP_idx2(int p_idx2) {
		this.p_idx2 = p_idx2;
	}



	public String getS_id() {
		return s_id;
	}



	public void setS_id(String s_id) {
		this.s_id = s_id;
	}



	public int getJ_idx() {
		return j_idx;
	}



	public void setJ_idx(int j_idx) {
		this.j_idx = j_idx;
	}



	public String getM_phone() {
		return m_phone;
	}



	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}



	public String getM_addr() {
		return m_addr;
	}



	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}



	public String getJ_pro() {
		return j_pro;
	}



	public void setJ_pro(String j_pro) {
		this.j_pro = j_pro;
	}



	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
