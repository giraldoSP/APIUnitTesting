package co.com.ias.apirestcleanarchitecture.infrastructure.entrypoint.student;

import co.com.ias.apirestcleanarchitecture.domain.model.student.dto.StudentDTO;
import co.com.ias.apirestcleanarchitecture.domain.usecase.student.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentEntryPoint {

    private final StudentUseCase studentUseCase;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO){
        try{
            StudentDTO student = this.studentUseCase.saveStudent(studentDTO);
            if(student != null){
                return ResponseEntity.status(201).body(student);
            }
            return ResponseEntity.status(412).body("No existe materia con ese id");
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(400).body("Todos los campos son obligatorios");
        }

    }

    @GetMapping
    public ResponseEntity<?> getStudents(){
        List<StudentDTO> studentDTOS = this.studentUseCase.getStudents();
        if(studentDTOS.isEmpty()){
            return ResponseEntity.status(404).body("No hay estudiantes en la BD");
        }
        return ResponseEntity.status(200).body(studentDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Long id){
        StudentDTO studentDTO = this.studentUseCase.findStudentById(id);
        if(studentDTO != null){
            return ResponseEntity.status(200).body(studentDTO);
        }
        return ResponseEntity.status(412).body("No existe estudiante con ese Id");
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<?> findStudentsBySubjectId(@PathVariable Long id){
        List<StudentDTO> students = this.studentUseCase.findStudentsBySubjectId(id);
        if(students.isEmpty()){
            return ResponseEntity.status(404).body("No hay estudiantes registrados en esa materia");
        }
        return ResponseEntity.status(200).body(students);
    }
}
