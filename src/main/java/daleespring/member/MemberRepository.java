package daleespring.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager entityManager;

    public void memberJoin(Member member){
        entityManager.persist(member);
    }

    public Member findByIdMember(Member member){
        return entityManager.find(Member.class, member.getId());
    }

    public List<Member> findByEmailMember(String memberEmail){
        return entityManager.createQuery("select m.memberEmail from Member m where m.memberEmail = :memberEmail")
                .setParameter("memberEmail", memberEmail)
                .getResultList();
    }

    public List<Member> findByNicknameMember(String memberNickname){
        return entityManager.createQuery("select m.memberNickname from Member m where m.memberNickname = :memberNickname")
                .setParameter("memberNickname", memberNickname)
                .getResultList();
    }
}
