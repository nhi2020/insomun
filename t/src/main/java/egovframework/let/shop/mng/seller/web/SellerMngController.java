package egovframework.let.shop.mng.seller.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;
import egovframework.let.shop.mng.product.service.impl.ProductMngVO;
import egovframework.let.shop.mng.review.service.ReviewMngVO;
import egovframework.let.shop.mng.seller.service.SellerMngService;
import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.let.shop.mng.testFileUpload.service.TestFileUploadService;
import egovframework.let.shop.mng.testFileUpload.service.impl.TestFileUploadVO;
import egovframework.let.shop.user.seller.service.impl.SellerUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class SellerMngController {

	@Resource(name = "SellerMngService")
	private SellerMngService sellerService;
	
	@Resource(name = "TestFileUploadService")
	TestFileUploadService testFileUploadService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	@Resource(name = "multipartResolver")
	CommonsMultipartResolver multipartResolver;

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

	@RequestMapping(value = "/shop/mng/seller/listMngSeller")
	public String listMngSeller(@ModelAttribute("searchVO") SellerMngVO vo, HttpServletRequest request, Model model,
			@RequestParam(value = "pageIndex", required=false, defaultValue="1") int pageIndex) {
		vo.setPageIndex(pageIndex);
		System.out.println("listMngBuyer pageIndex => " + vo.getPageIndex());
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = sellerService.selectSellerMngListCnt(vo); //
		paginationInfo.setTotalRecordCount(totCnt);

		List<SellerMngVO> list = sellerService.selectSellerMngList(vo); //

		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);

		return "shop/mng/seller/listMngSeller";
	}
	
	@RequestMapping("/shop/mng/seller/updateMngSellerForm")
	public String updateMngSellerFrom(SellerMngVO vo, Model model) {
		System.out.println("updateMngSellerFrom()");
		vo = sellerService.sellerSelect(vo);
		model.addAttribute("SellerVO", vo);
		return "shop/mng/seller/updateMngSellerForm";
	}
	
	@RequestMapping(value = "/shop/mng/seller/updateMngSellerPro", method = RequestMethod.POST)
	public String updateMngSellerPro(HttpServletRequest request, SellerMngVO vo, Model model, String path) throws IOException{
		System.out.println("updateMngSellerPro()");
		System.out.println("vo.getS_nickname() ->" + vo.getS_nickname());
		
		
		int result = sellerService.sellerUpdate(vo);
		if(result > 0) {
			model.addAttribute("msg", "수정 성공");
		}else {
			model.addAttribute("msg", "수정 실패");
		}
		model.addAttribute("vo");
		
		return "forward:updateMngSellerForm.do";
	}
	
	@RequestMapping("/shop/mng/seller/updateMngSellerStateChange")
	public String updateMngSellerStateChange(SellerMngVO vo, Model model, RedirectAttributes redirect) {
		System.out.println("updateMngSellerStateChange()");
		
		int result = sellerService.updateMngSellerStateChange(vo);
		if(result > 0) {
			redirect.addFlashAttribute("result", result);
		} else {
			redirect.addFlashAttribute("result", result);
		}
		String pageIndex = Integer.toString(vo.getPageIndex());
		return "redirect:/shop/mng/seller/listMngSeller.do";
	}
	
	@RequestMapping("/shop/mng/seller/InsertMngSellerForm.do")
	public String InsertMngSellerForm() {
		return "/shop/mng/seller/InsertMngSellerForm";
	}
	
	@RequestMapping(value="/shop/mng/seller/InsertMngSellerPro.do", method = RequestMethod.POST )
	public String InsertMngSellerPro(HttpServletRequest request, MultipartFile file, SellerMngVO vo, Model model, String path, RedirectAttributes redirect) throws IOException{
		String addr1 =vo.getAddr1();
		String addr2 =vo.getAddr2();
		String S_addr= addr1 + addr2; 
		System.out.println("S_ADDR" + S_addr);
		vo.setS_addr(S_addr);
		
		String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		vo.setS_photo(savedName);
		
		String result = sellerService.InsertMngSellerPro(vo);
	
		if(result != "" && result != null) {
			redirect.addFlashAttribute("result1", result);
			System.out.println("result1->" + result);
		} else {
			redirect.addFlashAttribute("result1", result);
			System.out.println("result1->" + result);
		}
		
		return "redirect:/shop/mng/seller/listMngSeller.do";
	}
	
	@RequestMapping(value = "/shop/mng/seller/delMngSeller.do")
	public String delMngSeller(SellerMngVO mngVO, HttpServletRequest request, Model model, RedirectAttributes redirect) {
		String[] chk = request.getParameterValues("chk");
		for (int j = 0; j < chk.length; j++) {
			System.out.println("chk : " +chk[j]);
			mngVO.setS_idx(chk[j]);
			int result = sellerService.delMngSeller(mngVO);
			if(result > 0) {
				redirect.addFlashAttribute("result", result);
			} else {
				redirect.addFlashAttribute("result", result);
			}
		}
		return "redirect:/shop/mng/seller/listMngSeller.do";
	}	
	
/*	@RequestMapping(value = "/shop/mng/seller/InsertImgMngSellerPro.do", method = RequestMethod.POST)
	public String InsertImgMngSellerPro(HttpServletRequest request, MultipartFile file, SellerMngVO vo, String path, Model model) throws IOException {
		String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		vo.setOriginal_file_name(file.getOriginalFilename());
		vo.setStored_file_name(savedName);
		vo.setFile_size(file.getSize());
		
		int result = sellerService.insertImgFileUpload(vo);
		
		model.addAttribute("msg", result);
		model.addAttribute("savedName", savedName);
		
		return "redirect:/shop/mng/seller/InsertImgMngSellerPro.do";
	}*/
	
	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws IOException {
		UUID uid = UUID.randomUUID();
		File fileDirectory = new File(uploadPath);
		if(!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			System.out.println("the directory for uploading : " + uploadPath);
		}
		String savedName = uid.toString() + "-" + originalName;
		String[] invalidName = {"\\\\","/",":","\"","<",">","\\[","\\]"};
		for(int i = 0; i < invalidName.length; i++)
			savedName = savedName.replaceAll(invalidName[i], "_");
		
		File target = new File(uploadPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	

}
