import java.time.LocalDateTime;

public class OneTimeFrequency implements Frequency {

    private final LocalDateTime startTime;

    public OneTimeFrequency(LocalDateTime startTime) {
        this.startTime = startTime;
    }


    @Override
    public LocalDateTime getNextTime() {
        return null;
    }

    @Override
    public String toString() {
        return "Тип повторямости задачи : однократная.";
    }
}