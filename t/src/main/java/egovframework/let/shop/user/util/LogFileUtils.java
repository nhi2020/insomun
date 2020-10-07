package egovframework.let.shop.user.util;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.let.shop.user.review.service.ReviewUserVO;

@Component("logFileUtils")
public class LogFileUtils {

   public List<ReviewUserVO> parseInsertFileInfo(HttpServletRequest request) throws Exception {
      String url = this.getClass().getResource("").getPath();
      String rootPath = url.substring(1, url.indexOf(".metadata")) + "log/src/main/webapp/WEB-INF/jsp/shop/user/upload/";
      System.out.println("url :" + url);
      MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
      Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
      MultipartFile multipartFile = null;
      String originalFileName = null;
      String originalFileExtension = null;
      String storedFileName = null;
      List<ReviewUserVO> list = new ArrayList<ReviewUserVO>();
      File file = new File(rootPath);
      if (file.exists() == false) {
         file.mkdirs();
      }
      while (iterator.hasNext()) {
         multipartFile = multipartHttpServletRequest.getFile(iterator.next());
         if (multipartFile.isEmpty() == false) {
        	 ReviewUserVO vo = new ReviewUserVO();
            originalFileName = multipartFile.getOriginalFilename();
            originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            storedFileName = CommonUtils.getRandomString() + originalFileExtension;
            file = new File(rootPath + storedFileName);
            multipartFile.transferTo(file);
            vo.setOriginal_pic_name(originalFileName);
            vo.setStored_pic_name(storedFileName);
            vo.setPic_size(multipartFile.getSize());
            vo.setWhere_is_pic(url);
            list.add(vo);
         }
      }
      return list;
   }

   public void downloadFile(ReviewUserVO vo, HttpServletResponse response) throws Exception {
      String storedFileName = vo.getStored_pic_name();
      String originalFileName = vo.getOriginal_pic_name();
      String url = this.getClass().getResource("").getPath();
      String rootPath = url.substring(1, url.indexOf(".metadata")) + "log/src/main/webapp/WEB-INF/jsp/shop/user/upload/";
      byte fileByte[] = FileUtils.readFileToByteArray(new File(rootPath + storedFileName));
      response.setContentType("application/octet-stream");
      response.setContentLength(fileByte.length);
      response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
      response.setHeader("Content-Transfer-Encoding", "binary");
      response.getOutputStream().write(fileByte);
      response.getOutputStream().flush();
      response.getOutputStream().close();
   }

}