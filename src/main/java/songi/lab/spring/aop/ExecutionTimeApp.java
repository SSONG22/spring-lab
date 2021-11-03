package songi.lab.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//    출처: https://mangkyu.tistory.com/121
@Aspect // AOP 클래스
@Component // 빈 등록
@Slf4j
public class ExecutionTimeApp {

//    @Around("@within(songi.lab.spring.aop.ExecutionTimeChecker)") // 어노테이션 일 때
    // 모든 패키지 내의 controller package에 존재하는 클래스
    @Around("execution(* *..controller.*.*(..))")
    public Object calculateExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        // 해당 클래스 처리 전의 시간
        StopWatch sw = new StopWatch();
        sw.start();

        // 해당 클래스의 메소드 실행
        Object result = pjp.proceed();

        // 해당 클래스 처리 후의 시간
        sw.stop();
        long executionTime = sw.getTotalTimeMillis();

        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        String task = className + "." + methodName;

        log.debug("[ExecutionTime] " + task + "-->" + executionTime + "(ms)");
        return result;
    }
}
