package daleespring.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void memberJoin() {
        Member member = new Member();
        member.setMemberEmail("j5539538@daum.net");
        member.setMemberPassword("1234");
        member.setMemberNickname("테스트");

        memberService.memberJoin(member);

        Member resultMember = memberRepository.findByIdMember(member);

        assertThat(member).isEqualTo(resultMember);
    }

    @Test
    public void memberJoinValidateDuplicate() {
        Member member1 = new Member();
        member1.setMemberEmail("j5539538@daum.net");
        member1.setMemberPassword("1234");
        member1.setMemberNickname("테스트");

        Member member2 = new Member();
        member2.setMemberEmail("j5539538@daum.net");
        member2.setMemberPassword("1234");
        member2.setMemberNickname("테스트");

        memberService.memberJoin(member1);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> memberService.memberJoin(member2));
        assertThat("이미 존재하는 이메일입니다.").isEqualTo(thrown.getMessage());
    }
}