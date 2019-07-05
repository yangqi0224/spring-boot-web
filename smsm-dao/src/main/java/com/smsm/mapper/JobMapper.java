package com.smsm.mapper;

import com.smsm.model.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobMapper {
    long countByExample(JobExample example);

    int deleteByExample(JobExample example);

    int deleteByPrimaryKey(String jobId);

    int insert(Job record);

    int insertSelective(Job record);

    List<Job> selectByExample(JobExample example);

    Job selectByPrimaryKey(String jobId);

    int updateByExampleSelective(@Param("record") Job record, @Param("example") JobExample example);

    int updateByExample(@Param("record") Job record, @Param("example") JobExample example);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
    
    Job getJobByJobName(String jobId);

    //查找招聘信息中的职位是否存在
    Job selectJobByRec(Recruitment recruitment);

    //插入招聘信息中的职位
    int insertJobByRec(Recruitment recruitment);
}