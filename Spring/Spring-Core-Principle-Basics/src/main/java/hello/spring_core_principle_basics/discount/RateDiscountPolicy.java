package hello.spring_core_principle_basics.discount;

import hello.spring_core_principle_basics.member.Grade;
import hello.spring_core_principle_basics.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else{
            return 0;
        }
    }
}
