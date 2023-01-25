package co.com.ias.apirestcleanarchitecture.domain.model.student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentEmail {

    private final String value;

    public StudentEmail(String value) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Debes enviar un email válido");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
