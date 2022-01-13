package daleespring.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberJoinForm {

    @NotEmpty(message = "이메일을 입력해주세요!")
    private String email;

    @NotEmpty(message = "비밀번호를 입력해주세요!")
    private String password;

    @NotEmpty(message = "비밀번호 확인을 입력해주세요!")
    private String passwordCheck;

    @NotEmpty(message = "닉네임을 입력해주세요!")
    private String nickname;

}
