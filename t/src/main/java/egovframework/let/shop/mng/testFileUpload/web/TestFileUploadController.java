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

	@Resource(name = "TestFileUploadService")
	TestFileUploadServiceImpl testFileUploadServiceImpl;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	@Resource(name = "multipartResolver")
	CommonsMultipartResolver multipartResolver;
	
	
	@RequestMapping("/shop/mng/testFileUpload/inserttestFileUploadForm")
	public String inserttestFileUpload(Model model){
		return "/shop/mng/testFileUpload/inserttestFileUploadForm";
	}
	
	@RequestMapping(value = "/shop/mng/testFileUpload/inserttestFileUploadPro", method=RequestMethod.POST)
	public String inserttestFileUploadPro(Model model,final HttpServletRequest request) throws IllegalStateException, IOException{
		final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		String uploadPath = propertyService.getString("Globals.uploadFilePath");
		System.out.println("uploadPath");
		File saveFolder = new File(uploadPath);
		if (!saveFolder.exists() || saveFolder.isFile()){
			saveFolder.mkdirs();
		}
		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
		MultipartFile file;
		String filePath;
		
		while(itr.hasNext()){
			Entry<String, MultipartFile> entry = itr.next();
			System.out.println("[" + entry.getKey() + "]");
			file = entry.getValue();
			if(!"".equals(file.getOriginalFilename())){
				filePath = uploadPath + "\\" + file.getOriginalFilename();
				file.transferTo(new File(filePath));
				System.out.println("filePath => " + filePath);
				System.out.println("fileName => " + file.getOriginalFilename());
				System.out.println("fileSize => " + file.getSize());
			}
			
		}
		
		return "redirect:/shop/mng/testFileUpload/inserttestFileUploadForm.do";
		
	}
}
