package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.FileService;

@Controller
public class FileDownloadController {
	@GetMapping("download")
	public void download(@RequestParam("file") String fileName, HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment; fileName="+fileName);  //이미지, 혹은 파일을 보낼 때 이러한 header를 붙여서 보내줘야 한다.
		File file = new File(FileService.IMAGE_REPO+"\\"+fileName);
		FileInputStream in = new FileInputStream(file); //file을 읽어들인 위치에 대한 값으로 stream을 생성
		FileCopyUtils.copy(in, response.getOutputStream()); //왼쪽에 있는 값을 오른쪽으로 전달한다. 오른쪽 : 사용자
	}
}
