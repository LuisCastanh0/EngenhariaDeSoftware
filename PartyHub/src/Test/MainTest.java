package Test;

import Entity.*;
import Control.*;
import Boundary.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria controladores e boundaries  
        UserCtl userCtl = new UserCtl();
        PropertyCtl propertyCtl = new PropertyCtl();
        ReservationCtl reservationCtl = new ReservationCtl();
        OwnerCtl ownerCtl = new OwnerCtl();

        // Cria boundaries
        UserBoundary userBoundary = new UserBoundary();
        ReservationBoundary reservationBoundary = new ReservationBoundary();
        OwnerBoundary ownerBoundary = new OwnerBoundary();
        PropertyBoundary propertyBoundary = new PropertyBoundary();

        // Popula sistema
        User user1 = new User("Fernando", "BocaDeFesta", "20", "Viadinho", "fernando@fernando");
        User user2 = new User("Maria", "4321", "21", "Feminino", "maria@maria");    
        userCtl.addUser(user1);
        userCtl.addUser(user2);

        Owner Luis = new Owner("Luis","1234", "1234-5678", "luis@gmail.com", "Masculino", "21");
        Owner Julian = new Owner("Julian","1234", "5678-1234", "julian@gmail.com", "Masculino","21");
        ownerCtl.addOwner(Luis);
        ownerCtl.addOwner(Julian);

        Property property1 = new Property("101", "Casa Luis", "Casa", "30", "150", Luis, "Casa simples no centro", "Proibido fumar", "Rua Eneas Pereira Barbante, 123");
        Property property2 = new Property("102","Salão Julian", "Salão de Festas", "80", "300", Julian, "Salão de festas perfeito para seu evento", "Proibido uso de drogas", "Av. Brigadeiro Faria Lima, 456");
        propertyCtl.addProperty(property1);
        propertyCtl.addProperty(property2);

        // Loga ou cadastra usuário ou proprietário
        User loggedInUser = null;
        Owner loggedInOwner = null;
        boolean loginSuccess = false;
        int opcao2 = 0;
        int opcao3 = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Deseja se cadastrar ou logar?");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Logar");
        int opcao = sc.nextInt();

        switch (opcao) {
            // Cadastro
            case 1:
                System.out.println("Você escolheu se cadastrar.");

                System.out.println("Deseja se cadastrar como:");
                System.out.println("1 - Usuário");
                System.out.println("2 - Proprietário");
                opcao2 = sc.nextInt();

                switch(opcao2) {
                    // Cadastro como usuário
                    case 1:
                        System.out.println("Você escolheu se cadastrar como usuário:");
                        userBoundary.register(userCtl);
                        System.out.println("\nLogue no sistema com a conta que criou");
                        loggedInUser = userBoundary.login(userCtl);
                        if (loggedInUser == null) {
                            System.out.println("Login falhou. Encerrando o programa.");
                        }
                        break;
                    // Cadastro como proprietário
                    case 2:
                        System.out.println("Você escolheu se cadastrar como proprietário");
                        ownerBoundary.register(ownerCtl);   
                        loggedInOwner = ownerBoundary.login(ownerCtl);
                        break;
                    default:
                        System.out.println("Opção inválida. Encerrando programa");
                }
                break;
            // Logar
            case 2:
                System.out.println("Você escolheu logar.");
                System.out.println("Deseja logar como:");
                System.out.println("1 - Usuário");
                System.out.println("2 - Proprietário");

                opcao3 = sc.nextInt();

                switch(opcao3) {
                    // Logar como usuário
                    case 1:
                        System.out.println("Você escolheu logar como usuário:");
                        while(!loginSuccess) {
                            loggedInUser = userBoundary.login(userCtl);
                            if(loggedInUser == null) {
                                System.out.println(". Tente novamente");
                            } else {
                                loginSuccess = true;
                            }
                        }
                        break;
                    // Logar como proprietário
                    case 2:
                        System.out.println("Você escolheu logar como proprietário:");
                        while(!loginSuccess) {
                            loggedInOwner = ownerBoundary.login(ownerCtl);
                            if(loggedInOwner == null) {
                                System.out.println(". Tente novamente");
                            } else {
                                loginSuccess = true;
                            }
                        }
                        break;
                    default: 
                        System.out.println("Opção inválida. Encerrando programa");  	
                }
                break;
            default:
                System.out.println("Opção inválida. Encerrando programa");  
        }

        String resp;
        if(opcao2 == 1 || opcao3 == 1) {
            do{
                System.out.println("O que deseja fazer?");
                System.out.println("1 - Alugar propriedade");
                System.out.println("2 - Cancelar aluguel");
                boolean exitProgram = false;
                int opcao4 = sc.nextInt();
                switch(opcao4) {
                    // Alugar propriedade
                    case 1:
                        while(!exitProgram) {
                            // Mostrar propriedades
                            propertyBoundary.showProperties(propertyCtl);

                            // Selecionar propriedade
                            Property test_property = propertyBoundary.selectProperty(propertyCtl);

                            // Fazer reserva
                            System.out.print("Deseja reservar essa propriedade? (s/n): ");
                            String answer = sc.next();
                            if (answer.equalsIgnoreCase("s")) {
                                reservationBoundary.createReservation(loggedInUser, test_property);
                            } 
                            System.out.println(loggedInUser.getReservations());

                            // Perguntar se deseja ver mais propriedades ou sair
                            System.out.print("Deseja ver mais propriedades? (s) ou sair? (n): ");
                            answer = sc.next();
                            if (answer.equalsIgnoreCase("n")) {
                                exitProgram = true;
                            }
                        }
                        break;
                    // Cancelar aluguel
                    case 2: 
                        // Mostrar as reservas do usuário
                        reservationBoundary.showReservations(loggedInUser);

                        // Solicita um id de uma das reservas para cancelar
                        System.out.print("Digite o ID da reserva que deseja cancelar: ");
                        String reservationId = sc.next();

                        // Cancelar a reserva
                        if (reservationCtl.cancelReservation(loggedInUser, reservationId)) {
                            System.out.println("Reserva cancelada com sucesso.");
                            System.out.println(" ");
                        } else {
                            System.out.println("Reserva não encontrada com o ID fornecido.");
                        }
                        // Mostrar reservas do usuário
                        reservationBoundary.showReservations(loggedInUser);
                        break;
                    default:
                        System.out.println("Opção inserida inválida");
                        break;
                }
                System.out.println("Deseja voltar ao menu? (s/n)");
                resp = sc.next();
            } while (!resp.equalsIgnoreCase("n"));
        } else if(opcao2 == 2 || opcao3 == 2) {
            do{
                System.out.println("O que deseja fazer?");
                System.out.println("1 - Cadastrar propriedade");
                System.out.println("2 - Gerenciar propriedades");
                boolean exitProgram = false;
                int opcao5 = sc.nextInt();
                switch(opcao5) {
                    // Cadastrar propriedade
                    case 1:
                        while(!exitProgram) {
                            // Cadastra propriedade
                            System.out.print("Digite o ID da propriedade: ");
                            String id = sc.next();
                            sc.nextLine(); // Consumir nova linha
                            System.out.print("Digite o nome da propriedade: ");
                            String name = sc.nextLine();
                            System.out.print("Digite o tipo da propriedade: ");
                            String type = sc.nextLine();
                            System.out.print("Digite a capacidade da propriedade: ");
                            String capacity = sc.nextLine();
                            System.out.print("Digite o valor em metros quadrados: ");
                            String squareMeters = sc.nextLine();
                            System.out.print("Digite a descrição da propriedade: ");
                            String about = sc.nextLine();
                            System.out.print("Digite as restrições da propriedade: ");
                            String rules = sc.nextLine();
                            System.out.print("Digite o endereço da propriedade: ");
                            String address = sc.nextLine();
                            
                            Property property = new Property(id, name, type, capacity, squareMeters, loggedInOwner, about, rules, address);
                            propertyCtl.addProperty(property);
                            
                            System.out.print("Deseja cadastrar mais propriedades? (s) ou sair? (n): ");
                            String answer = sc.next();
                            if (answer.equalsIgnoreCase("n")) {
                                exitProgram = true;
                            }
                        }
                        break;
                    // Gerenciar propriedades
                    case 2:
                        while(!exitProgram) {
                            System.out.println("Escolha uma opção:");
                            System.out.println("1 - Ver propriedades");
                            System.out.println("2 - Editar propriedade");
                            int opcao6 = sc.nextInt();
                            switch(opcao6) {
                                // Ver propriedades
                                case 1:
                                    propertyBoundary.showProperties(propertyCtl);
                                    break;
                                // Editar propriedade
                                case 2:
                                    System.out.print("Digite o ID da propriedade que deseja editar: ");
                                    String propertyId = sc.next();
                                    sc.nextLine(); // Consumir nova linha
                                    Property property = propertyCtl.findProperty(propertyId);
                                    if (property != null) {
                                        System.out.println("Propriedade encontrada:");
                                        System.out.println(property);
                                        propertyBoundary.updateProperty(property, sc);
                                    } else {
                                        System.out.println("Propriedade não encontrada.");
                                    }
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                            System.out.print("Deseja voltar ao menu de gerenciamento de propriedades? (s/n): ");
                            String answer = sc.next();
                            if (answer.equalsIgnoreCase("n")) {
                                exitProgram = true;
                            }
                        }
                        break;
                    default:
                        System.out.println("Opção inserida inválida");
                        break;
                }
                System.out.println("Deseja voltar ao menu? (s/n)");
                resp = sc.next();
            } while (!resp.equalsIgnoreCase("n"));
        }
        System.out.println("Obrigado por utilizar o PartyHub!");
        sc.close();
    }
}

