package com.smsm.service;

import java.util.List;
import com.smsm.model.*;

public interface UserService {

	User findUserInfo(String userPhone);
	int insertUserInfo(User user);
	int updateUser(User user);
    int insertJobSeeker(JobSeeker jobSeeker);

    JobSeeker selectJobSeekerByUserId(String userId);
	List<Job> selectHotJob();
	
	List<Job> selectAllJob();

	Resume selectFirstResumeByUserId(String userId);

	int updatePwd(User user);
}
