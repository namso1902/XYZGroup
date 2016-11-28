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
public class Claim {
    
    String userId;
    Date dos;
    String rationale;
    String status;
    float amount;

    public Claim(String userId, Date dos, String rationale, String status, float amount) {
        this.userId = userId;
        this.dos = dos;
        this.rationale = rationale;
        this.status = status;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public Date getDos() {
        return dos;
    }

    public String getRationale() {
        return rationale;
    }

    public String getStatus() {
        return status;
    }

    public float getAmount() {
        return amount;
    }
    
    
    
}
