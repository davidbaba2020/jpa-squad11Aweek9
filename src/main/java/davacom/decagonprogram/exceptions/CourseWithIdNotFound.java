package davacom.decagonprogram.exceptions;

public class CourseWithIdNotFound extends RuntimeException {
     public CourseWithIdNotFound(String message)  {
            super(message);
        }
}
