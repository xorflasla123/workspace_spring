package com.care.root;

import org.springframework.stereotype.Repository;

@Repository
public class QuizDAO {
	public QuizDTO check(String id, String pwd) {
		String saveId = "a123";
		String savePwd = "a123";
		QuizDTO dto = new QuizDTO();
		if(saveId.equals(id)&&savePwd.equals(pwd)) {
			dto.setCheck(0);
			dto.setId(saveId);
			dto.setPwd(savePwd);
			dto.setName("홍길동");
		} else {
			dto.setCheck(1);
		}
		return dto;
	}
}
