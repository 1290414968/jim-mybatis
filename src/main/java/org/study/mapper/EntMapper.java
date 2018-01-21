package org.study.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.study.beans.Ent;
import org.study.beans.EntExample;

public interface EntMapper {
    int countByExample(EntExample example);

    int deleteByExample(EntExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ent record);

    int insertSelective(Ent record);

    List<Ent> selectByExample(EntExample example);

    Ent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ent record, @Param("example") EntExample example);

    int updateByExample(@Param("record") Ent record, @Param("example") EntExample example);

    int updateByPrimaryKeySelective(Ent record);

    int updateByPrimaryKey(Ent record);
}