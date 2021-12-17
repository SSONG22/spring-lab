package songi.lab.spring.toby.chap6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UppercaseHandler implements InvocationHandler {
    Object target;
    // 어떤 정류의 인터페이스를 구현한 타깃에도 적용하도록 Object 타입으로 수정
    public UppercaseHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(target, args); // 타깃으로 위임, 인터페이스의 메소드 호출에 모두 적용된다.
        if (ret instanceof String) {
            return ((String) ret).toUpperCase();
        } // 호출한 메소드의 리턴 타입이 String인 경우만 대문자 변경 기능을 적용하도록 수정
        return ret;
    }
}