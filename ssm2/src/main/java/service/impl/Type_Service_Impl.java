package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Type_Dao;
import model.Type;
import service.Type_Service;
import utils.ReturnInfo;

@Service
public class Type_Service_Impl implements Type_Service{
	@Autowired
	Type_Dao dao;
	public ReturnInfo select(Integer page,Integer limit) {
		// TODO Auto-generated method stub
		return dao.select(page,limit);
	}

	public void insert(Type t) {
		dao.insert(t);
	}

	public void update(Type t) {
		dao.update(t);
		
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public Type selectById(Type t) {
		// TODO Auto-generated method stub
		return dao.selectById(t);
	}
	public List<Type> selectType() {
	return dao.selectType();
}

	

}
