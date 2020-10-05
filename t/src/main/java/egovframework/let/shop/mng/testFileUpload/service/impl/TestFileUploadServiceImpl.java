package egovframework.let.shop.mng.testFileUpload.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.testFileUpload.service.TestFileUploadService;

@Service("TestFileUploadService")
public class TestFileUploadServiceImpl implements TestFileUploadService {
	
	@Resource(name = "TestFileUploadDAO")
	TestFileUploadDAO testFileUploadDAO;


}
