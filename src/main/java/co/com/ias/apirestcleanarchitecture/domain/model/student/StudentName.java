package co.com.ias.apirestcleanarchitecture.domain.model.student;

public class StudentName {

    private final String value;

    public StudentName(String value) {
        if(value.isEmpty()){
            throw new IllegalArgumentException("El campo name no puede estar vacío");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
