package service;

import java.util.List;



import model.Book;
import model.Type;
import utils.ReturnInfo;

public interface Book_Service {
	public ReturnInfo select(String name,Integer page,Integer limit);
	
	public int insert(Book t);
	
	public Book selectByid(Book t);
	
	public void update(Book t);
	
	public void delete(int id);
	
//	public List<Type> selectType();
}
