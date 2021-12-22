package daleespring.feed;

import java.sql.Clob;
import java.time.LocalDateTime;

public class Feed {
    private Long feedId;
    private String title;
    private String content;
    private LocalDateTime reservationTime;
    private Color moodColor;
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

    public Color getMoodColor() {
        return moodColor;
    }

    public void setMoodColor(Color moodColor) {
        this.moodColor = moodColor;
    }

    public LocalDateTime getwTime() {
        return wTime;
    }

    public void setwTime(LocalDateTime wTime) {
        this.wTime = wTime;
    }
}