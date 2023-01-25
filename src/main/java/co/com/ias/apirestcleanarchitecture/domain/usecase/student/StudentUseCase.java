package co.com.ias.apirestcleanarchitecture.domain.usecase.student;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.IStudentRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.gateways.ISubjectRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.student.Student;
import co.com.ias.apirestcleanarchitecture.domain.model.student.dto.StudentDTO;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.dto.SubjectDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentUseCase {

    private final IStudentRepository iStudentRepository;
    private final ISubjectRepository iSubjectRepository;

    public StudentUseCase(IStudentRepository iStudentRepository, ISubjectRepository iSubjectRepository) {
        this.iStudentRepository = iStudentRepository;
        this.iSubjectRepository = iSubjectRepository;
    }

    public StudentDTO saveStudent(StudentDTO studentDTO){
        Subject subject = this.iSubjectRepository.findSubjectById(studentDTO.getSubjectId().longValue());
        if(subject != null){
            Student student = studentDTO.toDomain(studentDTO);
            return StudentDTO.fromDomain(this.iStudentRepository.saveStudent(student, subject));
        }
        return null;
    }

    public ArrayList<StudentDTO> getStudents(){
        List<Student> students = this.iStudentRepository.getStudents();
        return (ArrayList<StudentDTO>) students.stream().map(StudentDTO::fromDomain).collect(Collectors.toList());
    }

    public StudentDTO findStudentById(Long id){
        Student student = this.iStudentRepository.findStudentById(id);
        if(student != null){
            return StudentDTO.fromDomain(student);
        }
        return null;
    }

    public ArrayList<StudentDTO> findStudentsBySubjectId(Long id){
        List<Student> students = this.iStudentRepository.findStudentsBySubjectId(id);
        return (ArrayList<StudentDTO>) students.stream().map(StudentDTO::fromDomain).collect(Collectors.toList());
    }
}
