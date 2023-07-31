import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String abc = scanner.nextLine();
        try {
            int[] d = new int[abc.length()];
            d[1]=1;
        } catch (Exception ex) {
            System.out.println("Пустая строка! " + ex);
        }
    }
}
