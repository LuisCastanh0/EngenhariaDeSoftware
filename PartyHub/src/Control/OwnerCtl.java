package Control;

import Entity.*;
import java.util.ArrayList;

public class OwnerCtl {
    // Lista de Users
    private ArrayList<Owner> Owners;

    public OwnerCtl() {
        Owners = new ArrayList<>();
    }

    public Owner findOwner(String name) {
        for (Owner owner : Owners) {
            if (owner.getName().equals(name)) {
                return owner;
            }   
        }
        return null;
    }

    public void addOwner(Owner owner) {
        Owners.add(owner);
    }

    public boolean verifyLogin(Owner owner, String password) {
        if (owner.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }


}
