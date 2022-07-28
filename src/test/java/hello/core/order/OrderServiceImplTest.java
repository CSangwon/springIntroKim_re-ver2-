package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class OrderServiceImplTest {

    MemberRepository memberRepository = new MemoryMemberRepository();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberRepository.save(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
        assertThat(itemA.calculatePrice()).isEqualTo(9000);

    }

}