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
    public void createFileCompanyFillInfo(String id) throws Exception {

        String fileName = "src/STATISTIC/FILES/" + generateFileNameFullCompanyInfo();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            String content = companyCRUD.strCurrentCompany(id);;
            writer.write(content);

            System.out.println("Успешно записан в файл: " + fileName);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    private  String generateFileNameFullCompanyInfo() {
        // Используем текущее время для формирования уникального имени файла
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        return "Company_full_info_" + timestamp + ".txt";
    }

    public void createFileSort(String text) throws Exception {

        String fileName = "src/STATISTIC/FILES/" + generateFileSort();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write(text);
            System.out.println("Успешно записан в файл: " + fileName);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    private  String generateFileSort() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        return "Sort_" + timestamp + ".txt";
    }
}

