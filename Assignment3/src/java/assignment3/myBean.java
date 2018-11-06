/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3;

import java.io.Serializable;

/**
 * @author spring
 */
public class myBean extends Object implements Serializable {

    private String name;

    public myBean() {
        
        name = new String();
    }
    //Users name is stored in the name variable.
    public String getName() {return name;}
    public void setName(String value) {name = value;}

}
