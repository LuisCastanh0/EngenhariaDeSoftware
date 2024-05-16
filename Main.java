import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
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


            Owner Paulo = new Owner("300","Paulo","123456789","paulo@paulo","Masculino","18");
            Address endereco = new Address("Brazil","Sp","sp","perdizes","vanderlei","1392");

            Property Property = new Property("200","Luis House","House",30,400,Paulo,"Casa","nao morrer",endereco);
            // Doing Reservation
            user.addReservation(Property,"2022-06-01","22:00","05:00");
            user.getReservations();
            System.out.println("AAAAAAAAAAAAAAA");
            Property.getReservations();
            
        
        
        }





    }
    catch (IOException e) {
        e.printStackTrace();
    }
    }
}



