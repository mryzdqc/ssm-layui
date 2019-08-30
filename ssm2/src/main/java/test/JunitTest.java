package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.Type_Dao1;
import model.Type;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class JunitTest {
	
	@Autowired
	Type_Dao1 dao;
	
	@Test
	public void aa() {
		Type t = dao.selectById(1);
		System.out.println(t.getName());
		
	}
}
