package egovframework.let.shop.intercepter;

import egovframework.com.cmm.LoginVO;

import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

/**
 * 인증여부 체크 인터셉터
 * 
 * @author 공통서비스 개발팀 서준식
 * @since 2011.07.01
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2011.07.01  서준식          최초 생성
 *  2011.09.07  서준식          인증이 필요없는 URL을 패스하는 로직 추가
 *  2014.06.11  이기하          인증이 필요없는 URL을 패스하는 로직 삭제(xml로 대체)
 *      </pre>
 */

public class MngLoginInterceptor extends WebContentInterceptor {

	/**
	 * 세션에 계정정보(LoginVO)가 있는지 여부로 인증 여부를 체크한다. 계정정보(LoginVO)가 없다면, 로그인 페이지로
	 * 이동한다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {
		System.out.println("MngLoginInterceptor");
		
		// 세션에서 로그인 정보를 취득
		HttpSession session = request.getSession();
		String a_id = (String) session.getAttribute("A_ID");
		
		if (a_id == null || a_id.equals("")) {
			System.out.println("관리자 권한 없음 => 로그인 페이지로 리다이렉트 합니다.");
			try {
				response.sendRedirect("/shop/mng/admin/AdminLogin.do");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 컨트롤러로 요청을 넘기지 않기 위해 false로 처리한다.
			return false;
		}
		
		// true로 처리될 경우 인터셉터가 작업된 이후 정상적으로 컨트롤러에 매핑된다.
		return true;
	}

}
