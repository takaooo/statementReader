package org.takaooo.service;

import org.takaooo.utils.BankType;

import java.io.File;
import java.io.FileNotFoundException;

public class StatementReaderService {

    StatementMarshaller marshaller = new StatementMarshaller();
    public void read(File inputFile, String bank) throws FileNotFoundException {
        BankType bankType = BankType.fromName(bank);
        //add 4 rows to skip due to servlet API
        marshaller.readFile(inputFile,bankType.getExcessRows()+4,bankType.getHeaders());


    }
}
