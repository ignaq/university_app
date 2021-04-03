package ar.com.nacho.app.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.nacho.app.models.entity.Course;
import ar.com.nacho.app.models.entity.Teacher;
import ar.com.nacho.app.models.service.ICourseService;
import ar.com.nacho.app.models.service.ITeacherService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired 
	private ICourseService CourseService;
	
	
	@Autowired
	private ITeacherService teacherService;
	
	
	/* mapeo objeto asignatura a formulario */
	@RequestMapping(value="/add")
	public String AddSCourse(Map<String, Object> model ) {
		
		Course course = new Course();
		model.put("titulo", "Crear asignatura");
		
		model.put("teachers", teacherService.findAll());
		model.put("course", course);
		
		return "admin/add";
	}
	
	/* Guardo objeto asignatura a la base de datos */
	@RequestMapping(value="/add" , method = RequestMethod.POST )
		public String saveCourse(@ModelAttribute(name = "teacherid") Long id,
				 Course course, Model model) {
		
		Teacher teacher = teacherService.findOne(id);
		
	    course.setMaximumQuota(course.getMaximumQuota());
	    course.setName(course.getName());
	    course.setSchedule(course.getSchedule());
	    course.setTeacher(teacher);
	    course.setQuota(0);
	
	   
		CourseService.save(course);
			return "redirect:/listar";
		}
	
	/* mapeo objeto docente a formulario */
	
		@RequestMapping(value="/add_teacher")
		public String addTeacher(Map<String, Object> model) {
		
		Teacher teacher = new Teacher();
		
		model.put("titulo", "Ingresar nuevo docente");
		model.put("teacher", teacher);
		
		return "admin/add_teacher";
	}
	
		/* Guardo nuevo docente a la base de datos */
		@RequestMapping(value="/add_teacher" , method = RequestMethod.POST)
		public String saveTeacher(@Valid Teacher teacher , BindingResult result, Model model) {
			
			if(result.hasErrors()) {
				model.addAttribute("titulo", "Ingresar nuevo docente");
				return "admin/add_teacher";
			}
			teacherService.save(teacher);
			return "redirect:/listar";
		}
}












