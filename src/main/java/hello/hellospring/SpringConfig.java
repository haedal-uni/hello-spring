package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource; // 스프링 설정 변경 (Jdbc 리포지토리 구현)

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired // 생성자가 하나인 경우 생략해도 되지만 일단 작성함
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean // Spring bean을 등록
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

//    @Bean
//    public MemberRepository memberRepository() {
//       // return new MemoryMemberRepository();
//       // return new JdbcMemberRepository(dataSource); // 스프링 설정 변경(Jdbc 리포지토리 구현)
//       // return new JdbcTemplateMemberRepository(dataSource); // 스프링 JdbcTemplate
//        return new JpaMemberRepository(em);
//    }
}