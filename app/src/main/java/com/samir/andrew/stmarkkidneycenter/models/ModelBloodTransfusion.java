package com.samir.andrew.stmarkkidneycenter.models;

/**
 * Created by andre on 04-Aug-18.
 */

public class ModelBloodTransfusion {

    String bloodProduct;
    String causeOfTransfusion;
    String complications;
    String date;
    String id;

    public ModelBloodTransfusion() {
    }

    public String getBloodProduct() {
        return bloodProduct;
    }

    public void setBloodProduct(String bloodProduct) {
        this.bloodProduct = bloodProduct;
    }

    public String getCauseOfTransfusion() {
        return causeOfTransfusion;
    }

    public void setCauseOfTransfusion(String causeOfTransfusion) {
        this.causeOfTransfusion = causeOfTransfusion;
    }

    public String getComplications() {
        return complications;
    }

    public void setComplications(String complications) {
        this.complications = complications;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
