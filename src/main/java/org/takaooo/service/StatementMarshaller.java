package org.takaooo.service;

import jersey.repackaged.com.google.common.collect.Lists;
import org.takaooo.utils.MarshallerUtil;

import java.io.*;
import java.text.Normalizer;
import java.util.List;
import java.util.Map;

public class StatementMarshaller implements Marshaller{

    private static final String DELIMITER = ",";

    public Iterable<Map<String,String>> readFile(File csvFile, int skipRows, List<String> headers) throws FileNotFoundException {
        List<Map<String,String>> result = Lists.newArrayList();
        int rowsSkipped = 1;
        FileReader fr = new FileReader(csvFile);
        BufferedReader br = new BufferedReader(fr);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if(skipRows > rowsSkipped++){
                    continue;
                }
                List<String> data = parseLine(line);
                result.add(MarshallerUtil.Mapify(headers,data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            String normalLine = Normalizer.normalize(element, Normalizer.Form.NFD);
            result.add(normalLine.replaceAll("[^a-zA-Z0-9 ]", ""));
        }

        return result;
    }
}
