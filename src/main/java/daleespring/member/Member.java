package daleespring.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Comment("회원이메일")
    @Column(name = "member_email")
    private String memberEmail;

    @Comment("회원비밀번호")
    @Column(name = "member_password")
    private String memberPassword;

    @Comment("회원닉네임")
    @Column(name = "member_nickname")
    private String memberNickname;

    @Comment("회원가입날짜")
    @Column(name = "join_date")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime memberJoinDate;

    @Comment("회원수정날짜")
    @Column(name = "member_edit_date")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime memberEditDate;
}
