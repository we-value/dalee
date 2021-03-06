package daleespring.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class MemberJoinForm {

    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "올바른 이메일 주소를 입력해주세요")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요")
    private String password;

    @NotBlank(message = "비밀번호 확인을 입력해주세요")
    @Size(min = 8, max = 20, message = "비밀번호 확인은 8자 이상 20자 이하로 입력해주세요")
    private String passwordCheck;

    @NotBlank(message = "닉네임을 입력해주세요")
    @Size(min = 2, max = 20,message = "닉네임은 2자 이상 20자 이하로 입력해주세요")
    private String nickname;

}
