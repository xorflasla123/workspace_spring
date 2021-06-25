package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;


@Service
public class FileServiceImpl implements FileService{
	@Autowired FileMapper mapper;
	@Override
	public void fileProcess(MultipartFile file) {
		if(!file.isEmpty()) { // file.getSize() != 0
			SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sim.format(calendar.getTime())+file.getOriginalFilename();
			
			File saveFile = new File(IMAGE_REPO+"\\"+sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void fileProcess(MultipartHttpServletRequest mul) {
		ShoesDTO dto = new ShoesDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));
		
		MultipartFile file = mul.getFile("file");
		if(!file.isEmpty()) { // file.getSize() != 0 해당하는 파일이 존재하는 경우(사용자가 선택한경우)
			SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sim.format(calendar.getTime())+file.getOriginalFilename();
			
			dto.setImgName(sysFileName);
			
			File saveFile = new File(IMAGE_REPO+"\\"+sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		mapper.saveData(dto);
	}

	@Override
	public void getShoesImage(Model model) {
		model.addAttribute("list",mapper.getShoesImage());
	}
}
