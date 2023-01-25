package co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.ISubjectRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa.entity.SubjectDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SubjectRepositoryAdapter implements ISubjectRepository {

    private final ISubjectRepositoryAdapter iSubjectAdapterRepository;

    public SubjectRepositoryAdapter(ISubjectRepositoryAdapter iSubjectAdapterRepository) {
        this.iSubjectAdapterRepository = iSubjectAdapterRepository;
    }

    @Override
    public Subject saveSubject(Subject subject) {
        //Convertir en DBO
        SubjectDBO subjectDBO = SubjectDBO.fromDomain(subject);

        //convertir a Subject
        return SubjectDBO.toDomain(this.iSubjectAdapterRepository.save(subjectDBO));
    }

    @Override
    public List<Subject> getSubjects() {
        List<SubjectDBO> subjects = this.iSubjectAdapterRepository.findAll();

        return subjects.stream().map(SubjectDBO::toDomain).collect(Collectors.toList());
    }

    @Override
    public Subject findSubjectById(Long id) {
        Optional<SubjectDBO> subjectDBO = this.iSubjectAdapterRepository.findById(id);
        return subjectDBO.map(SubjectDBO::toDomain).orElse(null);
    }
}
