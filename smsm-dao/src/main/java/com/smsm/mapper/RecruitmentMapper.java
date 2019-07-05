package com.smsm.mapper;

import com.smsm.model.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import javax.xml.bind.ValidationEvent;

public interface RecruitmentMapper {
    long countByExample(RecruitmentExample example);

    int deleteByExample(RecruitmentExample example);

    int insert(Recruitment record);

    int insertSelective(Recruitment record);

    List<Recruitment> selectByExample(RecruitmentExample example);

    int updateByExampleSelective(@Param("record") Recruitment record, @Param("example") RecruitmentExample example);

    int updateByExample(@Param("record") Recruitment record, @Param("example") RecruitmentExample example);
    
    //插入招聘信息
    public int insertRecruit(Recruitment recruitment);
    
	//浏览招聘信息
	List<Company_Recruitment> SelectRecruitment();
	
	//浏览最新招聘信息
	List<Company_Recruitment> SelectRecruitByTime();
	
	 //浏览最新招聘信息
	List<Recruitment> SelectRecruitByJobName(@Param(value = "jobName") String jobName);
	
    //按企业名称浏览最新招聘信息
	List<Company_Recruitment> SelectRecruitByCompanyName(@Param(value = "companyName") String companyName);
	
	//查找recruitment表中的热聘岗位
	List<Job> selectHotJob();
	
	//查找job表中的所有岗位
	List<Job> selectAllJob();

	//查找特定的招聘信息
	Company_Recruitment selectRecruitById(@Param(value = "createTime")String createTime);

	//
	List<Recruitment> selectRecByCompanyId(String companyId);

	Recruitment selectRecById(String Id);

	Company selectCompanyById(String companyId);

	List<Recruitment> selectRecByTerm(@Param(value = "recruitment")Recruitment recruitment);
}