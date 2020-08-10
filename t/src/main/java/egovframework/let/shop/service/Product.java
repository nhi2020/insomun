package egovframework.let.shop.service;

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

	private long idx;
	private String company_nm;
	private String product_nm;
	private String product_con;
	private String ceo;
	private String phone;
	private String addr;
	private String email;
	private String price;
	private Date create_date;
	private Date reg_date;
	private Date update_date;
	private String main_path;
	private String main_img;
	private String sub_path;
	private String sub_img;
	private String del_yn;
	
	public String getCompany_nm() {
		return company_nm;
	}

	public void setCompany_nm(String company_nm) {
		this.company_nm = company_nm;
	}

	public String getProduct_nm() {
		return product_nm;
	}

	public void setProduct_nm(String product_nm) {
		this.product_nm = product_nm;
	}

	public String getProduct_con() {
		return product_con;
	}

	public void setProduct_con(String product_con) {
		this.product_con = product_con;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getMain_path() {
		return main_path;
	}

	public void setMain_path(String main_path) {
		this.main_path = main_path;
	}

	public String getMain_img() {
		return main_img;
	}

	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}

	public String getSub_path() {
		return sub_path;
	}

	public void setSub_path(String sub_path) {
		this.sub_path = sub_path;
	}

	public String getSub_img() {
		return sub_img;
	}

	public void setSub_img(String sub_img) {
		this.sub_img = sub_img;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
