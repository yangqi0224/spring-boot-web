package com.smsm.service.impl;

import java.util.List;

import com.smsm.mapper.ToEmployMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsm.model.ToEmploy;
import com.smsm.model.User;
import com.smsm.service.ToEmployService;

@Service
public class ToEmployServiceImpl implements ToEmployService {
	
	@Autowired
	private ToEmployMapper toEmployMapper;

	@Override
	public int insertToEmploy(ToEmploy toEmploy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertToEmployByUser(String userId, String recruitmentId) {
		return toEmployMapper.insertToEmployByUser(userId,recruitmentId);
	}

	@Override
	public ToEmploy selectRecordByUser(String userId,String recruitmentId) {
		return toEmployMapper.selectRecordByUser(userId,recruitmentId);
	}

	@Override
	public List<ToEmploy> findAllRecord() {
		return toEmployMapper.findAllRecord();
	}

	@Override
	public List<ToEmploy> selectAllToEmployByUser(String userId) {
		// TODO Auto-generated method stub
		return toEmployMapper.selectAllToEmployByUser(userId);
	}

	@Override
	public int updateToEmploy(ToEmploy toEmploy) {
		return toEmployMapper.updateToEmploy(toEmploy);
	}

}
