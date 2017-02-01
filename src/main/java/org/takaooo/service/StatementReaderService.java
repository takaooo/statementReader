package org.takaooo.service;

import org.takaooo.utils.BankType;

import java.io.File;
import java.io.FileNotFoundException;

public class StatementReaderService {

    StatementMarshaller marshaller = new StatementMarshaller();
    public void read(File inputFile, String bank) throws FileNotFoundException {
        BankType bankType = BankType.fromName(bank);
        marshaller.readFile(inputFile,bankType.getExcessRows(),bankType.getHeaders());


    }
}
