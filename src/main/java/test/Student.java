package test;

public class Student {


	private int rollNo;

	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private int percentage;
	
	private String phoneNumber;
	
	private int klass;
	
	public Student(){}

	public Student(int rollNo, String firstName, String lastName, int age, int percentage, String phoneNumber, int klass) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.percentage = percentage;
		this.phoneNumber = phoneNumber;
		this.klass = klass;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getKlass() {
		return klass;
	}

	public void setKlass(int klass) {
		this.klass = klass;
	}
	
	
	
	

	



}
