package com.itdragon.mapper;
///测试冲突
import com.itdragon.pojo.Classroom;
import com.itdragon.pojo.ClassroomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassroomMapper {
    int countByExample(ClassroomExample example);

    int deleteByExample(ClassroomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    List<Classroom> selectByExample(ClassroomExample example);

    Classroom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classroom record, @Param("example") ClassroomExample example);

    int updateByExample(@Param("record") Classroom record, @Param("example") ClassroomExample example);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);
}
