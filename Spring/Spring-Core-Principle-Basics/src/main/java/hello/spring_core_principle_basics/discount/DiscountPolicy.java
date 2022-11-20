package hello.spring_core_principle_basics.discount;


import hello.spring_core_principle_basics.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
