package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
	@Autowired
	QuizDAO dao;
	
	public QuizDTO check(String id, String pwd) {
		QuizDTO dto = dao.check(id, pwd);
		return dto;
	}
}
