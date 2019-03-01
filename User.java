package com.itheima.core.po;
import java.io.Serializable;
/**
 * 用户持久化类
 */
public class User implements Serializable{
	/*serialVersionUID 用来表明类的不同版本间的兼容性	
Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，
JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，
如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常。
*/
	private static final long serialVersionUID = 1L;
	private Integer user_id;      //用户id 
	private String user_name;     //用户名称
	private String user_pass; //用户密码
	private Integer user_age;      //用户年龄 
	private String user_sex;     //用户性别
	private String user_email; //用户EMAIL	
	private Integer user_rank;   //用户级别	
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public Integer getUser_age() {
		return user_age;
	}
	public void setUser_age(Integer user_age) {
		this.user_age = user_age;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Integer getUser_rank() {
		return user_rank;
	}
	public void setUser_rank(Integer user_rank) {
		this.user_rank = user_rank;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
//	private static final long serialVersionUID = 1L;
//	private Integer user_id;      //用户id 
//	private String user_code;     //用户账号
//	private String user_name;     //用户名称
//	private String user_password; //用户密码
//	private Integer user_state;   //用户状态
//	public Integer getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(Integer user_id) {
//		this.user_id = user_id;
//	}
//	public String getUser_code() {
//		return user_code;
//	}
//	public void setUser_code(String user_code) {
//		this.user_code = user_code;
//	}
//	public String getUser_name() {
//		return user_name;
//	}
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}
//	public String getUser_password() {
//		return user_password;
//	}
//	public void setUser_password(String user_password) {
//		this.user_password = user_password;
//	}
//	public Integer getUser_state() {
//		return user_state;
//	}
//	public void setUser_state(Integer user_state) {
//		this.user_state = user_state;
//	}
}
