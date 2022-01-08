package com.springcore.discount;

import com.springcore.member.Grade;
import com.springcore.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인 가능 test")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 10% 아니면 할인 여부부 test")
    void vip_x() {
        // given
        Member member = new Member(2L, "memberVIP", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(0);   // VIP가 아니니 discount = 0

    }
}