
package com.smsm.service;

import com.smsm.model.ToEmploy;
import com.smsm.model.User;

import java.util.List;


public interface ToEmployService {

	/**
	 * 个人用户投递简历
	 * @param toEmploy
	 * @return
	 */
	int insertToEmploy(ToEmploy toEmploy);

	int insertToEmployByUser(String userId,String recruitmentId);

	ToEmploy selectRecordByUser(String userId,String recruitmentId);

	List<ToEmploy> findAllRecord();

	/**
	 * 个人用户查看投递记录
	 * @param user
	 * @return
	 */
	List<ToEmploy> selectAllToEmployByUser(String userId);

	int updateToEmploy(ToEmploy toEmploy);

}
