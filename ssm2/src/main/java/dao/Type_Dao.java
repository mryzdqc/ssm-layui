package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Type;
import utils.ReturnInfo;

@Repository
public interface Type_Dao {
	@Select("select * from type")
	public ReturnInfo select(Integer page,Integer limit);
	
	@Select("select * from type where id=#{id}")
	public Type selectById(Type t);
	
	@Insert("insert into type (name) values(#{name})")
	public void insert(Type t);
	
	@Update("update type set name=#{name} where id=#{id}")
	public void update(Type t);
	
	@Delete("delete from type where id=#{id} ")
	public void delete(int id);
	
	@Select("select * from Type")
	public List<Type> selectType();
	
	
}
