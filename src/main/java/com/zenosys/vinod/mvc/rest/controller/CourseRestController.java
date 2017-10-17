/**
 * 
 */
package com.zenosys.vinod.mvc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zenosys.vinod.mvc.model.CoursesModel;
import com.zenosys.vinod.mvc.service.CourseService;

/**
 * This class represents CourseRestController
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
@RestController
@RequestMapping("/rest")
public class CourseRestController {

	@Autowired
	private CourseService courseService;

	@GetMapping
	@ResponseBody
	public String getMainPage(){
		return "Hello";
	}
	
	@GetMapping(value="/courses/{id}")
	public CoursesModel getCourse(@PathVariable int id){
		
		return courseService.findCourseById(id);
	}
	
	@GetMapping(value="/courses")
	public List<CoursesModel> getAllCourses(){
		return courseService.findAllCourses();
	}
	
	@PostMapping(value="/courses")
	public CoursesModel addNewCourse(@RequestBody CoursesModel coursesModel){
		return courseService.createNewCourse(coursesModel);
	}
	
	@PutMapping(value="/courses/{id}")
	public CoursesModel updateCourseDetail(@PathVariable int id,@RequestBody CoursesModel coursesModel){
		coursesModel.setId(id);
		return courseService.updateCourse(coursesModel);
	}
	
	@DeleteMapping(value = "/courses/{id}")
	public void deleteCourse(@PathVariable int id) {

		courseService.deleteCourse(id);
	}
}
