package org.takaooo.service;

import org.takaooo.utils.BankType;

import java.io.File;

public class StatementReaderService {

    StatementMarshaller marshaller = new StatementMarshaller();
    public void read(File inputFile, String bank) {
        BankType bankType = BankType.fromName(bank);



    }
}
