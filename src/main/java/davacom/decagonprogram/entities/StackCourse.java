package davacom.decagonprogram.entities;

import davacom.decagonprogram.enums.STACK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StackCourse{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false,unique = true)
    private  Long stackCourseId;
    @CreationTimestamp
    private LocalDateTime createDate;
    private String tittle;
    @Enumerated(EnumType.STRING)
    private STACK stack;
    private Integer credit;

    @OneToOne(
//            mappedBy = "stackCourse"
    )
    private StackCourseMaterials stackCourseMaterials;
}



//@Id
//@SequenceGenerator(
//        name = "course_material_sequence",
//        sequenceName = "course_material_sequence",
//        allocationSize = 1
//
//)
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//@GeneratedValue(
//        strategy = GenerationType.SEQUENCE,
//        generator = "course_material_sequence"
//)