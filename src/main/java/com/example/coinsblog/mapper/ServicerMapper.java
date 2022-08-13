package com.example.coinsblog.mapper;

import com.example.coinsblog.pojo.Servicer;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ServicerMapper {
    @Insert("insert servicer_info(name,host,admin,password) values(#{name},#{host},#{admin},#{password})")
    void addServicer(Servicer servicer);

    @Select("select * from servicer_info")
    List<Servicer> getServicers();

    @Select("select * from servicer_info where name=#{name}")
    Servicer getServicerByName(String name);

    @Delete("delete from servicer_info where name=#{name}")
    void deleteServicer(String name);
}
