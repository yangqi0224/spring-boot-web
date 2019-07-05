package com.smsm.service.impl;

import java.util.List;

import com.smsm.mapper.ResumeMapper;
import com.smsm.model.ProjectExp;
import com.smsm.model.WorkHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsm.model.Resume;
import com.smsm.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService{

	@Autowired
	private ResumeMapper resumeMapper;
	
	public int insertUserInfo(Resume resume){
		return resumeMapper.insert(resume);
	}
	
	public int updateUserInfo(Resume resume){
		return resumeMapper.updateSelective(resume);
	}
	
	public Resume selectResumeAll(String userId){
		return resumeMapper.selectResumeAll(userId);
	}
	
	public Resume selectResumeById(String resumeId){
		return resumeMapper.selectResumeByIdZc(resumeId);
	}
	
	public int deleteResumeById(String resumeId){
		return resumeMapper.deleteByPrimaryKey(resumeId);
	}

	@Override
	public int insertWorkHistory(WorkHistory workHistory) {
		return resumeMapper.insertWorkHistory(workHistory);
	}

	@Override
	public List<WorkHistory> selectWorkHisByResume(String resumeId) {
		return resumeMapper.selectWorkHisByResume(resumeId);
	}

	@Override
	public int updateWorkHistory(WorkHistory workHistory) {
		return resumeMapper.updateWorkHistory(workHistory);
	}

	@Override
	public int insertProExp(ProjectExp projectExp) {
		return resumeMapper.insertProjectExp(projectExp);
	}

    @Override
    public List<ProjectExp> selectProExp(String resumeId) {
        return resumeMapper.selectProExp(resumeId);
    }

    @Override
    public int updateProjectExp(ProjectExp projectExp) {
        return resumeMapper.updateProjectExp(projectExp);
    }

	@Override
	public int deleteProjectExp(String projectExpId) {
		return resumeMapper.deleteProjectExp(projectExpId);
	}

	@Override
	public int deleteWorkHistory(String workHistoryId) {
		return resumeMapper.deleteWorkHistory(workHistoryId);
	}

	@Override
	public int uploadImage(String userId, String imgName) {
		return resumeMapper.uploadImage(userId,imgName);
	}
}
