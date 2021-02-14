/**
 * 
 */
package processor;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author Sowmya
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		long startTime = System. currentTimeMillis();
		System.out.println("*** Entered main() ***");		
		HashMap<String, String[]> productTotalMap = new HashMap<String, String[]> ();	
		
		/*** Read the input Fixed width file and calculate the total transaction amount ***/
		Path file = Paths.get("C:\\Users\\Sowmya\\Downloads\\Input.txt");		
		Charset charset = Charset.defaultCharset();		
		FixedWidthReader fixedWidthReader = new FixedWidthReader();
		productTotalMap = fixedWidthReader.readFixedWidthInputFile(file, charset);	
		
		/*** Write to output CSV file ***/
		List<String[]> csvOutputList = new ArrayList<String[]>();
		if(!(productTotalMap.isEmpty()))
	    	{
			for (Entry<String, String[]> productTotalMapEntry : productTotalMap.entrySet()) {
				String[] csvRowList =  productTotalMapEntry.getValue();					 
				csvOutputList.add((String[]) csvRowList);
			 	}					 
	        }
		CSVWriter csvWriter = new CSVWriter();
		try {
			csvWriter.writeToCsvFile(csvOutputList, new File("D:\\My_Workspaces\\Archimydes\\ABN_AMRO_Test\\src\\main\\resources\\Output.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		System.out.println("*** Exitting main() ***");
		long endTime = System.currentTimeMillis(); 
		System.out.println("Time taken " + (endTime - startTime) + "ms"); 
	}
}
