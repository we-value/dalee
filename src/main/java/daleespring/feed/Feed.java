package daleespring.feed;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feed")
@Getter @Setter
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("키값")
    private Long feedId;
    @Comment("제목")
    private String title;
    @Lob
    @Comment("내용")
    private String content;
    @Comment("예약알림일")
    private LocalDateTime reservationTime;
    @Comment("기분색상")
    private FeedMoodColor moodColor;
    @Comment("작성일")
    private LocalDateTime wTime;
}