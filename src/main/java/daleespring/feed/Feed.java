package daleespring.feed;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feed")
@Getter @Setter
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("키값")
    @Column(name = "feed_id")
    private Long feedId;
    @Comment("제목")
    @Column(name = "title")
    private String title;
    @Lob
    @Comment("내용")
    @Column(name = "content")
    private String content;
    @Comment("예약알림일")
    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;
    @Comment("기분색상")
    @Column(name = "mood_color")
    private FeedMoodColor moodColor;

    @Comment("작성일")
    @Column(name = "w_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime wDate;
}