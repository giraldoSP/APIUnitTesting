package co.com.ias.apirestcleanarchitecture.domain.model.subject;

public class SubjectName {

    private final String value;

    public SubjectName(String value) {
        if(value.isEmpty()){
            throw new IllegalArgumentException("El campo name no puede estar vacío");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
