package daleespring.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void memberJoin(Member member){
        //validateDuplicateMember(member.getMemberEmail());
        memberRepository.memberJoin(member);
    }

    private void validateDuplicateMember(String memberEmail){
        List<Member> memberList = memberRepository.findByEmailMember(memberEmail);
        if(!memberList.isEmpty()){
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }

}
