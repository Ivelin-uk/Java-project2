package STATISTIC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Statistic {
    public static void companyInfoFile() {
        // Создаем уникальное имя файла на основе текущего времени
        String fileName = "src/STATISTIC/FILES/" + generateFileName();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Ваш код для записи в файл
            String content = "Пример текста для записи в новый файл.";
            writer.write(content);

            System.out.println("Успешно записан в файл: " + fileName);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private static String generateFileName() {
        // Используем текущее время для формирования уникального имени файла
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        return "file_" + timestamp + ".txt";
    }
}

