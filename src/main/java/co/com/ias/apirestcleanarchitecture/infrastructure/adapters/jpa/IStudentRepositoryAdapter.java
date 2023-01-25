package co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa;

import co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa.entity.StudentDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepositoryAdapter extends JpaRepository<StudentDBO, Long> {

    List<StudentDBO> findStudentsBySubjectId(Long id);
}
