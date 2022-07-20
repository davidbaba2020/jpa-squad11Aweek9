package davacom.decagonprogram.controller;


import davacom.decagonprogram.dto.StackCourseMaterialDto;
import davacom.decagonprogram.entities.StackCourseMaterials;
import davacom.decagonprogram.service.StackCoursesMaterialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stack-materials")
@RequiredArgsConstructor
public class StackCourseMaterialsController {

    private final StackCoursesMaterialsService stackCoursesService;

    @PostMapping
    public ResponseEntity<String> createStackCourseMaterial(@RequestBody StackCourseMaterialDto stackCourseMaterialDto) {
        return ResponseEntity.ok(stackCoursesService.createCourseMaterails(stackCourseMaterialDto));
    }

    @GetMapping
    public List<StackCourseMaterials> getDevs() {
        return stackCoursesService.getAllStackCourse();
    }

}
