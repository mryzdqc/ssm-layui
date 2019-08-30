package service;

import java.util.List;


import model.Type;
import utils.ReturnInfo;

public interface Type_Service {
	
	public ReturnInfo select(Integer page,Integer limit);
	
	public Type selectById(Type t);
	
	public void insert(Type t);
	
	public void update(Type t);
	
	public void delete(int id);
	
	public List<Type> selectType();
	
}
