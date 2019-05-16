package com.recoder.fatda.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")
public class FileUtils {

	
	
	private static final String filePath = "C:\\upload"; // \\ <--리눅스 버전. 저예산으로 운영될때... cmd 혹은 터미널로 할때. row단
//	public String filePath = "C:\\upload"; <- 리눅스ver.
	//하드웨어에 가까울수록 row단이라고 함.
	//터미널 쪽 공부하다 보면
	//푸티/제티 등등  쓸수있음
	
//	int parentSeq는 파일이 담겨진 테이블의 기본키값이다
	public List<Map<String, Object>> parseInsertFileInfo(int parentSeq,
			MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {

		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		

		List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
		Map<String, Object> fileInfoMap = null;

		File file = new File(filePath);
		
		if(file.exists() == false) {
			file.mkdirs(); //make directories
		}
		
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());

			if (multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")); //확장자를 추가하기 위함
				storedFileName = CommonUtils.getRandomString() + originalFileExtension;
				
				file = new File(filePath, storedFileName);
				multipartFile.transferTo(file);
				
				fileInfoMap = new HashMap<String, Object>();	//map만 잇으면 db에 저장할 수 있음
				fileInfoMap.put("parentSeq", parentSeq);		//지금은 단일로 하나만 넣고 하나만 수정 가능하게 만들었음
				fileInfoMap.put("original_file_name", originalFileName);	//여러개하면 더 복잡해짐..ㅠ
				fileInfoMap.put("stored_file_name", storedFileName);
				fileInfoMap.put("file_size", multipartFile.getSize());
				
				fileList.add(fileInfoMap);
			}
		}

		return fileList;
	}

	
//	int parentSeq는 파일이 담겨진 테이블의 기본키값이다
	public boolean parseUpdateFileInfo(Map<String, Object> tempFileMap) {

		String storedFileName = (String)tempFileMap.get("STORED_FILE_NAME");
		
		File file = new File(filePath + "/" +storedFileName);
		
		if(file.exists()) {
			try {
				file.delete(); //증명 여부를 통해 더욱 완벽하게 짜야됨! 이렇게짜면 안됨!
			} catch (Exception e) {
				return false;
			}
			
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}

		return true;
	}
}
