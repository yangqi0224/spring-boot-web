package com.smsm.service.impl;

import java.util.List;

import com.smsm.mapper.CompanyMapper;
import com.smsm.mapper.JobMapper;
import com.smsm.mapper.ResumeMapper;
import com.smsm.mapper.ToEmployMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.smsm.model.*;
import com.smsm.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private JobMapper jobMapper;

	@Autowired
	private ResumeMapper resumeMapper;
	
	@Autowired
	private ToEmployMapper toEmployMapper;
	
	public int insertUserInfo(User user){
		return companyMapper.insertSelective1(user);
	}
	public int updateUser(User user){
		return companyMapper.updateByPrimaryKey1(user);
	}
	public Company findUserInfo(String userPhone){
		return companyMapper.selectByPrimaryKey1(userPhone);
	}

	@Override
	public int insertCompanyInfo(Company company) {
		return companyMapper.insertCompanyInfo(company);
	}

	@Override
	public int updateCompanyInfo(Company company) {
		return companyMapper.updateCompanyInfo(company);
	}

	@Override
	public Company getCompanyByUserPhone(String userPhone) {
		// TODO Auto-generated method stub
		return companyMapper.getCompanyBuUserPhone(userPhone);
	}
	@Override
	public Job getJobByJobName(String jobId) {
		// TODO Auto-generated method stub
		return jobMapper.getJobByJobName(jobId);
	}

	@Override
	public List<Company> findAllCompany() {
		return companyMapper.findAllCompany();
	}

	@Override
	public Company selectCompanyById(String companyId) {
		return companyMapper.selectCompanyById(companyId);
	}

	@Override
	public List<Resume> selectResumesByToEmploy(String companyId) {
		return resumeMapper.selectResumesByToEmploy(companyId);
	}

	@Override
	public List<ToEmploy> selectToEmployByCompany(String companyId) {
		return toEmployMapper.selectToEmployByCompany(companyId);
	}

	@Override
	public List<ToEmploy> selectToEmployByRec(String recruitmentId) {
		return toEmployMapper.selectToEmployByRec(recruitmentId);
	}

	@Override
	public int uploadImage(String userPhone, String imgName) {
		return companyMapper.uploadImage(userPhone,imgName);
	}
}
