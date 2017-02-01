package org.takaooo.utils;

import java.util.Arrays;
import java.util.List;

public enum BankType {
    HALIFAX_CREDIT(1,Arrays.asList("Date", "DateEntered", "Reference", "Description", "Amount"),true),
    AMEX(13, Arrays.asList("Date", "Description", "Category", "Amount"), false);

    private int excessRows;
    private List<String> headers;
    private boolean isCredit;

    private BankType(int excessRows, List<String> headers, boolean isCredit){
        this.excessRows = excessRows;
        this.headers = headers;
        this.isCredit = isCredit;
    }

    public int getExcessRows(){
        return excessRows;
    }

    public static BankType fromName(String name) {
        for(BankType bank : BankType.values()){
            if(bank.name().equalsIgnoreCase(name)){
                return bank;
            }
        }
        throw new IllegalArgumentException("no BankType for name " + name);
    }
}