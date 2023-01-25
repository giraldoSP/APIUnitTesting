package co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.IStudentRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.student.Student;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa.entity.StudentDBO;
import co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa.entity.SubjectDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryAdapter implements IStudentRepository {

    private final IStudentRepositoryAdapter iStudentAdapterRepository;

    public StudentRepositoryAdapter(IStudentRepositoryAdapter iStudentAdapterRepository) {
        this.iStudentAdapterRepository = iStudentAdapterRepository;
    }

    @Override
    public Student saveStudent(Student student, Subject subject) {
        //Convertir en DBO
        StudentDBO studentDBO = StudentDBO.fromDomain(student);
        SubjectDBO subjectDBO = SubjectDBO.fromDomain(subject);
        studentDBO.setSubject(subjectDBO);

        //Convertir en Student
        return StudentDBO.toDomain(this.iStudentAdapterRepository.save(studentDBO));
    }

    @Override
    public List<Student> getStudents() {
        List<StudentDBO> studentDBOS = this.iStudentAdapterRepository.findAll();
        return studentDBOS.stream().map(StudentDBO::toDomain).collect(Collectors.toList());
    }

    @Override
    public Student findStudentById(Long id) {
        Optional<StudentDBO> studentDBO = this.iStudentAdapterRepository.findById(id);
        return studentDBO.map(StudentDBO::toDomain).orElse(null);
    }

    @Override
    public List<Student> findStudentsBySubjectId(Long id) {
        List<StudentDBO> students = this.iStudentAdapterRepository.findStudentsBySubjectId(id);
        return students.stream().map(StudentDBO::toDomain).collect(Collectors.toList());
    }
}
