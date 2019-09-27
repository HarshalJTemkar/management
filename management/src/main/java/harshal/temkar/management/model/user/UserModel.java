package harshal.temkar.management.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import harshal.temkar.management.model.base.BaseModel;

@Entity
@Table(name = "user_master")
public class UserModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Size(min = 2, max = 30)
	@Column(name = "first_name", length = 30)
	private String first_name;

	@NotNull
	@Min(18)
	@Max(100)
	@Column(name = "age", length = 3)
	private Integer age;

	@NotNull
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dob")
	private Date dob;

	@NotNull
	@Column(name = "gender", length = 6)
	private String gender;

	@NotNull
	@Column(name = "contact", length = 10)
	private String contact;

	@NotNull
	@Column(name = "email", length = 75)
	private String email;

	@NotNull
	@Column(name = "user_id", length = 15)
	private String user_id;

	@NotNull
	@Column(name = "password", length = 50)
	private String password;

	@Override
	public String toString() {
		return "UserModel [first_name=" + first_name + ", age=" + age + ", dob=" + dob + ", gender=" + gender
				+ ", contact=" + contact + ", email=" + email + ", user_id=" + user_id + ", password=" + password + "]";
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
