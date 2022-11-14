import java.time.LocalDateTime;

public class WeeklyFrequency implements Frequency{

    private final LocalDateTime startTime;

    public WeeklyFrequency(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    @Override
    public LocalDateTime getNextTime(int weeks) {
        return startTime.plusWeeks(weeks);
    }

    @Override
    public String toString() {
        return "Тип повторямости задачи : еженедельная.";
    }
}
