package ar.com.nacho.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="teachers")
public class Teacher implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="name")
	@NotEmpty
	private String name;
	
	@Column(name="last_name")
	@NotEmpty
	private String lastName;
	
	
	private int active;
	
	@OneToMany(mappedBy = "teacher" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Course> courses;
	
	public Teacher() {
		courses = new ArrayList<Course>();
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int isActive() {
		return active;
	}



	public void setActive(int active) {
		this.active = active;
	}



	public List<Course> getSubjects() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCouse(Course course) {
		this.courses.add(course);
	}
	

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", lastName=" + lastName + ", active=" + active + ", courses="
				+ courses + "]";
	}

	
	
	
}
