package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //sequence 값 하나 올려준다.
        store.put(member.getId(), member); // store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //member.getName이 파라미터로 넘어온 name과 같은지 확인
                .findAny(); // 하나 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store의 values가 Member
    }

    public void clearStore() {
        store.clear(); // 통을 비운다. (TEST용)
    }

}
