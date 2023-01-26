package co.com.ias.apirestcleanarchitecture.infrastructure.entryPoint;

import co.com.ias.apirestcleanarchitecture.domain.model.subject.dto.SubjectDTO;
import co.com.ias.apirestcleanarchitecture.domain.usecase.subject.SubjectUseCase;
import co.com.ias.apirestcleanarchitecture.infrastructure.entrypoint.subject.SubjectEntryPoint;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.File;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Java6BDDSoftAssertionsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import java.net.http.HttpClient;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(SubjectEntryPoint.class)
public class SubjectEntryPointTest {


    @MockBean
    private  SubjectUseCase subjectUseCase;



    @Autowired
    private MockMvc mockMvc;



    @Test
    @DisplayName("Save course ok")
    void saveSubjectSuccess() throws Exception {
        //Arrange
        SubjectDTO subjectDTO = new SubjectDTO(1234L, "Calculo");
        Mockito.when(subjectUseCase.saveSubject(any())).thenReturn(subjectDTO);
        ObjectMapper mapper = new ObjectMapper();

        //Act


        mockMvc.perform(post("/subject")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(subjectDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        //Assert


    }


    @Test
    @DisplayName("Status 200")
    void httpResult200() throws Exception{

       mockMvc.perform(MockMvcRequestBuilders.get("/subject")).
               andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @DisplayName("500")
    void ServerErrorTest() throws Exception {
        //Arrange




        //Act


        mockMvc.perform(MockMvcRequestBuilders.delete("/1234565"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
        //Assert


    }



}


