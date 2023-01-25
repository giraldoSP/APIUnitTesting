package co.com.ias.apirestcleanarchitecture.domain.model.student;

public class StudentPhone {

    private final String value;

    public StudentPhone(String value) {
        if(value.isEmpty()){
            throw new IllegalArgumentException("El campo Phone no puede estar vacío");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
