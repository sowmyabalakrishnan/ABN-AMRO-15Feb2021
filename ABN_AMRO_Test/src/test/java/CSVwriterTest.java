package processor;

/**
 * 
 */


import org.junit.Assert;
import org.junit.Test;

import processor.CSVWriter;

/**
 * @author Sowmya
 *
 */
public class CSVwriterTest {
	 private CSVWriter writer = new CSVWriter();

	    @Test
	     public void test_convert_csv_format() {
	        String[] record = {"Client Information", "Product Information", "Total Transaction amount"};
	        String expected = "Client Information,Product Information,Total Transaction amount";

	        String result = writer.convertToCsvFormat(record);
	        System.out.println("*** Test Result ---> "+result);
	        Assert.assertEquals(expected, result);
	    }

}
