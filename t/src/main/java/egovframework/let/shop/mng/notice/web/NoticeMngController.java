package egovframework.let.shop.mng.notice.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.let.shop.mng.notice.service.NoticeMngService;
import egovframework.let.shop.mng.notice.service.impl.NoticeMngVO;
import egovframework.let.shop.mng.testFileUpload.service.TestFileUploadService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeMngController {

	@Resource(name = "NoticeMngService")
	private NoticeMngService noticeMngService;

	@Resource(name = "TestFileUploadService")
	TestFileUploadService testFileUploadService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;


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

	@RequestMapping(value = "/shop/mng/notice/listMngNotice")
	public String listMngNotice(@ModelAttribute("searchVO") NoticeMngVO vo, HttpServletRequest request, Model model,
			@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex) {
		vo.setPageIndex(pageIndex);
		System.out.println("listMngNotice pageIndex => " + vo.getPageIndex());
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = noticeMngService.selectNoticeMngListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<NoticeMngVO> list = noticeMngService.selectNoticeMngList(vo);

		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);

		return "shop/mng/notice/listMngNotice";
	}

	@RequestMapping("/shop/mng/notice/updateMngNoticeForm")
	public String noticeMngUpdateForm(NoticeMngVO vo, Model model) {
		System.out.println("updateMngNoticeForm()");
		vo = noticeMngService.noticeMngSelect(vo);
		model.addAttribute("NoticeVO", vo);

		return "/shop/mng/notice/updateMngNoticeForm";
	}
	
	@RequestMapping(value = "/shop/mng/notice/insertMngNoticeForm.do")
	public String insertMngNoticeForm(){
		return "/shop/mng/notice/insertMngNoticeForm";
	}
	
	@RequestMapping(value = "/shop/mng/notice/insertMngNoticePro", method = RequestMethod.POST)
	public String insertMngNoticePro(HttpServletRequest request, NoticeMngVO vo, Model model, RedirectAttributes redirect) throws IOException {
		System.out.println("NoticeMngController insertMngNoticePro()");
		String result = noticeMngService.insertNoticeMngPro(vo);
		System.out.println("result => " + result);
		
		if(result != "" && result != null) {
			redirect.addFlashAttribute("result1", result);
			System.out.println("result1->" + result);
		} else {
			redirect.addFlashAttribute("result1", result);
			System.out.println("result1->" + result);
		}
		
		return "redirect:/shop/mng/log/insertMngNoticeForm.do";
	}
	
/*	@RequestMapping(value = "/shop/mng/notice/deleteMngNotice.do")
	public String deleteMngNotice(HttpServletRequest request,NoticeMngVO vo) throws Exception {
		
		int result = noticeMngService.deleteMngNotice(vo);
		if (result == 0) {
			System.out.println("삭제 실패");
		} else {
			System.out.println("삭제 성공");
		}
		return "forward:/shop/mng/notice/listMngNotice.do";
	}*/
	
	
	
	
	/*@RequestMapping(value = "/shop/mng/notice/delNoticeMng.do")
	public String delNoticeMng (NoticeMngVO vo, HttpServletRequest request, Model model, RedirectAttributes redirect) {
		int[] chk = request.getParameterValues("chk");
		
		if(chk != null) {
			for (int j = 0; j < chk.length; j++) {
				System.out.println("chk :" + chk[j]);
				
				vo.setN_idx(chk[j]);
			}
		}
		
		return null;
	}*/

	/*@RequestMapping("/")
	public String deleteMngNotice(NoticeMngVO vo, Model model, RedirectAttributes redirect) {
		System.out.println("deleteMngNotice()");
		
		int result = noticeMngService.deleteMngNotice(vo);
		if(result > 0) {
			redirect.addFlashAttribute("result", result);
			model.addAttribute("msg", "삭제성공");
		} else {
			redirect.addFlashAttribute("result", result);
			model.addAttribute("msg", "삭제 실패");
		}
		String pageIndex = Integer.toString(vo.getPageIndex());
		return "redirect:/.do";
	}*/
}
