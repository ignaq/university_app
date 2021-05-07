package ar.com.nacho.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.com.nacho.app.error.NotFoundException;

import ar.com.nacho.app.models.entity.Course;
import ar.com.nacho.app.models.entity.Student;
import ar.com.nacho.app.models.entity.User;
import ar.com.nacho.app.models.service.ICourseService;
import ar.com.nacho.app.models.service.IStudentService;
import ar.com.nacho.app.models.service.IUserService;

@Controller
public class CourseController {

	
	@Autowired 
	private ICourseService courseService;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value= {"/listar" , "/"})
	public String listSubject(Model model){
		model.addAttribute("titulo", "Listado de asignaturas");
		model.addAttribute("asignaturas", courseService.findByOrderName());
		return "listar";
	}
	
	
	
	@GetMapping(value = "/descripcion/{id}")
	public String descripcion(@PathVariable(value = "id") Long id, Map<String, Object> model){
		Course course = courseService.findOne(id);
		if(course==null){
			throw new NotFoundException();
		}
		
		model.put("asignatura", course);
		model.put("titulo", course.getName());
		return "descripcion";
	}
	
	
	
	
	@RequestMapping(value = "/ingresar/{id}")
	public String addCourseStudent(@PathVariable(value = "id") Long id ,
			Authentication auth, RedirectAttributes flash) {
	
		Course course = courseService.findOne(id);
		
		User user = userService.findByUsername(auth.getName());
		
		Student student = studentService.findById(user.getId());
		
		Course cursando = courseService.findByHours(user.getId(), course.getSchedule());
		
		
		if(student==null || course==null) {		
	     return "redirect:/";
		}
		
		if(course.getStudents().contains(student)) {
			flash.addFlashAttribute("error", "ya estás inscripto a este curso");
			return "redirect:/";
		}
		
		/* Comprobar si el estudiante está inscripto en esa hora */
		if(!(cursando==null)) {
			flash.addFlashAttribute("error", "Ya estás cursando una asignatura con el mismo horario");
			return "redirect:/";
		}
		
		
		
		
		if(course.getMaximumQuota()==course.getQuota()) {
		flash.addFlashAttribute("error", "No quedan cupos disponibles para este curso");	
		
		 return "redirect:/";
		}
		course.getStudents().add(student);
		student.getCourses().add(course);
		
		/* Aumento cantidad de inscriptos*/
		course.setQuota(course.getQuota() + 1);
		courseService.save(course);
		studentService.save(student);
		flash.addFlashAttribute("success", "La inscripción se realizó con éxito!");	
		return "redirect:/";
	}
	
	
	
	
	@RequestMapping(value="/perfil")
	public String studentProfile(Map<String, Object> model, Authentication auth) {
		
		User user = userService.findByUsername(auth.getName());
		
		
		model.put("titulo", "Perfil de usuario");
		model.put("asignaturas", courseService.findCoursesByUser(user.getId()));
		model.put("user", user);
		return "/perfil";
	}
	
}
