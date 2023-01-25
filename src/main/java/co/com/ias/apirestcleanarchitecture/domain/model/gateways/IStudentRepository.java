package co.com.ias.apirestcleanarchitecture.domain.model.gateways;

import co.com.ias.apirestcleanarchitecture.domain.model.student.Student;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa.entity.StudentDBO;

import java.util.List;

public interface IStudentRepository {

    Student saveStudent(Student student, Subject subject);

    List<Student> getStudents();

    Student findStudentById(Long id);

    List<Student> findStudentsBySubjectId(Long id);


}
