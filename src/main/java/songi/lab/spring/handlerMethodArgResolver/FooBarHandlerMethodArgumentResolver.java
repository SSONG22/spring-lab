package songi.lab.spring.handlerMethodArgResolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import songi.lab.spring.handlerMethodArgResolver.model.FooBar;

public class FooBarHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    // 특정 파라미터를 지원하는지 여부를 판단하기 위한 메소드, 어떤 파라미터에 대해 작업을 수행할 것인지 정의 하는 곳
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(FooBar.class); // FooBar 클래스를 파라미터로 받는다.
    }

    // 실질적인 로직 처리하는곳 , 파라미터에 전달한 객체에 대한 조작을 자유롭게 진행한 뒤 해당 객체를 리턴한다.
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String bar = webRequest.getParameter("bar");
        String foo = webRequest.getParameter("foo");

        if (isNotSet(bar)) {
            bar = "defaultBar";
        }

        if (isNotSet("foo")) {
            foo = "defaultFoo";
        }
        return null;
    }

    private boolean isNotSet(String value) {
        return value == null;
    }
}
