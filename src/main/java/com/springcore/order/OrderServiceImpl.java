package com.springcore.order;

import com.springcore.discount.DiscountPolicy;
import com.springcore.member.Member;
import com.springcore.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();    // OrderServiceImp가 구현클래스에 의존한다.
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();      // 정책이 바뀌어 코드까지 바뀐다. DIP 위반!
                                                                                    // FixDiscountPolicy -> RateDiscountPolicy
    // 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 준다! OCP 위반!

//    private DiscountPolicy discountPolicy;      // 이렇게만 두면 nullpointerException 생기지!

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
