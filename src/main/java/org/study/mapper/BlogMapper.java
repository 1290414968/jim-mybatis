package org.study.mapper;

import org.apache.ibatis.annotations.Param;
import org.study.beans.Blog;
import org.study.beans.BlogExample;

import java.util.List;

public interface BlogMapper {
    int countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

    Blog selectAssociationById(Long id);

    Blog selectAssociationByResultById(Long id);

    Blog selectResultTypeById(Long id);
}