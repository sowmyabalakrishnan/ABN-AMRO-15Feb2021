/**
 * 
 */
package processor;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;

/**
 * @author Sowmya
 *
 */
public class FixedWidthReaderTest {

	 private FixedWidthReader reader = new FixedWidthReader();

	    @Test
	     public void test_process_Input() {
	    	MyRecord record = new MyRecord();
	        record.setClientType("CL  ".trim());
	        System.out.println(record.getClientType());		
	        record.setClientNumber(4321);
	        record.setAccountNumber(Integer.parseInt("0002".trim()));
	        record.setSubAccountNumber(Integer.parseInt("0001".trim()));
		  
		  record.setExchangeCode("FUSGX".trim());
		  record.setProductGroupCode("C ".trim());
		  record.setSymbol("NK    ".trim());
		  record.setExpirationDate("20100910");
		  
		  record.setQuantityLong(Integer.parseInt("0000000001 ".trim()));
		  record.setQuantityShort(Integer.parseInt("0000000000".trim()));
		  
		  String Client_Information = record.getClientType() + record.getClientNumber() +record.getAccountNumber() +record.getSubAccountNumber();
	      String Product_Information = record.getExchangeCode() +record.getProductGroupCode() +record.getSymbol() +record.getExpirationDate();
	      int Total_Transaction_Amount = record.getQuantityLong() - record.getQuantityShort();
	      String key = Client_Information+Product_Information;
	      String[] csvRowArr = {Client_Information, Product_Information, String.valueOf(Total_Transaction_Amount)};
	        
	      HashMap<String, String[]>  expectedProductTotalMap = new HashMap<String, String[]>();	     			  
		  expectedProductTotalMap.put(key, csvRowArr);
		  
		  HashMap<String, String[]> productTotalMap = reader.processInput(record);
		  Assert.assertEquals(expectedProductTotalMap.size(),productTotalMap.size());
		 // System.out.println("*** AssertEquals Size ---> "+expectedProductTotalMap.size()+" , "+productTotalMap.size());
		 // System.out.println("*** AssertEquals keySet ---> "+expectedProductTotalMap.keySet().equals(productTotalMap.keySet()));
		 // System.out.println("*** AssertEquals csvRowArr ---> "+csvRowArr+" , "+(productTotalMap.get(key)));
		  Assert.assertEquals(expectedProductTotalMap.keySet(), productTotalMap.keySet());
		  Assert.assertEquals(csvRowArr, productTotalMap.get(key));
		  
		 
		 
	    }
}
