package davacom.decagonprogram.controller;

import davacom.decagonprogram.entities.StackCourse;
import davacom.decagonprogram.service.StackCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stack-coursess")
@RequiredArgsConstructor
public class StackCourseController {
    private final StackCourseService stackCoursesService;

    @GetMapping
    public List<StackCourse> getStackCourses() {
        return stackCoursesService.getStackCourses();
    }
}
