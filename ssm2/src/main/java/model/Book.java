package model;

public class Book {
	public static String[]sexs= {"²»ÏÞ","ÄÐ","Å®"};
	public String getSexname() {
		return sexs[sex];
	}

	private String typename;
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	
	private int id;
	private String name;
	private int sex;

	private int typeid;
	
	


	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(String name) {
		super();
		this.name = name;
	}

	public int getTypeid() {
		return typeid;
	}


	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		//int id1 =Integer.valueOf(id);
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
