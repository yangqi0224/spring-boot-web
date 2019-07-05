package com.smsm.service;

import java.util.List;
import java.util.Map;

import com.smsm.model.*;


public interface CompanyService {

	Company findUserInfo(String userPhone);
	int insertUserInfo(User user);
	int updateUser(User user);


	//新增一条公司信息
	int insertCompanyInfo(Company company);

	//更新公司信息
	int updateCompanyInfo(Company company);

	//根据userPhone查询companyId
	Company getCompanyByUserPhone(String userPhone);
	
	//根据job_name查job_id
	Job getJobByJobName(String jobId);

	//查找所有公司
	List<Company> findAllCompany();

	Company selectCompanyById(String companyId);

	List<Resume> selectResumesByToEmploy(String companyId);

	List<ToEmploy> selectToEmployByCompany(String companyId);

	List<ToEmploy> selectToEmployByRec(String recruitmentId);

	int uploadImage(String userPhone,String imgName);
}
