package com.springcore;

import com.springcore.discount.FixDiscountPolicy;
import com.springcore.member.MemberService;
import com.springcore.member.MemberServiceImpl;
import com.springcore.member.MemoryMemberRepository;
import com.springcore.order.OrderService;
import com.springcore.order.OrderServiceImpl;

public class AppConfig {
    // AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
    // 그리고 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해준다.(생성자 주입 방식)

    // 생성자 주입 방식
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}

