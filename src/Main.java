import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                showMainMenu();
                int input = Integer.parseInt(scanner.next());

                if(input == 1)
                {
                    ControllerCRUD controller = new ControllerCRUD();
                    controller.ControllerMenu();
                }

                if(input == 2)
                {
                    ControllerStatistic controllerStatistic = new ControllerStatistic();
                    controllerStatistic.ControllerMenu();
                }

                if(input == 3)
                {
                    break;
                }

                showMainMenu();
                input = Integer.parseInt(scanner.next());
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    public static void showMainMenu(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("=============== ГЛАВНО МЕНЮ  =================");
        System.out.println("==============================================");
        System.out.println("1.Оперативна обработка на компании");
        System.out.println("2.Статистика");
        System.out.println("===============================================");
        System.out.print("Въведете команда: ");
    }
}