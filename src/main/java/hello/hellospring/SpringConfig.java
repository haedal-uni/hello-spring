package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource; // 스프링 설정 변경 (Jdbc 리포지토리 구현)

@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean // Spring bean을 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository() {
       // return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource); // 스프링 설정 변경(Jdbc 리포지토리 구현)
       // return new JdbcTemplateMemberRepository(dataSource); // 스프링 JdbcTemplate
        return new JpaMemberRepository(em);
    }
}