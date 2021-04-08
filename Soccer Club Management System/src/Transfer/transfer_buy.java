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
public class transfer_buy {
    
    private int buy_Id;
    private String p_name;
    private String con_typ;
    private int year;

    public transfer_buy(int buy_Id, String p_name, String con_typ, int year, int sell_tfee) {
        this.buy_Id = buy_Id;
        this.p_name = p_name;
        this.con_typ = con_typ;
        this.year = year;
        this.sell_tfee = sell_tfee;
    }
    private int sell_tfee;

    public int getBuy_Id() {
        return buy_Id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getCon_typ() {
        return con_typ;
    }

    public int getYear() {
        return year;
    }

    public int getSell_tfee() {
        return sell_tfee;
    }
    
    
}
