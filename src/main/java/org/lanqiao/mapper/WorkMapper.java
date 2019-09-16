package org.lanqiao.mapper;

import org.lanqiao.entity.Work;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkMapper {
    int deleteByPrimaryKey(Integer workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}