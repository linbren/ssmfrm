package net.business.system.dao;

import net.business.system.entity.TsDicttype;

public interface TsDicttypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsDicttype record);

    int insertSelective(TsDicttype record);

    TsDicttype selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsDicttype record);

    int updateByPrimaryKey(TsDicttype record);
}