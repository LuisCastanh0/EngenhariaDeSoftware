import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    

    // Obtém dados dos arquivos

    String csvFile_Owners = "PartyHub/src/data/Owners.csv";
    ArrayList<Owner> Owners = read_owners(csvFile_Owners);

    String csvFile_Users = "PartyHub/src/data/Users.csv";
    ArrayList<User> Users = read_users(csvFile_Users);
    
    String csvFile_Properties = "PartyHub/src/data/Properties.csv";
    ArrayList<Property> Properties = read_properties(csvFile_Properties, Owners);

   
    // Entrar com um usuário
    User user = null;

    System.out.print("Enter your username: ");
    String Username = sc.nextLine();

    System.out.print("Enter your password: ");
    String Password = sc.nextLine();

    // Verifica se o usuário existe e se a senha está correta
    for (User u : Users) {
        if (u.getName().equals(Username) && u.getPassword().equals(Password)) {
            user = u;
            break;
        }
    }

    if (user != null) {
        System.out.println("Login efetuado com sucesso. Bem-vindo, " + user.getName() + "!\n");
    } else {
        System.out.println("Usuário ou senha inválidos. Tente novamente.\n");
        }

    // Menu com opções do usuário
    while (true) {
        System.out.println("Selecione uma opção:");
        System.out.println("1. Ver todas as propriedades");
        System.out.println("2. Ver minhas as reservas");

        int option = sc.nextInt();
        sc.nextLine();
        if (option == 1) {
            see_properties(Properties,sc,user);


        } else if (option == 2) {
            user.getReservations();
        } else {
            break;
        }


    }
    sc.close();

}	

    public static void see_properties(ArrayList<Property> Properties,Scanner sc,User user) {
        System.out.println("NOSSAS PROPRIEDADES: ");
        for (Property property : Properties) {
                System.out.println(property);
            }   
            System.out.println("Para ver mais sobre uma propriedade, digite o ID dela: "); 

            String id_property = sc.nextLine();
            
            Property temp_property = null;
            // Encontra a propriedade correspondente na lista de propriedades
            for (Property property : Properties) {
                if (property.getId().equals(id_property)) {
                    temp_property = property;
                    property.showProperty();
                    break;
                }
            }

            // Deseja alugar?
            System.out.println("Deseja alugar esta propriedade? (S/N)"); 
            // Se sim, chamar a função addReservation
            if (sc.nextLine().toUpperCase().equals("S")) {
                System.out.println("Insira a data da reserva: ");
                String date = sc.nextLine();

                System.out.println("Insira a hora de entrada: ");
                String check_in = sc.nextLine();

                System.out.println("Insira a hora de saida: ");
                String check_out = sc.nextLine();
                
                user.addReservation(temp_property,date,check_in,check_out);
            }
            // Se não, voltar para a lista de propriedades
            else{ 
                System.out.println("Deseja voltar para a lista de propriedades? (S/N)");
                if (sc.nextLine().toUpperCase().equals("S")) {
                    see_properties(Properties,sc,user);
                }
            }

    }

    public static ArrayList<User> read_users (String csvFile_Users) {
        ArrayList<User> Users = new ArrayList<User>();

        // Lê Users do arquivo CSV e armazena na lista Users
        try (BufferedReader br_user = new BufferedReader(new FileReader(csvFile_Users))) {
            // Leia a primeira linha do arquivo CSV (Cabeçalho)
            br_user.readLine();
                
            // Laço para ler todas as linhas do arquivo csv
            for (int i = 0; i < 10; i++) {
                String line_user = br_user.readLine();
                if (line_user != null) {
                    String[] attributes_user = line_user.split(";");

                    // Extrai os atributos do usuário
                    String id_user = attributes_user[0];
                    String name_user = attributes_user[1];
                    String password_user = attributes_user[2];
                    String age_user = attributes_user[3];
                    String sex_user = attributes_user[4];
                    String email_user = attributes_user[5];

                    // Cria um novo objeto User com os valores extraídos
                    User user = new User(id_user, name_user,password_user, age_user, sex_user, email_user);

                    Users.add(user);
                }
            }   
        } catch (IOException e) {
            e.printStackTrace();
            }
            return Users;
        }

    public static ArrayList<Owner> read_owners (String csvFile_Owners) {
        ArrayList<Owner> Owners = new ArrayList<Owner>();
        // Lê Owners do arquivo CSV e armazena na lista Owners
        try (BufferedReader br_owner = new BufferedReader(new FileReader(csvFile_Owners))) {
            // Leia a primeira linha do arquivo CSV (Cabeçalho)
            br_owner.readLine();
        
            // Laço para ler todas as linhas do arquivo csv
            for (int i = 0; i < 10; i++) {
                String line_owner = br_owner.readLine();
                if (line_owner != null) {
                    String[] attributes_owner = line_owner.split(";");

                    // Extrai os atributos do usuário
                    String id_owner = attributes_owner[0];
                    String name_owner = attributes_owner[1];
                    String phone_number_owner = attributes_owner[2];
                    String email_owner = attributes_owner[3];
                    String sex_owner = attributes_owner[4];
                    String age_owner= attributes_owner[5];

                    // Cria um novo objeto User com os valores extraídos
                    Owner owner = new Owner(id_owner, name_owner, phone_number_owner, email_owner, sex_owner, age_owner);

                    Owners.add(owner);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Owners;
    }

    public static ArrayList<Property> read_properties (String csvFile_Properties, ArrayList<Owner> Owners) { 
        ArrayList<Property> Properties = new ArrayList<Property>();
        // Lê Propriedades do arquivo CSV e armazena na lista Properties
        try (BufferedReader br_property = new BufferedReader(new FileReader(csvFile_Properties))) {
            // Leia a primeira linha do arquivo CSV (Cabeçalho)
            br_property.readLine();
            
            // Laço para ler todas as linhas do arquivo csv
            for (int i = 0; i < 10; i++) {
                String line_property = br_property.readLine();
                if (line_property != null) {
                    String[] attributes_property = line_property.split(";");

                    // Extrai os atributos da propriedade
                    String id_property = attributes_property[0];
                    String name_property = attributes_property[1];
                    String type_property = attributes_property[2];
                    String capacity_property = attributes_property[3];
                    String square_meters_property = attributes_property[4];
                    String owner_property = attributes_property[5];
                    String about_property = attributes_property[6];
                    String rules_property = attributes_property[7];
                    String address1_property = attributes_property[8];
                    String address2_property = attributes_property[9];
                    String address3_property = attributes_property[10];
                    String address4_property = attributes_property[11];
                    String address5_property = attributes_property[12];
                    String address6_property = attributes_property[13];

                    Address address = new Address(address1_property,address2_property, address3_property, address4_property, address5_property, address6_property);
                    
                    // Encontra Owner correspondente na lista Owners
                    Owner owner = null;
                    for (Owner o : Owners) {
                        if (o.getId().equals(owner_property)) {
                            owner = o;
                            break;
                        }
                    }

                    // Cria um novo objeto Property com os valores extraídos
                    Property property = new Property(id_property, name_property, type_property, capacity_property, square_meters_property, owner, about_property, rules_property, address);

                    Properties.add(property);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            }
        return Properties;
    }

}
