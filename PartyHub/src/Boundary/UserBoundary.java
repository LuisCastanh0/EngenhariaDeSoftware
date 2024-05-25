package Boundary;

import Entity.*;
import Control.*;

import java.util.Scanner;

public class UserBoundary {
    private UserCtl userCtl = new UserCtl();
    private Scanner sc = new Scanner(System.in);

    public void login() {
        System.out.println("Digite usuário: ");
        String name = sc.next();
        System.out.print("Digite a senha: ");
        String password = sc.next();

        User user = userCtl.findUser(name);
        if (user != null) {
            if (userCtl.verifyLogin(user, password)) {
                System.out.println("Login efetuado com sucesso");
            } 
            else {
                System.out.println("Senha inválida");
            }
        } 
        else {
            System.out.println("Usuário não existe");
        }
    } 

    public void register() {
        System.out.println("Digite o nome: ");
        String name = sc.next();
        System.out.print("Digite a senha: ");
        String password = sc.next();
        System.out.print("Digite a idade: ");
        String age = sc.next();
        System.out.print("Digite o sexo: ");
        String sex = sc.next();
        System.out.print("Digite o email: ");
        String email = sc.next();

        userCtl.addUser(new User(name, password, age, sex, email));
        }
        
}
