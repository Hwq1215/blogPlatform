package com.example.coinsblog.mapper;

import com.example.coinsblog.pojo.Icon;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IconMapper {
    @Insert("insert icon_info(iconName,imgPath,urlPath,htmlClass) values(#{iconName},#{imgPath},#{urlPath},#{htmlClass})")
    void addIcon(Icon icon);

    @Select("select * from icon_info where iconName=#{iconName}")
    List<Icon> getIconById(String iconName);

    @Delete("delete from icon_info where iconName=#{iconName}")
    void deleteIcon(String iconName);

    @Select("select * from icon_info")
    List<Icon> getAllIcons();
}
