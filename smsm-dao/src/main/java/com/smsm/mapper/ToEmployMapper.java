package com.smsm.mapper;

import com.smsm.model.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ToEmployMapper {
    long countByExample(ToEmployExample example);

    int deleteByExample(ToEmployExample example);

    int insert(ToEmploy record);

    int insertSelective(ToEmploy record);

    List<ToEmploy> selectByExample(ToEmployExample example);

    int updateByExampleSelective(@Param("record") ToEmploy record, @Param("example") ToEmployExample example);

    int updateByExample(@Param("record") ToEmploy record, @Param("example") ToEmployExample example);

    /**
     * 查找该公司的应聘信息
     * @param company
     * @return
     */
    public List<ToEmploy> selectToEmploy(Company company);

    /**
     * 个人用户投递简历
     * @param toEmploy
     * @return
     */
    int insertToEmploy(ToEmploy toEmploy);

    //按照用户查看投递记录
    List<ToEmploy> selectAllToEmployByUser(String userId);

    ToEmploy selectRecordByUser(@Param("userId")String userId,@Param("recruitmentId")String recruitmentId);

    List<ToEmploy> findAllRecord();

    List<ToEmploy> selectToEmployByCompany(String companyId);

    int insertToEmployByUser(@Param("userId") String userId,@Param("recruitmentId") String recruitmentId);

    List<ToEmploy> selectToEmployByRec(String recruitmentId);

    int updateToEmploy(ToEmploy toEmploy);
}