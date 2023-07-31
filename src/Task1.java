import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float abc;
        while (true) {
            try {
                System.out.println("Ведите дробное число - ");
                abc = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception exception) {
                System.out.println("Ошибка! " + exception);
            }
        }
        System.out.println(abc);
    }
}