package davacom.decagonprogram.repositories;


import davacom.decagonprogram.entities.StackCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackCourseRepository extends JpaRepository<StackCourse, Long> {
}
