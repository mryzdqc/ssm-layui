package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Book_Dao;
import model.Book;
import service.Book_Service;
import utils.ReturnInfo;
import model.Type;

@Service
public class Book_Service_Impl implements Book_Service{
	
	@Autowired
	Book_Dao dao;
	
	public ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt==null||txt.length()==0) txt="";
		else txt="where book.name like '%"+txt+"%'";
		ReturnInfo info = new ReturnInfo();
		String limitstr="";
		if(page!=null) {
			limitstr="limit "+((page-1)*limit)+","+limit;
			info.setCount(dao.selectCount(txt));
		}
		info.setList(dao.select(txt,limitstr));
		return info;
	}
	
	public Book selectByid(Book t){
		return dao.selectByid(t);
	}
	
	public int insert(Book t) {
		return dao.insert(t);
	}

	public void update(Book t) {
		dao.update(t);
	}

	public void delete(int id) {
		dao.delete(id);
	}

//	public List<Type> selectType() {
//		return dao.selectType();
//	}

}
