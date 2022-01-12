package com.springcore.discount;

import com.springcore.member.Grade;
import com.springcore.member.Member;
import org.springframework.stereotype.Component;


public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;   // 할인 1000원

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {   // VIP이어야만 할인해줌
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
