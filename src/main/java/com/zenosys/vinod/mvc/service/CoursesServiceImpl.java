/**
 * 
 */
package com.zenosys.vinod.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenosys.vinod.mvc.model.CoursesModel;
import com.zenosys.vinod.mvc.repository.CourseRepository;

/**
 * This class represents
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
@Service
public class CoursesServiceImpl implements CourseService {

	// private static Logger logger=LogManager.getLogger();
	// private final static String CLASS_NAME="CoursesServiceImpl";

	@Autowired
	CourseRepository courseRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zenosys.vinod.mvc.service.CourseService#createNewCourse(com.zenosys
	 * .vinod.mvc.model.CoursesModel)
	 */
	@Override
	public CoursesModel createNewCourse(CoursesModel coursesModel) {

		CoursesModel courses = courseRepository.save(coursesModel);
		if (courses != null) {
			// logger.info("CoursesServiceImpl - createNewCourse() : Created");
			return courses;
		}
		// logger.error(CLASS_NAME+" createNewCourse :Error in creation");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zenosys.vinod.mvc.service.CourseService#updateCourse(com.zenosys.
	 * vinod.mvc.model.CoursesModel)
	 */
	@Override
	public CoursesModel updateCourse(CoursesModel coursesModel) {
		CoursesModel courses = courseRepository.save(coursesModel);
		if (courses != null) {
			return courses;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zenosys.vinod.mvc.service.CourseService#deleteCourse(int)
	 */
	@Override
	public void deleteCourse(int course_id) {

		courseRepository.delete(course_id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zenosys.vinod.mvc.service.CourseService#findCourseById(int)
	 */
	@Override
	public CoursesModel findCourseById(int course_id) {

		return courseRepository.findOne(course_id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zenosys.vinod.mvc.service.CourseService#findAllCourses()
	 */
	@Override
	public List<CoursesModel> findAllCourses() {
		return courseRepository.findAll();
	}

}
