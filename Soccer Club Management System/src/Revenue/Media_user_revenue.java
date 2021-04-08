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
public class Media_user_revenue {
     private int Media_Id,REVENUE;
     private String media_type;

    public Media_user_revenue(int Media_Id, int REVENUE, String media_type) {
        this.Media_Id = Media_Id;
        this.REVENUE = REVENUE;
        this.media_type = media_type;
    }

    public int getMedia_Id() {
        return Media_Id;
    }

    public int getREVENUE() {
        return REVENUE;
    }

    public String getMedia_type() {
        return media_type;
    }
     
     

    
     
     
}
