package co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa.entity;

import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.SubjectId;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.SubjectName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subject")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SubjectDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public static Subject toDomain(SubjectDBO subjectDBO){
        return new Subject(
                new SubjectId(subjectDBO.getId()),
                new SubjectName(subjectDBO.getName())
        );
    }

    public static SubjectDBO fromDomain(Subject subject){
        return new SubjectDBO(
                subject.getId().getValue(),
                subject.getName().getValue()
        );
    }
}




