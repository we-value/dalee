package daleespring.feed;

import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Feed {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Comment("키값")
    private Long feedId;

    @Comment("제목")
    private String title;
    @Comment("내용")
    private String content;
    @Comment("예약알림일")
    private LocalDateTime reservationTime;
    @Comment("기분색상")
    private MoodColor moodColor;
    @Comment("작성일")
    private LocalDateTime wTime;

    public Long getFeedId() {
        return feedId;
    }

    public void setFeedId(Long feedId) {
        this.feedId = feedId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public MoodColor getMoodColor() {
        return moodColor;
    }

    public void setMoodColor(MoodColor moodColor) {
        this.moodColor = moodColor;
    }

    public LocalDateTime getwTime() {
        return wTime;
    }

    public void setwTime(LocalDateTime wTime) {
        this.wTime = wTime;
    }
}