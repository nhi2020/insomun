package egovframework.let.shop.mng.log.service;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LogMng implements Serializable {
	
	private int 	log_idx;  // 등록 번호
	private String 	s_id;	  // 판매자 아이디
	private int 	sns_idx;  // 구매자 아이디
	private String 	a_id;	  // 운영자 아이디
	private String 	log_ip;	  // IP 주소
	private String 	log_date; // 등록일
	
	public int getLog_idx() {
		return log_idx;
	}
	public void setLog_idx(int log_idx) {
		this.log_idx = log_idx;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public int getSns_idx() {
		return sns_idx;
	}
	public void setSns_idx(int sns_idx) {
		this.sns_idx = sns_idx;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getLog_ip() {
		return log_ip;
	}
	public void setLog_ip(String log_ip) {
		this.log_ip = log_ip;
	}
	public String getLog_date() {
		return log_date;
	}
	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}
	
}
