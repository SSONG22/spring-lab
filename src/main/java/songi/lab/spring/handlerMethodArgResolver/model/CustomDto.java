package songi.lab.spring.handlerMethodArgResolver.model;

import lombok.Setter;

@Setter // @ModelAttribute 의 경우 반드시 setter 가 존재해야 한다.
public class CustomDto {
    private String title;
    private String contents;
}
