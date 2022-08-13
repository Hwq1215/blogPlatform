package com.example.coinsblog.mapper;
import java.util.*;
import com.example.coinsblog.pojo.Doc;
import org.apache.ibatis.annotations.*;
@Mapper
public interface DocMapper {
    @Insert("insert doc_info(name,url) values(#{name},#{url})")
   void addDoc(Doc doc);

    @Select("select * from doc_info")
    List<Doc> getAllDoc();

    @Select("select * from doc_info where name=#{name}")
    Doc getDocByName(@Param("name") String name);

    @Delete("delete from doc_info where name=#{name}")
    void deleteDoc(String name);
}
