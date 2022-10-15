/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;


/**
 *
 * @author valentinmorales
 */

public class User {
    
    private String name;
    private ArrayList<String> items;
    
    
    
    public User() {
    }

    public User(String name) {
        this.name = name;
        this.items = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
 
}
