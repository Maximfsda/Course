import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class TaskService {

    private static Map<Integer, Task> taskList = new HashMap<>();
    private int idCounter = 0;


    public Map<Integer, Task> getTaskList() {
        return taskList;
    }


    public void createTask(Scanner scanner) throws TaskException {
        idCounter++;
        LocalDateTime date = LocalDateTime.now();
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        if(taskName.isBlank()){
            throw new TaskException("Нельзя оставлять поле пустым!");
        }
        System.out.print("Введите описание задачи: ");
        String taskDescreption = scanner.next();
        if(taskDescreption.isBlank()){
            throw new TaskException("Нельзя оставлять поле пустым!");
        }
        System.out.print("Введите повторяемость задачи:\n" +
                "- однократная\n" +
                "- ежедневная\n" +
                "- еженедельная\n" +
                "- ежемесячная\n" +
                "- ежегодная\n");
        String repeatabilityTask = scanner.next();
        if(repeatabilityTask.isBlank()){
            throw new TaskException("Нельзя оставлять поле пустым!");
        }
        Frequency frequency = null;
        switch (repeatabilityTask) {
            case "однократная":
                frequency = new OneTimeFrequency(date);
                break;
            case "ежедневная":
                frequency = new DailyFrequency(date);
                break;
            case "еженедельная":
                frequency = new WeeklyFrequency(date);
                break;
            case "ежемесячная":
                frequency = new MonthlyFrequency(date);
                break;
            case "ежегодная":
                frequency = new AnnualFrequency(date);
                break;
        }
        System.out.print("Введите тип задачи: "+"\n"+"-Личная"+"\n"+"-Рабочая"+"\n");
        String taskTipe = scanner.next();
        if(taskTipe.isBlank()){
            throw new TaskException("Нельзя оставлять поле пустым!");
        }
        TaskRepeatability taskRepeatability= null;
        switch (taskTipe) {
            case "Личная":
                taskRepeatability = TaskRepeatability.valueOf("PERSONALTASK");
                break;
            case "Рабочая":
                taskRepeatability = TaskRepeatability.valueOf("WORKINGTASK");
                break;
        }
        Task task = new Task(idCounter,taskName,taskDescreption,date,frequency,taskRepeatability);
        taskList.put(idCounter,task);
    }
    public void gettingNextDateTime(Scanner scanner){
        int id = scanner.nextInt();
        System.out.print("Cледующей даты и времени выполнения."+ getTaskList().get(id).getFrequency().getNextTime() + "\n");
    }



    public void deleteTask(Scanner scanner) {
        System.out.print("Введите id задачи которую хотите удалить: ");
        int taskId = scanner.nextInt();//исключение
        taskList.remove(taskId);
        System.out.print("Задача id успешно удалена!" + "\n");
    }
    public void taskList() {
       for(Map.Entry<Integer, Task> item : taskList.entrySet()){
           System.out.printf("Id:%d" + "\n" + "%s \n", item.getKey(), item.getValue());
       }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskService that = (TaskService) o;
        return idCounter == that.idCounter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCounter);
    }
}
