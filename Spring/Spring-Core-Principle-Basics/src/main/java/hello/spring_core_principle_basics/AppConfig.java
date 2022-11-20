package hello.spring_core_principle_basics;

import hello.spring_core_principle_basics.discount.DiscountPolicy;
import hello.spring_core_principle_basics.discount.RateDiscountPolicy;
import hello.spring_core_principle_basics.member.MemberRepository;
import hello.spring_core_principle_basics.member.MemberService;
import hello.spring_core_principle_basics.member.MemberServiceImpl;
import hello.spring_core_principle_basics.member.MemoryMemberRepository;
import hello.spring_core_principle_basics.order.OrderService;
import hello.spring_core_principle_basics.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
