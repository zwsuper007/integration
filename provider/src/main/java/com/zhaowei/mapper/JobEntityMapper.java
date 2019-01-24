package com.zhaowei.mapper;


import com.zhaowei.entity.JobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobEntity record);

    int insertSelective(JobEntity record);

    JobEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobEntity record);

    int updateByPrimaryKey(JobEntity record);

    List<JobEntity> findAll();
}