package egovframework.let.shop.mng.product.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.let.shop.mng.product.service.ProductMngService;
import egovframework.let.shop.mng.product.service.impl.ProductMngVO;
import egovframework.let.shop.mng.review.service.ReviewMngVO;
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
public class ProductMngController {

	/**
	 * EgovBBSManageService
	 */
	@Resource(name = "EgovMngProductService")
	private ProductMngService mngProductService;

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
	@RequestMapping(value = "/shop/mng/product/EgovMngProductlist")
	public String forwardPageWithMenuNo(@ModelAttribute("searchVO") ProductMngVO vo, HttpServletRequest request,
			ModelMap model,ReviewMngVO vo2) throws Exception {
		System.out.println("test");
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		int totCnt = mngProductService.selectMngProductListCnt(vo);
		paginationInfo.setTotalRecordCount(totCnt);

		List<ProductMngVO> list = mngProductService.selectMngProductList(vo);
		System.out.println("test"+list.get(0).getS_id());
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
			
//		리뷰 관련  			//
		
		/*List<ReviewVO> list2 = reviewService.selectReviewList(vo2);
		model.addAttribute("list2", list);*/
		
//		리뷰 관련  			//		
		return "/shop/mng/product/EgovMngProductlist";
	}
//수정 형식 작성
	@RequestMapping(value="/shop/mng/product/EgovMngProductUpdateForm")
	public String egovMngProductUpdateForm(ProductMngVO vo,  HttpServletRequest request,
			ModelMap model) throws Exception {
		
		System.out.println("EgovMngProductUpdateForm"+vo);
		
		System.out.println("vo.getP_IDX => " + vo.getP_idx());
	    vo = mngProductService.selectMngProductForm(vo);
	    System.out.println("EgovMngProductUpdateForm"+vo);
	    List<ProductMngVO> list = new ArrayList<ProductMngVO>();
	    model.addAttribute("ProductMngVO",vo);
	    return "/shop/mng/product/EgovMngProductUpdateForm";
	}
//수정하기 가능하도록	
	@RequestMapping(value ="/shop/mng/product/EgovMngProductUpdatePro", method = RequestMethod.POST)
	public String egovMngProductUpdatePro(ProductMngVO vo, Model model) throws Exception{
		int result = mngProductService.updateMngProductPro(vo);
		System.out.println("vo pname => " + vo.getP_name());
		if (result > 0) {
			model.addAttribute("msg", "수정 성공");
		} else {
			model.addAttribute("msg", "수정 실패");
		}
		model.addAttribute("vo");

		return "forward:/shop/mng/product/EgovMngProductUpdateForm.do";

	}
	
	@RequestMapping(value = "/shop/mng/product/EgovMngProductInsertForm")
	public String EgovMngProductInsertForm() {
		return "/shop/mng/product/EgovMngProductInsertForm";
	}
	
	@RequestMapping(value = "/shop/mng/product/EgovMngProductInsertPro", method = RequestMethod.POST)
	public String EgovMngProductInsertPro(ProductMngVO vo,Model model, HttpServletRequest request) throws Exception {
		System.out.println("INSERT");
		HttpSession session = request.getSession();
		String a_id = (String) session.getAttribute("A_ID");
		System.out.println("a_id"+a_id);
		System.out.println("INSERT");
		vo.setS_id(a_id);
		mngProductService.insertMngProductPro(vo);
		
		return "redirect:/shop/mng/product/EgovMngProductInsertForm.do";
	}
	
	@RequestMapping(value = "/shop/mng/product/EgovMngProductDelete") 
	public String EgovMngProductDelete(ProductMngVO vo, HttpServletRequest request)throws Exception {
		
		String[] check = request.getParameterValues("check");
		System.out.println("EgovMngProductDelete:");
		for (int i = 0; i < check.length; i++) {
			System.out.println("chk : " +check[i]);
			vo.setP_idx(check[i]);
			mngProductService.deleteMngProduct(vo);
		}
		return "redirect:/shop/mng/product/EgovMngProductlist.do";
	}
	
	

/*    // xml에 설정된 리소스 참조
    // bean의 id가 uploadPath인 태그를 참조
    @Resource(name="uploadPath")
    String uploadPath;

    // 업로드 흐름 : 업로드 버튼클릭 => 임시디렉토리에 업로드=> 지정된 디렉토리에 저장 => 파일정보가 file에 저장
    @RequestMapping(value="/upload/uploadForm", method=RequestMethod.GET)
    public void uplodaForm(){
        // upload/uploadForm.jsp(업로드 페이지)로 포워딩
    }

    @RequestMapping(value = "/fileupload",method = RequestMethod.POST)
    public void upload(MultipartFile uploadfile){
        logger.info("upload() POST 호출");
        logger.info("파일 이름: {}", uploadfile.getOriginalFilename());
        logger.info("파일 크기: {}", uploadfile.getSize());

        saveFile(uploadfile);

    }

        return mav; // uploadResult.jsp(결과화면)로 포워딩
    }
}*/
	
	
	
	

}