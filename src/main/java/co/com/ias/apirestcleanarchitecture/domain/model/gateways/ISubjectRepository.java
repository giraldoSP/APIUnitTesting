package co.com.ias.apirestcleanarchitecture.domain.model.gateways;

import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;

import java.util.List;

public interface ISubjectRepository {

    Subject saveSubject(Subject subject);

    List<Subject> getSubjects();

    Subject findSubjectById(Long id);
}
