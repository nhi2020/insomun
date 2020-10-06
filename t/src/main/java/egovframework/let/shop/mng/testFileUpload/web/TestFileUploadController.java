package egovframework.let.shop.mng.testFileUpload.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;



import egovframework.let.shop.mng.testFileUpload.service.impl.TestFileUploadServiceImpl;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class TestFileUploadController {

	// 테스트용 파일입니다. 아직 작성이 완료되지 않았으니 참고하지 마세요.
	
	@Resource(name = "TestFileUploadService")
	TestFileUploadServiceImpl testFileUploadServiceImpl;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	@Resource(name = "multipartResolver")
	CommonsMultipartResolver multipartResolver;
	
	
	@RequestMapping("/shop/mng/testFileUpload/insertTestFileUploadForm")
	public String insertTestFileUpload(Model model){
		return "/shop/mng/testFileUpload/insertTestFileUploadForm";
	}
	
	@RequestMapping("/shop/mng/testFileUpload/insertTestFileUploadPro")
	public String insertTestFileUploadPro(Model model){
		return "redirect:/shop/mng/testFileUpload/insertTestFileUploadForm";
	}
}
