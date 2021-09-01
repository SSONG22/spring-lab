package songi.lab.spring.aboutRequestBody.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import songi.lab.spring.aboutRequestBody.dto.RequestSetterDto;

@Slf4j
@RestController
public class RequestDtoSetterController {
    @PostMapping("/request/setter")
    public RequestSetterDto postRequestSetter(@RequestBody RequestSetterDto requestSetterDto) {
        log.info(requestSetterDto.getName() + " : " + requestSetterDto.getAmount());
        return requestSetterDto;
    }

    @GetMapping("/request/setter")
    public RequestSetterDto getRequestSetter(RequestSetterDto requestSetterDto) {
        log.info(requestSetterDto.getName() + " : " + requestSetterDto.getAmount());

        return requestSetterDto;
    }
}
