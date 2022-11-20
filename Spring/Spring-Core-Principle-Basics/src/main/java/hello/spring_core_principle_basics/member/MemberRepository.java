package hello.spring_core_principle_basics.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
