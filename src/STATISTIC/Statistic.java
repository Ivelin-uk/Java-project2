package STATISTIC;

import CRUD.CompanyCRUD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Statistic {
    CompanyCRUD companyCRUD;
    Scanner scanner;
    public Statistic() throws  Exception{
        this.companyCRUD = new CompanyCRUD();
        this.scanner = new Scanner(System.in);
    }
    public  void companyFillInfo() throws Exception {
        companyCRUD.showAllCompanies();
        System.out.println("Въведете ИД на компания: ");
        String id = scanner.nextLine();

        String fileName = "src/STATISTIC/FILES/" + generateFileName();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            String content = companyCRUD.strCurrentCompany(id);;
            writer.write(content);

            System.out.println("Успешно записан в файл: " + fileName);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private  String generateFileName() {
        // Используем текущее время для формирования уникального имени файла
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        return "file_" + timestamp + ".txt";
    }
}

