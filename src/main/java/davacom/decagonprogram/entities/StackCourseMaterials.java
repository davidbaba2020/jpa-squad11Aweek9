package davacom.decagonprogram.entities;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@ToString(exclude = "course")
public class StackCourseMaterials{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private  Long stackCourseMaterialid;
    @CreationTimestamp
    private LocalDateTime createDate;
    private String url;
    @OneToOne(
            cascade = CascadeType.ALL
//            fetch = FetchType.LAZY
//            fetch = FetchType.LAZY
    )
    @JoinColumn(
                    name = "stack_course_id",
                    referencedColumnName = "stackCourseId"
            )
    private StackCourse stackCourse;

}
