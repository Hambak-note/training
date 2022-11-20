package hello.spring_core_principle_basics;

import hello.spring_core_principle_basics.member.Grade;
import hello.spring_core_principle_basics.member.Member;
import hello.spring_core_principle_basics.member.MemberService;
import hello.spring_core_principle_basics.order.Order;
import hello.spring_core_principle_basics.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
