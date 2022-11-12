import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            taskService.createTask(scanner);
                            break;
                        case 2:
                            taskService.deleteTask(scanner);
                            break;
                        case 3:
                            taskService.taskList();
                            break;
                        case 4:
                            taskService.gettingNextDateTime(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        } catch (TaskException e) {
            throw new RuntimeException(e);
        }
    }
    private static void printMenu() {
        System.out.println("1. Добавить задачу" + "\n" + "2. Удалить задачу"
                + "\n" + "3. Получить задачу на указанный день"
                + "\n" + "4. Получения следующей даты и времени выполнения "
                + "\n" + "0. Выход");

    }
}