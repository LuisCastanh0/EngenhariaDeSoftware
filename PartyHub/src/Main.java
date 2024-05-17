import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    // Caminho do arquivo CSV
    String csvFile = "D:/Estudos/Codes/Java/PartyHub/PartyHub/src/data/Users.csv";
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        // Leia a primeira linha do arquivo CSV
        br.readLine();
        String line = br.readLine();
        if (line != null) {
            // Divida a linha em campos usando vírgulas como delimitador
            String[] attributes = line.split(";");

            // Extrai os atributos do usuário
            String id = attributes[0];
            String name = attributes[1];
            String age = attributes[2];
            String sex = attributes[3];
            String email = attributes[4];

            // Cria um novo objeto User com os valores extraídos
            User user = new User(id, name, age, sex, email);

            // Cria objetos que vão interagir com User
            Owner Paulo = new Owner("300","Paulo","123456789","paulo@paulo","Masculino","18");
            Address endereco = new Address("Brazil","Sp","sp","perdizes","vanderlei","1392");

            Property Property = new Property("200","Luis House","House",30,400,Paulo,"Casa","nao morrer",endereco);
            
            // Faz reserva 
            user.addReservation(Property,"2022-06-01","22:00","05:00");
            
            // Mostrando que a reserva é salva em User e em Property
            user.getReservations();
            Property.getReservations();
            
            // Operação de cancelamento da reserva
            System.out.print("Enter the id: ");
            id = sc.nextLine();
            
            user.removeReservations_USER(id);

            // Mostrando que a reserva foi cancelada
            user.getReservations();
            Property.getReservations();


        
        }





    }
    catch (IOException e) {
        e.printStackTrace();
    }


    sc.close();

    }
}



