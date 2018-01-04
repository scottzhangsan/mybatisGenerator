package com.itdragon.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.itdragon.mapper.ClassroomMapper;
import com.itdragon.pojo.ClassroomExample;
import com.itdragon.pojo.ClassroomExample.Criteria;

public class JunitTest {
	
	private static SqlSessionFactory sqlSessionFactory = null ;
	private static Reader reader = null ;
	@BeforeClass
	public  static void init() throws IOException{
		System.out.println("111");
		try {
			//读取mybatis-config文件。
			 reader =Resources.getResourceAsReader("mybatis-config.xml") ;
			 //获取sqlSessionFactory
			 sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			reader.close();
		}
	}
	@Test
	public void testClassroom(){
		ClassroomMapper classroomMapper =sqlSessionFactory.openSession().getMapper(ClassroomMapper.class) ;
	    ClassroomExample example = new ClassroomExample() ;
	    Criteria criteria =example.createCriteria() ;
	    criteria.andRoomEqualTo("Linux") ;
		Integer result = classroomMapper.countByExample(example) ;
		Assert.assertNotNull(result);
		
	}

}
