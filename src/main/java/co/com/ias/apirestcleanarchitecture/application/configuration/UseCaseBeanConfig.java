package co.com.ias.apirestcleanarchitecture.application.configuration;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.IStudentRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.gateways.ISubjectRepository;
import co.com.ias.apirestcleanarchitecture.domain.usecase.student.StudentUseCase;
import co.com.ias.apirestcleanarchitecture.domain.usecase.subject.SubjectUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {
    @Bean
    public StudentUseCase studentUseCase(IStudentRepository iStudentRepository,ISubjectRepository iSubjectRepository){
        return new StudentUseCase(iStudentRepository, iSubjectRepository);
    }

    @Bean
    public SubjectUseCase subjectUseCase(ISubjectRepository iSubjectRepository){
        return new SubjectUseCase(iSubjectRepository);
    }
}
