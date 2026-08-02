package studentmanagement.model;

public class Student {
	
	int id;
	String name;
	String department;
	String email;
	String phone;
	
	public Student(int id,String name,String department,String email,String phone)
	{
		this.id=id;
		this.name=name;
		this.department=department;
		this.email=email;
		this.phone=phone;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPhone()
	{
		return phone;
	}

}
