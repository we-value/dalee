package daleespring.feed;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter @Setter
public class FeedAddForm {

    @NotEmpty(message = "제목을 입력해주세요")
    private String title;

    @Lob
    @NotEmpty(message = "내용을 입력해주세요")
    private String content;

    /*@NotEmpty(message = "상태를 입력해주세요")*/
    private MoodColor moodColor;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime reservationDate;
}
