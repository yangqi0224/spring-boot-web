package com.smsm.service;

import com.smsm.model.ProjectExp;
import com.smsm.model.Resume;
import com.smsm.model.WorkHistory;

import java.util.List;

public interface ResumeService {
	int insertUserInfo(Resume resume);
	int updateUserInfo(Resume resume);
	Resume selectResumeAll(String userId);
	Resume selectResumeById(String resumeId);
	int deleteResumeById(String resumeId);
	int insertWorkHistory(WorkHistory workHistory);
	List<WorkHistory> selectWorkHisByResume(String resumeId);
	int updateWorkHistory(WorkHistory workHistory);
	int insertProExp(ProjectExp projectExp);
	List<ProjectExp> selectProExp(String resumeId);
	int updateProjectExp(ProjectExp projectExp);
	int deleteProjectExp(String projectExpId);
	int deleteWorkHistory(String workHistoryId);
	int uploadImage(String userId,String imgName);
}
