package daleespring.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("키값")
    @Column(name = "id")
    private Long id;

    @Comment("회원아이디")
    @Column(name = "member_id")
    private String memberId;

    @Comment("회원비밀번호")
    @Column(name = "member_password")
    private String memberPassword;

    @Comment("회원가입날짜")
    @Column(name = "join_date")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime joinDate;
}
