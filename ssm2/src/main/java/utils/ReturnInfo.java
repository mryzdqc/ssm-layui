package utils;

import java.util.List;

public class ReturnInfo {
	private int count=0;
	private int code=0;
	private String msg="";
	private List list;
	
	public static String getLimit(Integer page,Integer max) {
		if(page==null) return "";
		return " limit "+((page-1)*max)+","+max;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
}
