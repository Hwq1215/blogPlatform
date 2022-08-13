package com.example.coinsblog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



@Mapper
public interface AlyMapper {
    @Update("update aly_info set value=#{value} where dic=#{key}")
    void updateValue(@Param("key") String key,@Param("value") Integer value);

    @Select("select value from aly_info where dic=#{key}")  //key再mysql中是关键字
    Integer getValue(@Param("key") String key);
}
