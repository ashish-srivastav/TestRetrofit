package com.example.ashishsrivastava.companynames;

/**
 * Created by ashish.srivastava on 12/21/2015.
 */
public class Company {



    private int CorporateId;

    public String getCorporateName() {
        return CorporateName;
    }

    public void setCorporateName(String corporateName) {
        CorporateName = corporateName;
    }

    public int getCorporateId() {
        return CorporateId;
    }

    public void setCorporateId(int corporateId) {
        CorporateId = corporateId;
    }

    private String CorporateName;

}
