package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	
	public void getMembers(Model model) {
		ArrayList<MemberDTO> list = dao.getMembers();
		model.addAttribute("list", list);
	}
	
	public void register(MemberDTO dto) {
		dao.register(dto);
	}
}
