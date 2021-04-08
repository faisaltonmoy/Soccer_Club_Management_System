/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facilities;

/**
 *
 * @author Atanu saha
 */
public class G_User {
    private String gName, gTYPE, gDescription;
    private int g_Capacity,g_no ;
    //  private byte[] cImg;

    public  G_User( int g_no,String  gName, String gTYPE,int g_Capacity,String gDescription) {
        this.g_no=g_no;
        this.gName = gName;
        this.gTYPE=gTYPE;
        this.g_Capacity = g_Capacity;
        this.gDescription = gDescription;
        
    }

    public int getg_Capacity() {
        return g_Capacity;
    }

    public String getgName() {
        return gName;
    }
    
    public int getg_no() {
        return g_no;
    }
    
     public String getgTYPE() {
        return gTYPE;
    }

    public String getgDescription() {
        return gDescription;
    }

    
}
