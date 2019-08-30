package ssm2;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dao.Type_Dao1;
import model.Type;

public class JunitTest {
	
	@Autowired
	Type_Dao1 dao;
	
	@Test
	public void aa() {
		dao.selectById(1);
		
	}
}
