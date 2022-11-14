import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private final String title;
    private final String taskDescreption;
    private final LocalDateTime localDateTime;
    private final int id;

    private final Frequency frequency;

    private final TaskRepeatability taskRepeatability;

    public Task(int id, String title, String taskDescreption, LocalDateTime localDateTime, Frequency frequency, TaskRepeatability taskRepeatability) {
        this.title = title;//исключение
        this.taskDescreption = taskDescreption;//исключение
        this.localDateTime = localDateTime;//исключение
        this.id = id;
        this.frequency = frequency;
        this.taskRepeatability = taskRepeatability;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescreption() {
        return taskDescreption;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public int getId() {
        return id;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public TaskRepeatability getTaskRepeatability() {
        return taskRepeatability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(taskDescreption, task.taskDescreption) && Objects.equals(localDateTime, task.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, taskDescreption, localDateTime, id);
    }

    @Override
    public String toString() {
        return "Задача: " + title + "\n" +
                "Описание задачи: " + taskDescreption + "\n" +
                "Время создания задачи: " + localDateTime + "\n" + frequency +"\n"+
                 "Тип задачи: " + taskRepeatability.getName();


    }
}
