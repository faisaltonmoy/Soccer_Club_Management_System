/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transfer;

/**
 *
 * @author faisa
 */
public class transfer_sell {
    
    private int sell_Id;
    private int p_Id;
    private String p_name;
    private String con_typ;
    private int sell_tfee;

    public transfer_sell(int sell_Id, int p_Id, String p_name, String con_typ, int sell_tfee) {
        this.sell_Id = sell_Id;
        this.p_Id = p_Id;
        this.p_name = p_name;
        this.con_typ = con_typ;
        this.sell_tfee = sell_tfee;
    }

    public int getSell_Id() {
        return sell_Id;
    }

    public int getP_Id() {
        return p_Id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getCon_typ() {
        return con_typ;
    }

    public int getSell_tfee() {
        return sell_tfee;
    }
    
    

}

