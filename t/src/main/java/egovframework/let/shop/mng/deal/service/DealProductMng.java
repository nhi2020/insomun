package egovframework.let.shop.mng.deal.service;

import java.sql.Date;

public class DealProductMng {
	// Deal
	private String s_id;
	private int sns_idx;
	private int d_idx;
	private int p_idx;
	private String d_ing;
	private int d_q;
	private Date d_regdate;
	private Date d_edate;

	// Product
	// private int p_idx; 테이블 중복값 생략
	// private String s_id; 테이블 중복값 생략
	private String p_name;
	private String p_price;
	private Date p_regdate;
	private Date p_moddate;
	private String p_image;
	private String p_content;
	private String p_tage;
	private Date p_sdate;
	private Date p_edate;
	private String p_status;
	private String a_id;
	private String p_q;

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
	public int getD_q() {
		return d_q;
	}
	public void setD_q(int d_q) {
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
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_price() {
		return p_price;
	}
	public void setP_price(String p_price) {
		this.p_price = p_price;
	}
	public Date getP_regdate() {
		return p_regdate;
	}
	public void setP_regdate(Date p_regdate) {
		this.p_regdate = p_regdate;
	}
	public Date getP_moddate() {
		return p_moddate;
	}
	public void setP_moddate(Date p_moddate) {
		this.p_moddate = p_moddate;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_tage() {
		return p_tage;
	}
	public void setP_tage(String p_tage) {
		this.p_tage = p_tage;
	}
	public Date getP_sdate() {
		return p_sdate;
	}
	public void setP_sdate(Date p_sdate) {
		this.p_sdate = p_sdate;
	}
	public Date getP_edate() {
		return p_edate;
	}
	public void setP_edate(Date p_edate) {
		this.p_edate = p_edate;
	}
	public String getP_status() {
		return p_status;
	}
	public void setP_status(String p_status) {
		this.p_status = p_status;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getP_q() {
		return p_q;
	}
	public void setP_q(String p_q) {
		this.p_q = p_q;
	}
	
}
