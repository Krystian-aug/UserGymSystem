package org.systemsilownia;

import org.systemsilownia.repository.ClientRepository;
import org.systemsilownia.repository.JDBCClientRepository;
import org.systemsilownia.repository.entity.Client;
import org.systemsilownia.service.ClientService;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private ClientService service;
    public static void main(String[] args) {
            new Main().runClient();
    }


    private void runClient() {
        final ClientRepository repository = new JDBCClientRepository();
        service = new ClientService(repository);

        try(Scanner scanner = new Scanner(System.in)) {
            boolean succesfull;
            do{
                System.out.println("1 - Login");
                System.out.println("2 - Register");
                System.out.println("3 - Exit");
                final String next = scanner.next();
                succesfull = switch (next) {
                    case "1" -> login(scanner);
                    case "2" -> register(scanner);
                    default -> true;
                }; //Ulepszony switch case
            }while(!succesfull);
            startApp(scanner);
        }
    }

    private void startApp(Scanner scanner) {
        System.out.println("Welcome to System Silownia application");
        boolean running = true;

        while(running) {
            System.out.println("1 - Add membership");
            System.out.println("2 - Remove membership");
            System.out.println("3 - Check the validity");
            System.out.println("4 - Extend your pass");
            System.out.println("5 - Add funds");
            System.out.println("6 - Withdraw funds");
            System.out.println("7 - Add your birthday - student relief");
            System.out.println("8 - Exit");
            //Dodać metody obługujące te wszystkie funkcje
            String choice = scanner.next();

            switch (choice) {
                case "1" -> {}
                case "2" -> {}
                case "3" -> {}
                case "4" -> {}
                case "5" -> {}
                case "6" -> {}
                case "7" -> {}
                default -> {}
            }
        }
    }


    private boolean login(Scanner scanner) {
        System.out.println("Please enter your email: ");
        final String fromEmail = scanner.next();
        System.out.println("Please enter your password: ");
        final String fromPassword = scanner.next();
        boolean correct;
        correct = service.login(fromEmail, fromPassword);
        return correct; //jeżeli logowanie nie powiodłow się, czyli false to pętla logowania się ponawia, jeżeli true to przechodzi do aplikacji
    }
    private boolean register(Scanner scanner) {
        System.out.println("Please enter your first name: ");
        final String fromFirstName = scanner.next();
        System.out.println("Please enter your last name: ");
        final String fromLastName = scanner.next();
        System.out.println("Please enter your email: ");
        final String fromEmail = scanner.next();
        System.out.println("Please enter your password: ");
        final String fromPassword = scanner.next();
        Client fromClient = new Client(fromFirstName, fromLastName, fromEmail, fromPassword);
        boolean correct = service.register(fromClient);
        return correct; //jeżeli pomyślnie dodano nowe konto klienta do bazy to przechodzi do apki, jeżeli nie to ponawia pętle logowania
    }

}
