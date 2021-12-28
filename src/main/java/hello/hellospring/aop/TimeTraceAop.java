package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component // spring bean으로 등록해주기
@Aspect
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..)) && !target(hello.hellospring.SpringConfig)") //공통관심사항 적용

    //@Around("execution(* hello.hellospring..*(..))") //공통관심사항 적용
    // hello.hellospring 패키지 하위에다가 다 적용하라 라는 뜻


    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed(); // 다음 메소드로 진행
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}