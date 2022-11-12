import java.time.LocalDateTime;


public class DailyFrequency implements Frequency {

    private final LocalDateTime startTime;

    public DailyFrequency(LocalDateTime localDateTime) {

        this.startTime = localDateTime;
    }

    @Override
    public LocalDateTime getNextTime() {
        return  startTime.plusDays(1);
    }

    @Override
    public String toString() {
        return "Тип повторямости задачи : ежедневная.";
    }
}
