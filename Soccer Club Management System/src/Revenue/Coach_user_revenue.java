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
public class Coach_user_revenue {
      private int C_PAY_Id,BONUS,COST;

    public Coach_user_revenue(int C_PAY_Id, int BONUS, int COST) {
        this.C_PAY_Id = C_PAY_Id;
        this.BONUS = BONUS;
        this.COST = COST;
    }

    public int getC_PAY_Id() {
        return C_PAY_Id;
    }

    public int getBONUS() {
        return BONUS;
    }

    public int getCOST() {
        return COST;
    }
      
      

  
    
}
