/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author namso1902
 */
public class Payment {
    
    String member_Id;
    String type_of_payment;
    float amonut;
    Date dop;

    public Payment(String member_Id, String type_of_payment, float amonut, Date dop) {
        this.member_Id = member_Id;
        this.type_of_payment = type_of_payment;
        this.amonut = amonut;
        this.dop = dop;
    }

    public String getMember_Id() {
        return member_Id;
    }

    public String getType_of_payment() {
        return type_of_payment;
    }

    public float getAmonut() {
        return amonut;
    }

    public Date getDop() {
        return dop;
    }
    
    
}
