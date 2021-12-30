package daleespring.feed;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm", timezone = "Asia/Seoul")
    private LocalDateTime reservationDate;

    @Comment("상태")
    @Column(name = "mood_color")
    @Enumerated(EnumType.STRING)
    private MoodColor moodColor;

    @Comment("작성일")
    @Column(name = "w_date")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime wDate;

    @Comment("수정일")
    @Column(name = "e_date")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime eDate;
}