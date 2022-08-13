package com.example.coinsblog.mapper;

import com.example.coinsblog.pojo.Hole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HoleMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert hole_info(id,content,timestamp,status,url) values(#{id},#{content},#{timestamp},#{status},#{url})")
    void addHole(Hole hole);

    @Select("select * from hole_info where id = #{id}")
    Hole getHoleById(Integer id);

    @Select("select * from hole_info order by timestamp desc")
    List<Hole>  getAllHoles();

    @Update("update hole_info set content=#{content},timestamp=#{timestamp},status=#{status},url=#{url} where id=#{id}")
    void updateHole(Hole hole);

    @Delete("delete from hole_info where id=#{id}")
    void deleteHole(Integer id);
}
