package egovframework.let.shop.user.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.let.shop.user.service.KakaoAPI;
import egovframework.let.shop.user.service.SnsProfileVO;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * 템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)
 * @author 실행환경 개발팀 JJY
 * @since 2011.08.31
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.08.31  JJY            최초 생성
 *
 * </pre>
 */
@Controller@SessionAttributes(types = ComDefaultVO.class)
public class EgovUserLoginController {

	@Autowired
    private KakaoAPI kakao;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	/**
	 * XSS 방지 처리.
	 *
	 * @param data
	 * @return
	 */
	protected String unscript(String data) {
		if (data == null || data.trim().equals("")) {
			return "";
		}

		String ret = data;

		ret = ret.replaceAll("<(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;script");
		ret = ret.replaceAll("</(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;/script");

		ret = ret.replaceAll("<(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;object");
		ret = ret.replaceAll("</(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;/object");

		ret = ret.replaceAll("<(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;applet");
		ret = ret.replaceAll("</(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;/applet");

		ret = ret.replaceAll("<(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");
		ret = ret.replaceAll("</(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");

		ret = ret.replaceAll("<(F|f)(O|o)(R|r)(M|m)", "&lt;form");
		ret = ret.replaceAll("</(F|f)(O|o)(R|r)(M|m)", "&lt;form");

		return ret;
	}
	
	@RequestMapping(value = "/shop/user/EgovUserLoginForm.do")
	public String egovUserLoginForm(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		String kakaoUrl = kakao.getAuthorizationUrl(session);
		model.addAttribute("kakaoUrl", kakaoUrl);
		return "shop/userLogin/EgovUserLoginForm"; 
	}
	/**
	 * sns 로그인
	 *
	 * @param request
	 * @param commandMap
	 * @exception Exception Exception
	 */
	@RequestMapping(value = "/shop/user/EgovUserLogin.do")
	public String egovUserLogin(@RequestParam("code") String code, SnsProfileVO snsProfileVO, HttpServletRequest request, ModelMap model, HttpSession session)
			  throws Exception{
		String access_Token = kakao.getAccessToken(code);
		HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    System.out.println("login Controller : " + userInfo);

	    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
	    if (userInfo.get("kakaoid") != null) {
	    	snsProfileVO.setSnsid((String) userInfo.get("kakaoid"));
	    	System.out.println("Snsid : "+snsProfileVO.getSnsid());
	    	//int cnt=sampleService.selectSnsProfileCnt(snsProfileVO);
	    	
	    	//if(cnt <= 0){
	    		snsProfileVO.setSnscode("kakao");
	    		//sampleService.insertSnsProfile(snsProfileVO);
	    	//}
	        session.setAttribute("userid", userInfo.get("kakaoid"));
	        session.setAttribute("nickname", userInfo.get("nickname"));
	        session.setAttribute("access_Token", access_Token);
	    }
        
		return "shop/main/EgovMain";
	}

	@RequestMapping(value="/shop/user/EgovUserLogout.do")
	public String egovUserLogout(HttpSession session) {
	    kakao.kakaoLogout((String)session.getAttribute("access_Token"));
	    session.removeAttribute("access_Token");
	    session.removeAttribute("userId");
	    return "shop/main/EgovMain";
	}

}