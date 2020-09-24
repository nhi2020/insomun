package egovframework.let.shop.deal.dto;

import java.sql.Date;

public class deal {
	private String s_id;
	private int sns_idx;
	private int d_idx;
	private int p_idx;
	private String d_ing;
	private String d_q;
	private Date d_regdate;
	private Date d_edate;

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
	public int getD_idx() {
		return d_idx;
	}
	public void setD_idx(int d_idx) {
		this.d_idx = d_idx;
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public String getD_ing() {
		return d_ing;
	}
	public void setD_ing(String d_ing) {
		this.d_ing = d_ing;
	}
	public String getD_q() {
		return d_q;
	}
	public void setD_q(String d_q) {
		this.d_q = d_q;
	}
	public Date getD_regdate() {
		return d_regdate;
	}
	public void setD_regdate(Date d_regdate) {
		this.d_regdate = d_regdate;
	}
	public Date getD_edate() {
		return d_edate;
	}
	public void setD_edate(Date d_edate) {
		this.d_edate = d_edate;
	}
	
	
}
