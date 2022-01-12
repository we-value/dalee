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
    @Column(name = "id")
    private Long idd;

    @Comment("회원키값")
    @Column(name = "member_id")
    private Long memberId;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setMoodColor(MoodColor moodColor) {
        this.moodColor = moodColor;
    }

    public void editFeed(String title, String content, LocalDateTime reservationDate, MoodColor moodColor){
        this.title = title;
        this.content = content;
        this.reservationDate = reservationDate;
        this.moodColor = moodColor;
    }
}