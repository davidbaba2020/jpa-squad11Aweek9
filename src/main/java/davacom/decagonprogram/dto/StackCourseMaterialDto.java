package davacom.decagonprogram.dto;

import davacom.decagonprogram.entities.StackCourse;
import davacom.decagonprogram.enums.STACK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StackCourseMaterialDto {
    private String url;
    private String stackCourseTittle;
    private STACK stackCourseStack;
    private Integer stackCourseCredit;
}
