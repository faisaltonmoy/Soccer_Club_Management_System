/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staffs;

/**
 *
 * @author faisa
 */
public class coach_user {

    private String cName, cForm,cTYPE, cSex, cMIssue;
    private int cAge, cRating, cId;
      private byte[] cImg;

    public coach_user(int cId, String cName, String cForm,String cTYPE, int cAge, String cSex, int cRating, String cMIssue,byte[] cImg) {
        this.cId = cId;
        this.cName = cName;
        this.cForm = cForm;
        this.cTYPE=cTYPE;
        this.cAge = cAge;
        this.cSex = cSex;
        this.cRating = cRating;
        this.cMIssue = cMIssue;
        this.cImg = cImg;
    }

    public String getcName() {
        return cName;
    }

    public String getcTYPE() {
        return cTYPE;
    }
    
     public String getcForm() {
        return cForm;
    }

    public String getcSex() {
        return cSex;
    }

    public String getcMIssue() {
        return cMIssue;
    }

    public int getcAge() {
        return cAge;
    }

    public int getcRating() {
        return cRating;
    }

    public int getcId() {
        return cId;
    }

     public byte[] getpImg() {
        return cImg;
    }
}
