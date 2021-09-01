package songi.lab.spring.aboutRequestBody.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import songi.lab.spring.aboutRequestBody.dto.RequestSetterDto;

import java.time.LocalDate;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Reference : https://jojoldu.tistory.com/407
 * */

@ExtendWith(SpringExtension.class)
@WebMvcTest(RequestDtoSetterController.class)
class RequestDtoSetterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("RequestBody 에는 setter 가 없어도 된다.")
    @Test
    public void RequestBody_setter_post() throws Exception {
        String content = objectMapper.writeValueAsString(new RequestSetterDto("ThisIsName", 777L));
        mockMvc
                .perform(post("/request/setter")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(content));
    }

    @DisplayName("RequestBody 에는 setter 가 없어도 된다. - GET")
    @Test
    public void RequestBody_setter_get() throws Exception {
        String content = objectMapper.writeValueAsString(new RequestSetterDto("ThisIsName", 1000L,  LocalDate.of(2019,2,22), RequestSetterDto.RequestType.GET));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("name", Arrays.asList("ThisIsName"));
        params.put("amount", Arrays.asList("1000"));
        params.put("date", Arrays.asList("2019-02-22"));
        params.put("requestType", Arrays.asList("GET"));

        mockMvc
                .perform(get("/request/setter")
                        .params(params)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(content));
        /**
         Get 요청은 JSON 데이터가 아닌 Query Parameter 기 때문에
         Jackson2HttpMessageConverter 를 사용하지 않는다.
         WebDataBinder 를 사용한다.
         -> 기본값으로 값을 할당하는 방법이 Java Bean 방식이기 때문에 (Java Bean 은 Setter 를 통해 값을 할당한다.)
         Setter 가 없으면 작동하지 않는다.
         -> Setter 없이 사용하려면 전체 컨트롤러에 사용할 수 도있도록 ControllerAdvice 에
         initBeanPropertyAccess 를 사용한다. (:: 값 할당을 setter 가 아닌 Field 에 직접 접근 한다)
         **/
    }
}