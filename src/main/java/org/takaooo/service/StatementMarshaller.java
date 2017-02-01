package org.takaooo.service;

import jersey.repackaged.com.google.common.collect.Lists;
import org.takaooo.utils.MarshallerUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StatementMarshaller implements Marshaller{

    private static final String DELIMITER = ",";

    public Iterable<Map<String,String>> readFile(File csvFile, int skipRows, List<String> headers) throws FileNotFoundException {
        List<Map<String,String>> result = Lists.newArrayList();
        int rowsSkipped = 1;
        Scanner scanner = new Scanner(csvFile);
        while (scanner.hasNext()) {
            if(skipRows > rowsSkipped++){
                continue;
            }
            List<String> line = parseLine(scanner.nextLine());
            result.add(MarshallerUtil.Mapify(headers,line));
        }
        scanner.close();

        return result;
    }

    private static List<String> parseLine(String csvLine) {
        List<String> result = Lists.newArrayList();

        //if empty, return!
        if (csvLine == null || csvLine.isEmpty()) {
            return result;
        }

        String[] elements = csvLine.split(DELIMITER);

        for(String element : elements){
            String normalLine = Normalizer.normalize(csvLine, Normalizer.Form.NFD);
            result.add(normalLine.replaceAll("[^a-zA-Z0-9 ]", ""));
        }

        return result;
    }
}
