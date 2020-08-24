package egovframework.let.shop.seller.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.let.shop.seller.service.SellerDashboardService;
import egovframework.let.sym.mnu.mpm.service.EgovMenuManageService;
import egovframework.let.uss.olh.faq.service.EgovFaqManageService;

public class SellerController {

	@Controller
	@SessionAttributes(types = ComDefaultVO.class)
	public class EgovMainController {

		/**
		 * SellerDashboardService
		 */
		@Resource(name = "SellerDashboardService")
		private SellerDashboardService SellerDashboardService;


		@RequestMapping(value = "/shop/seller/sellerDashboard.do")
		public String getSellerDashboard(HttpServletRequest request, ModelMap model) throws Exception {
			
			return "seller/sellerDashboard";
		}
		
		@RequestMapping(value = "/shop/seller/sellerDashboardPro.do")
		public String getSellerDashboardPro(HttpServletRequest request, ModelMap model) throws Exception {
			
			// service => dao
			
			model.addAttribute("id", "1");
			model.addAttribute("idx", "2");
			model.addAttribute("nickname", "3");
			return "seller/sellerDashboardPro";
		}

		/**
		 * Head메뉴를 조회한다.
		 * 
		 * @param menuManageVO
		 *            MenuManageVO
		 * @return 출력페이지정보 "main_headG", "main_head"
		 * @exception Exception
		 */

	}
}
