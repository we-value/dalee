package daleespring.feed;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Lob;
import java.time.LocalDateTime;

@Getter @Setter
public class FeedAddForm {

    private String title;

    @Lob
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime reservationDate;
    private FeedMoodColor moodColor;
}
