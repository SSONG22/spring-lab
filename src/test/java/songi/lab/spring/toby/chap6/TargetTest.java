package songi.lab.spring.toby.chap6;

import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TargetTest {

    @Test
    void methodSignaturePointcut() throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public int songi.lab.spring.toby.chap6.Target.minus(int,int)" +
                "throws java.lang.RuntimeException)");

        assertThat(pointcut.getClassFilter().matches(Target.class) &&
                pointcut.getMethodMatcher().matches(
                        Target.class.getMethod("minus", int.class, int.class), null
                )).isTrue();

        assertThat(pointcut.getClassFilter().matches(Target.class) &&
                pointcut.getMethodMatcher().matches(
                        Target.class.getMethod("plus", int.class , int.class), null
                )).isFalse(); // 메소드 매처에서 실패

        assertThat(pointcut.getClassFilter().matches(Bean.class) &&
                pointcut.getMethodMatcher().matches(
                        Target.class.getMethod("method"), null
                )).isFalse(); // 클래스 필터에서 실패
    }
}