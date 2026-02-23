package com.tyss;

public class User {

	private String name;
	private String email;
	private String password;
	private int age;
	private String address;
	private long phone;
	private String gender;

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", age=" + age + ", address="
				+ address + ", phone=" + phone + ", gender=" + gender + "]";
	}

	public User() {
	}

	public User(String name, String email, String password, int age, String address, long phone, String gender) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
