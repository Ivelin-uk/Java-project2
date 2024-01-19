import CRUD.CompanyCRUD;
import CRUD.TransportCRUD;

import java.util.Scanner;
public class Controller {
    Scanner scanner = new Scanner(System.in);

    public void menu(){
        System.out.println("-------------------------------------------");
        System.out.println("---------  COMPANY MENU  ------------------");
        System.out.println("-------------------------------------------");
        System.out.println("1. Въвеждане, редактиране и изтриване на конпания");
        System.out.println("2. Въвеждане, редактиране и изтриване на клиентите на транспортната компания");
        System.out.println("3. Въвеждане, редактиране и изтриване на превозните средства, които са собственост на компанията");
        System.out.println("4. Въвеждане, редактиране и изтриване на служителите на компанията.");
        System.out.println("5. Въвеждане, на транспорт");
        System.out.println("6. Изход");
        System.out.println("-------------------------------------------");
        System.out.print("Въведете команда от 1 до 5: ");
    }
    public void ControllerMenu() throws Exception{

        while (true){
            this.menu();
            int command = Integer.parseInt(scanner.nextLine());

            if(command == 1 ){
                CompanyCRUD companyCRUD = new CompanyCRUD();
                companyCRUD.start();
            }

            if(command == 2 ){

            }

            if(command == 3 ){

            }

            if(command == 4 ){

            }

            if(command == 5 ){
                TransportCRUD transportCRUD = new TransportCRUD();
                transportCRUD.start();
            }

            if(command == 5){
                break;
            }
        }
    }
}
