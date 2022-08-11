package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //appConfig에 있는 설정정보를 가지고 Spring Container에 넣어서 관리해준다.
        //@Bean이라고 등록된 객체들을 모두 호출해서 spring container에 넣어준다. => 이 때 넣어진 객체를 spring bean이라고한다.
        //기존에는 직접 자바 코드로 모든것을 했다면 이제는 스프링 컨테이너에게 객체를 스프링 빈으로 등록하고 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경되었다.
        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class);// 메서드 이름으로 등록해야한다.
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        memberService.join(memberA);

        Member member = memberService.findMember(1L);

        System.out.println(member.getId() + " " + member.getName() + " " + member.getGrade());

    }
}
