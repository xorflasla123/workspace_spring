package com.care.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping(value="rest", produces = "application/json; charset=utf-8")
	//@ResponseBody //rest를 쓰면 이걸 안써도 문자열로 보여준다
	public String get() {
		return "{\"execute\" : \"get(데이터 요청(select))\"}"; //{key : value}
	}
	@PostMapping(value="rest", produces = "application/json; charset=utf-8")
	public String post() {
		return "{\"execute\" : \"post(데이터 추가(insert))\"}"; //{key : value}
	}
	@PutMapping(value="rest", produces = "application/json; charset=utf-8")
	public String put() {
		return "{\"execute\" : \"put(데이터 수정(update))\"}"; //{key : value}
	}
	@DeleteMapping(value="rest", produces = "application/json; charset=utf-8")
	public String delete() {
		return "{\"execute\" : \"delete(데이터 삭제(delete))\"}"; //{key : value}
	}
	static int cnt = 0;
	static Map<String, InfoDTO> DBMap = new HashMap<String, InfoDTO>();
	@GetMapping(value="users", produces = "application/json; charset=utf-8")
	public ArrayList<InfoDTO> users(){
		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();
		for(int i=cnt; i<10+cnt; i++) {
			InfoDTO dto = new InfoDTO();
			dto.setName("김개똥_"+i);
			dto.setAge("2"+i);
			list.add(dto);
			DBMap.put("김개똥_"+i, dto);
		}
		cnt += 10;
		return list;
	}
	@GetMapping(value="user/{uId}", produces = "application/json; charset=utf-8")
	//public InfoDTO user(@RequestParam String userId) {
	public InfoDTO user(@PathVariable String uId) {
		System.out.println("userId : "+uId);
		return DBMap.get(uId);
	}
	@PostMapping(value="membership", produces = "application/json; charset=utf-8")
	public String membership(@RequestBody Map<String, Object> map) {
		System.out.println("id : "+map.get("uId"));
		System.out.println("name : "+map.get("uName"));
		System.out.println("age : "+map.get("uAge"));
		System.out.println("addr : "+map.get("uAddr"));
		return "{\"result\" : true }";
	}
}











