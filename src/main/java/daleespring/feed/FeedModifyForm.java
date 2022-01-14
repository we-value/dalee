package daleespring.feed;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter @Setter
public class FeedModifyForm {

    @NotBlank(message = "제목을 입력해주세요")
    @Size(max = 200, message = "제목은 최대 200자입니다")
    private String title;

    @Lob
    @NotBlank(message = "내용을 입력해주세요")
    @Size(max = 30000, message = "내용은 최대 30000자입니다")
    private String content;

    @NotNull(message = "상태를 선택해주세요")
    private MoodColor moodColor;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime reservationDate;
}
