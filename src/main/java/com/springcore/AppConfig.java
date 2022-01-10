package com.springcore;

import com.springcore.discount.DiscountPolicy;
import com.springcore.discount.FixDiscountPolicy;
import com.springcore.member.MemberService;
import com.springcore.member.MemberServiceImpl;
import com.springcore.member.MemoryMemberRepository;
import com.springcore.order.OrderService;
import com.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
    // 그리고 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해준다.(생성자 주입 방식)

    // 생성자 주입 방식
    // 리팩토링 중복부분 -> 메서드로 다른 구현체 만듦
    // 효과 : AppConfig을 보면 역할과 구현클래스가 한눈에 들어온다.
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}

