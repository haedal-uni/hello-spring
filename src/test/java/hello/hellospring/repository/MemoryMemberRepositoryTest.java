package hello.hellospring.repository;


import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach // 메소드가 실행이 끝날 때 마다 어떤 동작을 하는 거라고 보면 된다.
    public void afterEach(){
        repository.clearStore(); //test가 실행되고 끝날 때 마다 저장소를 지운다.
        // -> 순서 상관x
    }

    @Test
    public void save() { //save 메소드 실행
       //given
        Member member = new Member();
        member.setName("spring"); // 이름 설정

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get(); //검증

        // 요즘엔 이렇게 쓴다.
        assertThat(member).isEqualTo(result);
        //assertThat(member).isEqualTo(null); //실패해보기

    }


    @Test
    public void findByName() { // 이름으로 찾기 test
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // shift + f6 눌러서 이름 한꺼번에 변경경
       Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
