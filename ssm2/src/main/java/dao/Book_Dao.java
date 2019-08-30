package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;
import model.Type;

@Repository
public interface Book_Dao {
	
	@Select("select count(1) from Book inner join Type on Book.typeid=Type.id ${name}")
	public int selectCount(@Param("name") String name);
	
	@Select("select Book.*,type.name typename from Book inner join Type on Book.typeid=Type.id ${name} ${limit}")
	public List<Book> select(@Param("name") String name,@Param("limit") String limit);
	
	@Select("select * from Book where id=#{id}")
	public Book selectByid(Book t);
	
//	@Select("select typeid from Book")
//	public List<Type> selectType();
	
	@Insert("insert into Book(name,sex,typeid) values(#{name},#{sex},#{typeid})")
	public int insert(Book t);
	
	@Update("update Book set name=#{name},sex=#{sex},typeid=#{typeid} where id=#{id}")
	public void update(Book t);
	
	@Delete("delete from Book where id=#{id}")
	public void delete(int id);
	
	
}
