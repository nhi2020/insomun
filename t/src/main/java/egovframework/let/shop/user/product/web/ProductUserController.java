package egovframework.let.shop.user.product.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.let.shop.user.product.service.ProductUserService;
import egovframework.let.shop.user.product.service.impl.ProductUserVO;
import egovframework.let.shop.user.review.service.ReviewUserService;
import egovframework.let.shop.user.review.service.ReviewUserVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * 템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)
 * 
 * @author 실행환경 개발팀 JJY
 * @since 2011.08.31
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.08.31  JJY            최초 생성
 *
 *      </pre>
 */
@Controller
public class ProductUserController {

	/**
	 * EgovBBSManageService
	 */
	@Resource(name = "EgovUserProductService")
	private ProductUserService userProductService;

	@Resource(name = "EgovReviewUserService")
	private ReviewUserService egovReviewService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	

	/*@Resource(name ="EgovReviewService")
	protected ReviewMngService reviewService;*/
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

	/**
	 * 상품 정보
	 *
	 * @param request
	 * @param commandMap
	 * @exception Exception
	 *                Exception
	 */
	@RequestMapping(value = "/shop/user/product/EgovUserProductlist")
	public String forwardPageWithMenuNo(@ModelAttribute("searchVO") ProductUserVO vo, HttpServletRequest request,
			ModelMap model,ReviewUserVO vo2) throws Exception {
		System.out.println("test"+vo.getSearchCnd());
		System.out.println("test"+vo.getSearchWrd());
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = userProductService.selectUserProductListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<ProductUserVO> list = userProductService.selectUserProductList(vo);
		System.out.println("test"+list.get(0).getS_id());
		System.out.println("totCnt"+ totCnt);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
			
//		리뷰 관련  			//
		
		/*List<ReviewVO> list2 = reviewService.selectReviewList(vo2);
		model.addAttribute("list2", list);*/
		
//		리뷰 관련  			//		
		return "/shop/user/product/EgovUserProductlist";
	}
//수정 형식 작성
	@RequestMapping(value="/shop/user/product/EgovUserProductUpdateForm")
	public String egovProductUpdateForm(ProductUserVO vo,  HttpServletRequest request,
			ModelMap model) throws Exception {
		
	
	    vo = userProductService.selectUserProductForm(vo);
	    System.out.println("EgovUserProductUpdateForm"+vo);
	    model.addAttribute("ProductUserVO",vo);
	    return "/shop/user/product/EgovUserProductUpdateForm";
	}
//수정하기 가능하도록	
	@RequestMapping(value ="/shop/user/product/EgovUserProductUpdatePro", method = RequestMethod.POST)
	public String egovUserProductUpdatePro(@ModelAttribute("ProductUserVO")ProductUserVO vo, HttpServletRequest request,Model model, RedirectAttributes redirect, MultipartFile file) throws Exception{
		//
	    String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
	    // 서버에 업로드할 경우엔 프로퍼티에서 경로를 설정할 예정.
	 	// String uploadPath = propertyService.getString("Globals.fileStorePath");
	    // 서버 파일 삭제
	    String deleteFile = uploadPath + vo.getPreImage(); //
	    int delResult = deleteFile(deleteFile);
	    // 서버 업로드를 위한 절차
	    String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		vo.setP_image(savedName);
	    // DB 반영
	    int dbResult = userProductService.updateUserProductPro(vo);
	    
		System.out.println("vo pname => " + vo.getP_name());
		if (dbResult > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		model.addAttribute("vo");
		model.addAttribute("delResult", delResult);
	    model.addAttribute("dbResult", dbResult);

		return "forward:/shop/user/product/EgovUserProductUpdateForm.do";

	}
	
	private int deleteFile(String deleteFile) {
		// TODO Auto-generated method stub
		return 0;
	}

	@RequestMapping(value = "/shop/user/product/EgovUserProductInsertForm")
	public String EgovUserProductInsertForm() {
		return "/shop/user/product/EgovUserProductInsertForm";
	}
	
	@RequestMapping(value = "/shop/user/product/EgovUserProductInsertPro", method = RequestMethod.POST)
	public String EgovUserProductInsertPro(ProductUserVO vo,Model model, HttpServletRequest request, MultipartFile file, String path) throws Exception {
		
		HttpSession session = request.getSession();
		String s_id = (String) session.getAttribute("S_ID");
		vo.setS_id(s_id);
	
		//
		String uploadPath = request.getSession().getServletContext().getRealPath("/file/");
		//String uploadPath = propertyService.getString("Globals.fileStorePath");
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		vo.setP_image(savedName);
		//
		
		userProductService.insertUserProductPro(vo);
		
		return "redirect:/shop/user/product/EgovUserProductInsertForm.do";
	}
	
	private String uploadFile(String originalFilename, byte[] fileData, String uploadPath) throws Exception {
		// 랜덤으로 UUID를 생성해 파일 앞에 붙여줄 예정.
		UUID uid = UUID.randomUUID();
		System.out.println("uploadPath => " + uploadPath);
		
		// 업로드 경로를 확인하고, 경로에 폴더가 존재하지 않을 경우 생성해준다. 
		File fileDiretory = new File(uploadPath);
		if (!fileDiretory.exists()) {
			fileDiretory.mkdirs();
			System.out.println("the directory for uploading : " + uploadPath);
		}
		
		// UUID를 스트링으로 변환해 원래 이름 앞에 붙여준다.
		String savedName = uid.toString() + "_" + originalFilename;
		
		String[] invalidName = {"\\\\","/",":","\"","<",">","\\[","\\]"}; // 윈도우 파일명으로 사용할수 없는 문자

		for(int i=0;i<invalidName.length;i++)
			savedName = savedName.replaceAll(invalidName[i], "_"); // 언더바로 치환


		// 저장될 파일 경로를 지정.
		File target = new File(uploadPath, savedName);
		
		// FileCopyUtils로 경로에 저장해 복사한다.
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}

	@RequestMapping(value = "/shop/user/product/EgovUserProductDelete") 
	public String EgovUserProductDelete(ProductUserVO vo, HttpServletRequest request)throws Exception {
		
		String[] check = request.getParameterValues("check");
		System.out.println("EgovUserProductDelete:");
		for (int i = 0; i < check.length; i++) {
			System.out.println("chk : " +check[i]);
			vo.setP_idx(check[i]);
			userProductService.deleteUserProduct(vo);
		}
		return "redirect:/shop/user/product/EgovUserProductlist.do";
	}
	
	@RequestMapping(value = "/shop/user/product/EgovBuyerProductForm")
	public String EgovBuyerProduct(ProductUserVO vo, ModelMap model,ReviewUserVO reviewVO) throws Exception {
		 vo = userProductService.selectBuyerProduct(vo);
		    System.out.println("EgovBuyerProduct"+vo);
		    model.addAttribute("ProductUserVO",vo);
		    List<ReviewUserVO> list = egovReviewService.selectReviewList(reviewVO);
		    model.addAttribute("list",list);
		    return "/shop/user/product/EgovBuyerProductForm";
	}


}