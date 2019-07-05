package com.smsm.mapper;
import com.smsm.model.*;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResumeMapper {
    long countByExample(ResumeExample example);

    int deleteByExample(ResumeExample example);

    int deleteByPrimaryKey(String resumeId);

    int insert(Resume record);

    int insertSelective(Resume record);

    List<Resume> selectByExampleWithBLOBs(ResumeExample example);

    List<Resume> selectByExample(ResumeExample example);

    Resume selectByPrimaryKey(String resumeId);

    int updateSelective(@Param("record") Resume record);

    int updateByExampleWithBLOBs(@Param("record") Resume record, @Param("example") ResumeExample example);

    int updateByExample(@Param("record") Resume record, @Param("example") ResumeExample example);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKeyWithBLOBs(Resume record);

    int updateByPrimaryKey(Resume record);
    
    //更新简历
    int updateResume(Resume resume);
    
    //查询简历
    List<Resume> selectResumeByUser(User user);

    //查询第一条简历
    Resume selectFirstResumeByUserId(String userId);
    
    //删除简历
    int deleteResume(String resumeId);
    
    //查找简历
    Resume selectResumeAll(String userId);
    
    //按照Id查简历
    Resume selectResumeByIdZc(String resumeId);

    //工作经历
    int insertWorkHistory(WorkHistory workHistory);

    List<WorkHistory> selectWorkHisByResume(String resumeId);

    int updateWorkHistory(@Param("record") WorkHistory record);

    //项目经验
    int updateProjectExp(ProjectExp reocrd);
    int insertProjectExp(ProjectExp record);
    List<ProjectExp> selectProExp(String resumeId);

    int deleteProjectExp(String projectExpId);
    int deleteWorkHistory(String workHistoryId);

    List<Resume> selectResumesByToEmploy(String companyId);

    int uploadImage(@Param("userId") String userId,@Param("imgName") String imgName);
}