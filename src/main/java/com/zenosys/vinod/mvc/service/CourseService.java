/**
 * 
 */
package com.zenosys.vinod.mvc.service;

import java.util.List;

import com.zenosys.vinod.mvc.model.CoursesModel;

/**
 * This Interface shows all Course Services
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
public interface CourseService {
	
	public CoursesModel createNewCourse(CoursesModel coursesModel);
	public CoursesModel updateCourse(CoursesModel coursesModel);
	public void deleteCourse(int course_id);
	public CoursesModel findCourseById(int course_id);
	public List<CoursesModel> findAllCourses();
	
}
