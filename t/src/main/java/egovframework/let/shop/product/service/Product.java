package egovframework.let.shop.product.service;

import java.io.Serializable;

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

	private int p_idx;


	public int getP_idx() {
		return p_idx;
	}


	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}


	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
