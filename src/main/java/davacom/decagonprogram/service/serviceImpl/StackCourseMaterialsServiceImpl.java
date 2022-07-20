package davacom.decagonprogram.service.serviceImpl;

import davacom.decagonprogram.dto.StackCourseMaterialDto;
import davacom.decagonprogram.entities.StackCourse;
import davacom.decagonprogram.entities.StackCourseMaterials;
import davacom.decagonprogram.repositories.StackCourseMaterialRepository;
import davacom.decagonprogram.repositories.StackCourseRepository;
import davacom.decagonprogram.service.StackCoursesMaterialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StackCourseMaterialsServiceImpl implements StackCoursesMaterialsService {

    private final StackCourseRepository stackCourseRepository;
    private final StackCourseMaterialRepository stackCourseMaterialRepository;


//    @Transactional
    @Override
    @Transactional
    public String createCourseMaterails(StackCourseMaterialDto stackCourseMaterialDto) {
        String msg = "";
        try {
            StackCourse stackCourse = StackCourse.builder()
                    .stack(stackCourseMaterialDto.getStackCourseStack())
                    .tittle(stackCourseMaterialDto.getStackCourseTittle())
                    .credit(stackCourseMaterialDto.getStackCourseCredit())
                    .build();
            StackCourseMaterials stackCourseMateria = new StackCourseMaterials();
            BeanUtils.copyProperties(stackCourseMaterialDto, stackCourseMateria);
            stackCourseMateria.setStackCourse(stackCourse);

//            StackCourseMaterialDto.setStackCourse(stackCourse);
//        StackCourseMaterials newCourseMaterial = StackCourseMaterials.builder()
//                .stackCourse(stackCourse)
//                .url(stackCourseMaterialDto.getUrl())
//                .build();
//        stackCourseMaterialRepository.save(newCourseMaterial);

            stackCourseMaterialRepository.save(stackCourseMateria);
            msg = "New Stack Course material created successfully";
        } catch (BeansException e) {
            throw new RuntimeException("New Stack Course was not created" + e);
        }
        return msg;
    }

    @Override
    public List<StackCourseMaterials> getAllStackCourse() {
        return stackCourseMaterialRepository.findAll();
    }
}
