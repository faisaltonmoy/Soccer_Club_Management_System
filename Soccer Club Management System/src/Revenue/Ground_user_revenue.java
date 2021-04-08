/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Revenue;

/**
 *
 * @author Atanu saha
 */
public class Ground_user_revenue {
     private int G_No,Capacity;
     private String Ground_type;

    public Ground_user_revenue(int G_No, String Ground_type,int Capacity ) {
        this.G_No = G_No;
        this.Capacity = Capacity;
        this.Ground_type = Ground_type;
    }

    public int getG_No() {
        return G_No;
    }

    public int getCapacity() {
        return Capacity;
    }

    public String getGround_type() {
        return Ground_type;
    }
     
     

 
     


     
}
