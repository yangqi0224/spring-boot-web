package com.smsm.service.impl;

import java.util.List;

import com.smsm.mapper.JobMapper;
import com.smsm.mapper.RecruitmentMapper;
import com.smsm.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsm.model.Company_Recruitment;
import com.smsm.model.Recruitment;
import com.smsm.service.RecruitmentService;

@Service
public class recruitmentServiceImpl implements RecruitmentService{

	@Autowired
	private RecruitmentMapper recruitmentMapper;

	@Autowired
	private JobMapper jobMapper;
	
	//浏览招聘信息
	public List<Company_Recruitment> selectRecruitment() {
		return recruitmentMapper.SelectRecruitment();
	}
	
	//浏览最新招聘信息
	public List<Company_Recruitment> selectRecruitByTime() {
		return recruitmentMapper.SelectRecruitByTime();
	}
	
	//浏览最新招聘信息
	public List<Recruitment> selectRecruitByJobName(String jobName) {
		return recruitmentMapper.SelectRecruitByJobName(jobName);
	}
	
	//插入招聘信息
	public int insertRecruit(Recruitment recruitment){
		return recruitmentMapper.insertRecruit(recruitment);
	}

	//按企业名称浏览最新招聘信息
	public List<Company_Recruitment> selectRecruitByCompanyName(String companyName) {
		return recruitmentMapper.SelectRecruitByCompanyName(companyName);
	}

	@Override
	public int updateRecruit(Recruitment recruitment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Recruitment selectRecruitById(String id) {
		return recruitmentMapper.selectRecById(id);
	}

	@Override
	public Job selectJobByRec(Recruitment recruitment) {
		return jobMapper.selectJobByRec(recruitment);
	}

	@Override
	public int insertJobByRec(Recruitment recruitment) {
		return jobMapper.insertJobByRec(recruitment);
	}

	@Override
	public List<Recruitment> selectRecByCompanyId(String companyId) {
		return recruitmentMapper.selectRecByCompanyId(companyId);
	}

	@Override
	public List<Recruitment> selectRecByTerm(Recruitment recruitment) {
		return recruitmentMapper.selectRecByTerm(recruitment);
	}

}
