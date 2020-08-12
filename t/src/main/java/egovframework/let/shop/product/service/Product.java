package egovframework.let.shop.product.service;

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
public class Product implements Serializable {

	private int m_id;
	private int p_idx;
	private String product_name;
	private String price;
	private String reg_date;
	private String update_date;
	private String main_img;
	private String main_path;
	private Date sub_img;
	private Date d_loc;
	private Date d_how;
	private String d_when;
	private String d_cost;
	private String product_method;
	private String p_sdate;
	private String p_edate;
	private String del_yn;


	public String getDel_yn() {
		return del_yn;
	}


	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}



	public int getM_id() {
		return m_id;
	}



	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getP_idx() {
		return p_idx;
	}



	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getReg_date() {
		return reg_date;
	}



	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}



	public String getUpdate_date() {
		return update_date;
	}



	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}



	public String getMain_img() {
		return main_img;
	}



	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}



	public String getMain_path() {
		return main_path;
	}



	public void setMain_path(String main_path) {
		this.main_path = main_path;
	}



	public Date getSub_img() {
		return sub_img;
	}



	public void setSub_img(Date sub_img) {
		this.sub_img = sub_img;
	}



	public Date getD_loc() {
		return d_loc;
	}



	public void setD_loc(Date d_loc) {
		this.d_loc = d_loc;
	}



	public Date getD_how() {
		return d_how;
	}



	public void setD_how(Date d_how) {
		this.d_how = d_how;
	}



	public String getD_when() {
		return d_when;
	}



	public void setD_when(String d_when) {
		this.d_when = d_when;
	}



	public String getD_cost() {
		return d_cost;
	}



	public void setD_cost(String d_cost) {
		this.d_cost = d_cost;
	}



	public String getProduct_method() {
		return product_method;
	}



	public void setProduct_method(String product_method) {
		this.product_method = product_method;
	}



	public String getP_sdate() {
		return p_sdate;
	}



	public void setP_sdate(String p_sdate) {
		this.p_sdate = p_sdate;
	}



	public String getP_edate() {
		return p_edate;
	}



	public void setP_edate(String p_edate) {
		this.p_edate = p_edate;
	}



	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
