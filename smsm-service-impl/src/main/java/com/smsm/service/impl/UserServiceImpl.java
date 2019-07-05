package com.smsm.service.impl;

import java.util.List;

import com.smsm.mapper.JobSeekerMapper;
import com.smsm.mapper.RecruitmentMapper;
import com.smsm.mapper.ResumeMapper;
import com.smsm.mapper.UserMapper;
import com.smsm.model.JobSeeker;
import com.smsm.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsm.model.Job;
import com.smsm.model.User;
import com.smsm.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RecruitmentMapper recruitmentMapper;

	@Autowired
	private JobSeekerMapper jobSeekerMapper;

	@Autowired
	private ResumeMapper resumeMapper;
	
	public User findUserInfo(String userPhone){
		return userMapper.selectByPrimaryKey1(userPhone);
	}
	
	public int insertUserInfo(User user){
		return userMapper.insertSelective(user);
	}
	
	public int updateUser(User user){
		return userMapper.updateByPrimaryKeySelective1(user);
	}

	@Override
	public int insertJobSeeker(JobSeeker jobSeeker) {
		return jobSeekerMapper.insertJobSeeker(jobSeeker);
	}

	@Override
	public JobSeeker selectJobSeekerByUserId(String userId) {
		return jobSeekerMapper.selectJobSeekerByUserId(userId);
	}

	@Override
	public List<Job> selectHotJob() {
		// TODO Auto-generated method stub
		return recruitmentMapper.selectHotJob();
	}

	@Override
	public List<Job> selectAllJob() {
		// TODO Auto-generated method stub
		return recruitmentMapper.selectAllJob();
	}

	@Override
	public Resume selectFirstResumeByUserId(String userId) {
		return resumeMapper.selectFirstResumeByUserId(userId);
	}

	@Override
	public int updatePwd(User user) {
		return userMapper.updatePwd(user);
	}
}
