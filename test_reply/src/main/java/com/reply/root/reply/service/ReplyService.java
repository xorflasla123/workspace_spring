package com.reply.root.reply.service;

import java.util.List;
import java.util.Map;

import com.reply.root.reply.dto.ReplyDTO;

public interface ReplyService {
	public void addReply(Map<String, Object> map);
	public List<ReplyDTO> getRepList();
	public void removeReply(Map<String, Object> map);
}
