package songi.lab.spring.handlerMethodArgResolver.model;

import lombok.Getter;

// 파라미터로 받을 객체
@Getter
public class FooBar {
    private final String bar;
    private final String foo;

    public FooBar(String bar, String foo) {
        this.bar = bar;
        this.foo = foo;
    }
}
