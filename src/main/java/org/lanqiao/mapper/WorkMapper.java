package org.lanqiao.mapper;

import org.lanqiao.entity.Work;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkMapper {
    int deleteByPrimaryKey(Integer workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
//    hcy
//    取出摄影图集
List selectAllWork(Work work);
}