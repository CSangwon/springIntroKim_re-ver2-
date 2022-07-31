package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    /*
     -> DIP 준수를 하지않았음!
     클래스 의존관계를 보면 인터페이스 뿐만아니라, 구현체에도 의존을 하고있음
     new (         ~~     ) 이부분이 변경하게 됨됨     */
    //-> 이렇게 인터페이스에만 의존할 수 있게 할 수잇음 -> 그러나 실제로 코드를 실행해보면 NPE의 문제가 생긴다! -> 누군가 대신 할인정책을 주입해주어야함!!!!!
    private DiscountPolicy discountPolicy;
    private MemberRepository memberRepository;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
