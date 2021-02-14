package processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVWriter {
	private static final String DEFAULT_SEPARATOR = ",";
	 // a standard FileWriter, CSV is a normal text file
    public void writeToCsvFile(List<String[]> csvOutputList, File file) throws IOException {
    	List<String> collect = csvOutputList.stream()
                .map(this::convertToCsvFormat)
                .collect(Collectors.toList());

        // CSV is a normal text file, need a writer
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : collect) {
                bw.write(line);
                bw.newLine();
            }
        }
    	
    }
	    public String convertToCsvFormat(final String[] line) {
	        return convertToCsvFormat(line, DEFAULT_SEPARATOR);
	    }

	    // if quote = true, all fields are enclosed in double quotes
	    public String convertToCsvFormat(
	            final String[] line,
	            final String separator) {

	        return Stream.of(line)                              // convert String[] to stream
	                .collect(Collectors.joining(separator));    // join with a separator

	    }

}
