/**
 * 
 */
package processor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * @author Sowmya
 *
 */
public class FixedWidthReader {
	
	HashMap<String, String[]> productTotalMap = new HashMap<String, String[]> ();
	
	public HashMap<String, String[]> processInput(MyRecord record){
		String Client_Information = record.getClientType() + record.getClientNumber() +record.getAccountNumber() +record.getSubAccountNumber();
        String Product_Information = record.getExchangeCode() +record.getProductGroupCode() +record.getSymbol() +record.getExpirationDate();
        int Total_Transaction_Amount = record.getQuantityLong() - record.getQuantityShort();

        String key = Client_Information+Product_Information;
     	        
        if(!(productTotalMap.isEmpty())&&(productTotalMap.containsKey(key)))
        {
    		String[] csvRowArr = productTotalMap.get(key);
        	int oldSum = (Integer.parseInt(csvRowArr[2]));
    		int newSum = oldSum + Total_Transaction_Amount;
    		csvRowArr[2] = String.valueOf(newSum);
    		productTotalMap.replace(key, csvRowArr);
        }
    	else
    	{
    		String[] csvRowArr = {Client_Information, Product_Information, String.valueOf(Total_Transaction_Amount)};				        	
        	productTotalMap.put(key, csvRowArr);
    	}
        	      
       
        return productTotalMap;
	}

	public HashMap<String, String[]> readFixedWidthInputFile(Path file, Charset charset) {
		try {
			Files.lines(file, charset)
		    .forEach(line -> {
		    	
		        MyRecord record = new MyRecord();
		        record.setClientType(line.substring(3, 7).trim());
		        record.setClientNumber(Integer.parseInt(line.substring(7, 11).trim()));
		        record.setAccountNumber(Integer.parseInt(line.substring(11, 15).trim()));
		        record.setSubAccountNumber(Integer.parseInt(line.substring(15, 19).trim()));
		        
		        record.setExchangeCode(line.substring(27, 31).trim());
		        record.setProductGroupCode(line.substring(25, 27).trim());
		        record.setSymbol(line.substring(31, 37).trim());
		        record.setExpirationDate(line.substring(37, 45));
		        
		        record.setQuantityLong(Integer.parseInt(line.substring(52, 62)));
		        record.setQuantityShort(Integer.parseInt(line.substring(63, 73).trim()));
		        
		        productTotalMap = processInput(record);	
		       
		    });}
			 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return productTotalMap;
	
	}

}
