package songi.lab.spring.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어노테이션 기반으로 AOP 적용하기(클래스 레벨, 메소드 레벨)
//출처: https://mangkyu.tistory.com/121

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ExecutionTimeChecker {
}
