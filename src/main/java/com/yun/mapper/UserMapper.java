package com.yun.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yun.model.User;

@Mapper 
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user.id = #{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name")
    })
    User getById(@Param("id") Integer id);
}