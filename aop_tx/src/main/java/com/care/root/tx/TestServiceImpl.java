package com.care.root.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;

import com.care.root.mapper.TestMapper;

@Service
public class TestServiceImpl{
	@Autowired TestMapper mapper;
	
	@Transactional
	public void buy(Model model, int num) {
		System.out.println("==== buy 시작 ====");
		int[] result = {0,0};
		try {
			result[0] = mapper.userInsert(num);
			result[1] = mapper.systemInsert(num);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
		}
		model.addAttribute("result", result);
	}
	public void dbResult(Model model) {
		model.addAttribute("user", mapper.userDBResult());
		model.addAttribute("system", mapper.systemDBResult());
	}
}
