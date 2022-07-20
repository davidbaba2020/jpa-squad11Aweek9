package davacom.decagonprogram.service.serviceImpl;

import davacom.decagonprogram.entities.StackCourse;
import davacom.decagonprogram.repositories.StackCourseRepository;
import davacom.decagonprogram.service.StackCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StackCourseImpl implements StackCourseService {
    private final StackCourseRepository stackCourseRepository;

    @Override
    public List<StackCourse> getStackCourses() {
        return stackCourseRepository.findAll();
    }
}
