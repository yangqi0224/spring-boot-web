package com.smsm.mapper;

import com.smsm.model.*;


import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CompanyMapper {
    long countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(String companyId);

    int insert(Company record);

    List<Company> selectByExampleWithBLOBs(CompanyExample example);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(String companyId);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExampleWithBLOBs(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKeyWithBLOBs(Company record);

    int updateByPrimaryKey(Company record);
    
    int insertSelective1(User user);
    
	int updateByPrimaryKey1(User user);
	Company selectByPrimaryKey1(String companyName);
	
	Company getCompanyBuUserPhone(String userPhone);

	//更新一条公司记录
	int updateCompanyInfo(Company record);
	//插入一条公司信息
    int insertCompanyInfo(Company record);
	//查找所有公司
    List<Company> findAllCompany();

    Company selectCompanyById(String companyId);

    int uploadImage(@Param("userPhone")String userPhone,@Param("imgName")String imgName);
}