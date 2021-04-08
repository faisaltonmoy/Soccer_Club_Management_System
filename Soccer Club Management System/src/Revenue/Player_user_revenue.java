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
public class Player_user_revenue {
   
    private int P_PAY_ID, BONUS,COST;

    public Player_user_revenue(int P_PAY_ID, int BONUS, int COST) {
        this.P_PAY_ID = P_PAY_ID;
        this.BONUS = BONUS;
        this.COST = COST;
    }

    public int getP_PAY_ID() {
        return P_PAY_ID;
    }

    public int getBONUS() {
        return BONUS;
    }

    public int getCOST() {
        return COST;
    }
    

  
    


    
}

