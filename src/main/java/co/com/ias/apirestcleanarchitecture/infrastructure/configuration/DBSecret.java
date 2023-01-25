package co.com.ias.apirestcleanarchitecture.infrastructure.configuration;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
public class DBSecret {

    private final String url;

    private final String driverClass;



}
