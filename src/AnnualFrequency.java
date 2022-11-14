import java.time.LocalDateTime;

public class AnnualFrequency implements Frequency{

    private final LocalDateTime startTime;

    public AnnualFrequency(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public LocalDateTime getNextTime(int year) {
        return startTime.plusYears(year);
    }

    @Override
    public String toString() {
        return "Тип повторямости задачи : ежегодная.";
    }
}
