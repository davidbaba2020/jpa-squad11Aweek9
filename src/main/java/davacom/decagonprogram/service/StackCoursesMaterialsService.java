package davacom.decagonprogram.service;

import davacom.decagonprogram.dto.StackCourseMaterialDto;
import davacom.decagonprogram.entities.StackCourseMaterials;

import java.util.List;

public interface StackCoursesMaterialsService {
    String createCourseMaterails (StackCourseMaterialDto StackCourseMaterialDto);
    List<StackCourseMaterials> getAllStackCourse();
}
