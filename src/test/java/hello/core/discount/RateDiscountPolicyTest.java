package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10퍼센트 할인")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip가 아니면 10퍼센트 할인안됨")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}