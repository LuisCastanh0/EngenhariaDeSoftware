package Boundary;

import Entity.*;
import Control.*;

import java.util.Scanner;
import java.util.ArrayList;

public class OwnerBoundary {
    private Scanner sc = new Scanner(System.in);

    public Owner login(OwnerCtl ownerCtl) {  	
    	System.out.print("Digite o usuário: ");
        String name = sc.nextLine();
        System.out.print("Digite a senha: ");
        String password = sc.nextLine();
        
        Owner owner = ownerCtl.findOwner(name);
        if (owner != null) {
            if (ownerCtl.verifyLogin(owner, password)) {
                System.out.println("\n\nBem vindo(a) " + owner.getName());
                return owner;
            } 
            else {
                System.out.println("Senha inválida");
                return null;
            }
        } 
        else {
            System.out.println("Usuário não existe");
            return null;
        }
    }

    public void register(OwnerCtl ownerCtl) {
        System.out.print("Digite o nome: ");
        String name = sc.nextLine();
        System.out.print("Digite a senha: ");
        String password = sc.nextLine();
        System.out.print("Digite o telefone: ");
        String phone_number = sc.nextLine();
        System.out.print("Digite a idade: ");
        String age = sc.nextLine();
        System.out.print("Digite o sexo: ");
        String sex = sc.nextLine();
        System.out.print("Digite o email: ");
        String email = sc.nextLine();
        
        ownerCtl.addOwner(new Owner(name, password, phone_number, age, sex, email));
    }

    public void showProperties(Owner owner,PropertyCtl propertyCtl) {
        ArrayList<Property> properties = propertyCtl.findPropertiesByOwner(owner);

        for (Property property : properties) {
            System.out.println(property);
        }
    } 

}
