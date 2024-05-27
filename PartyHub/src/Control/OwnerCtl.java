package Control;

import Entity.*;
import java.util.ArrayList;

public class OwnerCtl {
    // Lista de Users
    private ArrayList<Owner> Owners;

    // Construtor
    public OwnerCtl() {
        Owners = new ArrayList<>();
    }

    // Encontra um Owner pelo nome
    public Owner findOwner(String name) {
        for (Owner owner : Owners) {
            if (owner.getName().equals(name)) {
                return owner;
            }   
        }
        return null;
    }

    // Adiciona um Owner ao sistema
    public void addOwner(Owner owner) {
        Owners.add(owner);
    }

    // Verifica se o login é válido
    public boolean verifyLogin(Owner owner, String password) {
        if (owner.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }


}
