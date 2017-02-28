package net.business.system.dao;

import net.business.system.entity.TsDictionary;

public interface TsDictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsDictionary record);

    int insertSelective(TsDictionary record);

    TsDictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsDictionary record);

    int updateByPrimaryKey(TsDictionary record);
}