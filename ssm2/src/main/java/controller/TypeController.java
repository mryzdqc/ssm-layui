package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import model.Type;

import service.Type_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Type")
public class TypeController {
	
		@Autowired
		Type_Service service;
		
		@RequestMapping("index")
		public @ResponseBody ReturnInfo index(Integer page,Integer limit,ModelMap m){//使用Integer 担心page为空
			return service.select(page,limit);
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
		public @ResponseBody Type editor(Type t,ModelMap m){
			return service.selectById(t);
		}
		@RequestMapping("insert")
		public @ResponseBody String insert(Type t,ModelMap m){
			service.insert(t);
			return "{\"status\":1}";
		}
		@RequestMapping("update")
		public @ResponseBody String update(Type t,ModelMap m){
			service.update(t);
			return "{\"status\":1}";
		}
}
