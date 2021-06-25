package com.care.member.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	private ArrayList<MemberDTO> list;
	public MemberDAO() {
		list = new ArrayList<MemberDTO>();
	}
	
	public ArrayList<MemberDTO> getMembers(){
		return list;
	}
	
	public void register(MemberDTO dto) {
		list.add(dto);
	}
}
