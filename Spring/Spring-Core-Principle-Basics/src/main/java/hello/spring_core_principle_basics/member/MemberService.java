package hello.spring_core_principle_basics.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
