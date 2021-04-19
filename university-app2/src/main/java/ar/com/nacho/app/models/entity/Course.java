package ar.com.nacho.app.models.entity;

import java.io.Serializable;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "courses")
public class Course implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	
	@Column(name="schedule")
	private String schedule;
	
	@Column(name="quota")
	private int quota;
	@Column(name="maximum_quota")
	private int maximumQuota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Teacher teacher;
	
	
	/* relacion con student*/
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(name = "course_student" ,
	joinColumns = { @JoinColumn(name="course_id")},
	inverseJoinColumns = { @JoinColumn(name="student_id")})
	private Set<Student> students = new HashSet<>();
	

	
	/*getters and setters*/
	
	public Long getId() {
		return id;
	}



	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getSchedule() {
		return schedule;
	}


	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}


	public int getQuota() {
		return quota;
	}



	public void setQuota(int quota) {
		this.quota = quota;
	}


	public int getMaximumQuota() {
		return maximumQuota;
	}


	public void setMaximumQuota(int maximumQuota) {
		this.maximumQuota = maximumQuota;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}



	public int currentQuota() {
		return this.maximumQuota - this.quota;
	}
   






	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
