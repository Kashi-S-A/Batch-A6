package com.tyss.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.dto.CourseDTO;
import com.tyss.entity.Course;
import com.tyss.entity.User;
import com.tyss.repo.CourseRepo;
import com.tyss.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DashboardController {

	private final CourseRepo courseRepo;

	private final UserRepo userRepo;

	@GetMapping("/dashboard")
	public String dashboardPage(Model model, Principal principal, @RequestParam(required = false) String msg) {

		String email = principal.getName();

		Optional<User> opt = userRepo.findByEmail(email);

		if (opt.isEmpty()) {
			return "redirect:/login?msg=Please Login Again!!";
		}

		Integer totalCourses = courseRepo.countByUserUid(opt.get().getUid());

		model.addAttribute("totalCourses", totalCourses);

		model.addAttribute("msg", msg);
		return "dashboard";
	}

	@GetMapping("/add-course")
	public String coursePage(Model model) {
		model.addAttribute("course", new CourseDTO());
		return "add-course";
	}

	@PostMapping("/add-course")
	public String addCourse(Principal principal, CourseDTO dto) {

		String email = principal.getName();

		Optional<User> opt = userRepo.findByEmail(email);

		if (opt.isEmpty()) {
			return "redirect:/login?msg=Please Login Again!!";
		}

		User user = opt.get();

		Course course = new Course();
		course.setName(dto.getName());
		course.setDuration(dto.getDuration());

		course.setUser(user);

		courseRepo.save(course);

		return "redirect:/dashboard?msg=course added successfully!!";
	}

	@GetMapping("/view-course")
	public String viewCoursePage(Principal principal, Model model) {

		Integer uid = userRepo.findByEmail(principal.getName()).get().getUid();
		
		List<Course> courses = courseRepo.findByUserUid(uid);
		
		model.addAttribute("courses", courses);

		return "view-course";
	}

}
