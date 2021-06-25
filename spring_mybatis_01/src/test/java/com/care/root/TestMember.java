package com.care.root;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
		"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class TestMember {
	@Autowired MemberController mc;
	@Test
	public void testMc() {
		System.out.println("---- mc => "+mc);
		assertNotNull(mc); //null이 아니면 성공
	}
	@Autowired MemberService ms;
	@Test
	public void testMs() {
		assertNotNull(ms);
		MemberDTO dto = new MemberDTO();
		dto.setId(123);
		dto.setName("123");
		dao.insertMember(dto);
	}
	@Autowired MemberDAO dao;
	@Test
	public void testDao() {
		assertNotNull(dao);
		MemberDTO dto = new MemberDTO();
		dto.setId(111);
		dto.setName("홍길동");
		dao.insertMember(dto);
	}
	@Test
	public void testM() {
		assertNotNull(dao.memberView());
	}
}









