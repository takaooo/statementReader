package org.takaooo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface Marshaller {

    Iterable<Map<String,String>> readFile(File csvFile, int skipRows, List<String> headers) throws FileNotFoundException;
}
