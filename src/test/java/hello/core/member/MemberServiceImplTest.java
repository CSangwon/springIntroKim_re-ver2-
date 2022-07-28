package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(memberA);
        Member member = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(memberA);

    }



}