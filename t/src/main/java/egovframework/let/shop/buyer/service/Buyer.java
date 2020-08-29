package egovframework.let.shop.buyer.service;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Buyer implements Serializable {
	private String b_id;
	private String b_snscode;
	private String b_nickname;
	private String b_email;
	private String b_photo;
	private String b_status;
	private String b_addr;
	private String b_idx;
	private String b_gender;

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_snscode() {
		return b_snscode;
	}

	public void setB_snscode(String b_snscode) {
		this.b_snscode = b_snscode;
	}

	public String getB_nickname() {
		return b_nickname;
	}

	public void setB_nickname(String b_nickname) {
		this.b_nickname = b_nickname;
	}

	public String getB_email() {
		return b_email;
	}

	public void setB_email(String b_email) {
		this.b_email = b_email;
	}

	public String getB_photo() {
		return b_photo;
	}

	public void setB_photo(String b_photo) {
		this.b_photo = b_photo;
	}

	public String getB_status() {
		return b_status;
	}

	public void setB_status(String b_status) {
		this.b_status = b_status;
	}

	public String getB_addr() {
		return b_addr;
	}

	public void setB_addr(String b_addr) {
		this.b_addr = b_addr;
	}

	public String getB_idx() {
		return b_idx;
	}

	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}

	public String getB_gender() {
		return b_gender;
	}

	public void setB_gender(String b_gender) {
		this.b_gender = b_gender;
	}

}
