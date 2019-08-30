package controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import model.Book;
import model.Type;
import service.Book_Service;
import service.Type_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Book")
public class BookController {
	
	
		@Autowired
		Book_Service service;
		//Type_Dao dao;
		@Autowired
		Type_Service tservice;
		
		
		@ModelAttribute("all")   //返回值加入Model
		public int aaass() {
			System.out.println("ddddd");
			return 300;
		}
		
		@RequestMapping("sss")
		public  @ResponseBody String aaa(@RequestParam("file") CommonsMultipartFile file,
	        HttpServletRequest req )throws Exception {
			String oname=file.getOriginalFilename();
			String ex=oname.substring(oname.lastIndexOf("."),oname.length());
			String nname = UUID.randomUUID()+ex;
			
			String path=req.getSession().getServletContext().getRealPath("");
			path=new File(path).getParentFile().getPath()+"\\upload";
			System.out.println(path);
			file.transferTo(new File(path,nname));
			return "/upload/"+nname;
		}
		//D:\apache-tomcat-8.5.28\apache-tomcat-8.5.28
		
//		@GetMapping("sss")
//		public void aaa( @ModelAttribute("all") int id,ModelMap m) {
//			System.out.println(id);
//		}
		
		
//		@GetMapping("sss/{myid}")
//		public void aaa(@PathVariable("myid") int id) {
//			System.out.println(id);
//		}
		
		@DeleteMapping("sss")
		public void aaa() {
			System.out.println("dddd");
		}
		
		@ExceptionHandler
		public void ex(Exception e) {
			e.printStackTrace();
		}
		
		
		@RequestMapping("index")
		public @ResponseBody ReturnInfo index(String txt ,Integer page,Integer limit,ModelMap m){//使用Integer 担心page为空
			return service.select(txt,page,limit);
		}
		
		@RequestMapping("delete")
		public @ResponseBody String delete( int id,ModelMap m){
			service.delete(id);
			return "{\"status\":1}";
		}
//		@RequestMapping("select")
//		public String select( String txt,ModelMap m){
//			//service.select(name);
//			return index(txt,m);
//		}
		
		@RequestMapping("edit")
		public @ResponseBody Book editor(Book t,ModelMap m){
			return service.selectByid(t);
		}
//		@RequestMapping("add")
//		public String add(ModelMap m){
//			m.put("sexs",Book.sexs);
//			m.put("typelist",tservice.selectType());
//			return "Book/edit";
//		}
		@RequestMapping("getSexs")
		public @ResponseBody String[] getSexs() {
			return Book.sexs;
		}
		
		@RequestMapping("getTypes")
		public @ResponseBody List<Type> getTypes() {
			return tservice.selectType();
		}
		
		@RequestMapping("insert")
		public @ResponseBody String insert(Book t,ModelMap m){
			service.insert(t);
			return "{\"status\":1}";
		}
		@RequestMapping("update")
		public @ResponseBody String update(Book t,ModelMap m){
			service.update(t);
			return "{\"status\":1}";
		}
}
