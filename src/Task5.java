import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        try {
            makeRecord();
            System.out.println("Файл записан!");
        }catch (FileSystemException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void makeRecord() throws Exception {
        System.out.println("Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy),\n номер телефона (число без разделителей) и пол(символ латиницей f или m), разделенные пробелом");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] array = text.split(" ");
        if (array.length != 6) {
            throw new Exception("Введено неверное количество параметров");
        }

        String surname = array[0];
        String name = array[1];
        String lastname = array[2];

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date birthdate;
        try {
            birthdate = format.parse(array[3]);
        }
        catch (ParseException e) {
            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }

        int phone;
        try {
            phone = Integer.parseInt(array[4]);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат телефона");
        }

        String sex = array[5];
        if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")) {
            throw new RuntimeException("Неверно введен пол");
        }

        String fileName = "1.txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (file.length() > 0) {
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, lastname, format.format(birthdate), phone, sex));
        }
        catch (IOException e) {
            throw new FileSystemException("Ошибка при работе с файлом");
        }
    }
}


