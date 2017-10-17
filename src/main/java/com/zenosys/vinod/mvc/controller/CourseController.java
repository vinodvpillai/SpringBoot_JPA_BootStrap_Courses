/**
 * 
 */
package com.zenosys.vinod.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zenosys.vinod.mvc.model.CoursesModel;
import com.zenosys.vinod.mvc.service.CourseService;

/**
 * This class Course controller class - Manage all the course related operation
 * This website will have all the request - Course related operation.
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version 1.0
 */
@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping(value = "/courses/{id}")
	public String getCourse(@PathVariable int id, Model model,RedirectAttributes redirect) {

		CoursesModel courses = courseService.findCourseById(id);
		if (courses != null) {
			model.addAttribute("courses", courses);
			return "view-course";
		} 
		redirect.addFlashAttribute("errormsg",
					"Please check the Course ID no record found");
		
		return "redirect:/courses";
	}

	@GetMapping(value = "/courses")
	public String getAllCourses(Model model) {
		List<CoursesModel> coursesList = courseService.findAllCourses();
		if (coursesList != null && coursesList.size() > 0) {
			model.addAttribute("courseslist", coursesList);
		} else {
			model.addAttribute("error-msg",
					"Please add some courses no record found!");
		}
		
		return "courses";
	}

	@GetMapping(value = "/courses/create")
	public String addNewCourse(Model model) {
		model.addAttribute("courses", new CoursesModel());
		return "create-course";
	}

	@PostMapping(value = "/courses/save")
	public String saveCoure(@ModelAttribute CoursesModel courses,
			RedirectAttributes redirect) {

		CoursesModel coursesRel = courseService.createNewCourse(courses);
		if (coursesRel != null) {
			redirect.addFlashAttribute("successmsg", "Courses added successfully");
			return "redirect:/courses";
		}
			redirect.addFlashAttribute("errormsg",
					"Sorry some error occured in adding Coures");
			return "create-course";
		
	}

	@GetMapping(value = "/courses/edit/{id}")
	public String getCourseForEdit(@PathVariable int id, Model model,
			RedirectAttributes redirect) {

		CoursesModel coursesRel = courseService.findCourseById(id);
		if (coursesRel != null) {
			model.addAttribute("courses", coursesRel);
			return "edit-course";
		}
		redirect.addFlashAttribute("errormsg",
				"Please select valid Course ID for Editing Course");
		return "redirect:/courses";
	}

	@PostMapping(value = "/courses/update")
	public String updateCourseDetail(@ModelAttribute CoursesModel courses,
			RedirectAttributes redirect) {

		courseService.updateCourse(courses);
		redirect.addFlashAttribute("sucessmsg", "Course Updated successfully.");
		return "redirect:/courses";
	}

	@GetMapping(value = "/courses/delete/{id}")
	public String deleteCourseDetail(@PathVariable int id,
			RedirectAttributes redirect) {
		courseService.deleteCourse(id);
		redirect.addFlashAttribute("successmsg", "Course Deleted successfully.");
		return "redirect:/courses";
	}

}
