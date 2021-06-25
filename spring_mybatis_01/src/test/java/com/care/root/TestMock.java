package com.care.root;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
		"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class TestMock { // mvc mock이라는 객체가 전송을 담당한다
	@Autowired MemberController mc;
	MockMvc mock;
	@Before
	public void setUp() {
		System.out.println("test 실행 전 초기화 작업을 하고자 할 때");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	@Test
	public void testIndex() throws Exception{
		System.out.println("실행 실행");
		mock.perform(get("/index"))
			.andDo(print()) //상태 출력
			.andExpect(status().isOk()) //상태코드가 200이면 성공
			.andExpect(forwardedUrl("member/index")); //컨트롤러 리턴 경로가 맞으면 성공
	}
	@Test
	@Transactional(transactionManager = "txMgr") //트랜잭션으로 작동이 되는 것은 확인하지만 
												//트랜잭션 롤백으로 데이터는 넣지 않는다
	public void testInsert() throws Exception{
		mock.perform(post("/insert").param("id", "888").param("name", "888"))
					.andDo(print())
					.andExpect(status().is3xxRedirection());
	}
	@Test
	public void testMemberview() throws Exception{
		mock.perform(get("/memberview"))
					.andExpect(status().isOk())
					.andExpect(forwardedUrl("member/memberview"))
					//요청 결과 model에 list 키가 있으면 성공
					.andExpect(model().attributeExists("list"));
	}
}
