package com.smsm.service;

import java.util.List;

import com.smsm.model.Company_Recruitment;
import com.smsm.model.Job;
import com.smsm.model.Recruitment;

public interface RecruitmentService {
	
	//浏览招聘信息
	List<Company_Recruitment> selectRecruitment();
	
	//浏览最新招聘信息
	List<Company_Recruitment> selectRecruitByTime();
	
	//浏览最新招聘信息
	List<Recruitment> selectRecruitByJobName(String jobName);
	
	//按企业名称浏览最新招聘信息
	List<Company_Recruitment> selectRecruitByCompanyName(String companyName);

	//插入招聘信息
	int insertRecruit(Recruitment recruitment);
	
	//更改招聘信息
	int updateRecruit(Recruitment recruitment);

	//通过主键查找招聘信息
	Recruitment selectRecruitById(String id);

	//查找招聘信息中的职位是否存在
	Job selectJobByRec(Recruitment recruitment);

	//插入招聘信息中的职位
	int insertJobByRec(Recruitment recruitment);

	//按照公司id查询所有招聘信息
	List<Recruitment> selectRecByCompanyId(String companyId);

	List<Recruitment> selectRecByTerm(Recruitment recruitment);

	
	
}
