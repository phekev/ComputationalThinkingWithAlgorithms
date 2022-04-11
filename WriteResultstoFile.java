package ctaProject.ComputationalThinkingWithAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class WriteResultstoFile {
	
	public static void write(List<Sort> sorts, int[] testInputSizes) {
	File outputFile = new File("C:\\Users\\pheke\\Documents\\CTA\\src\\ctaProject\\test" + System.currentTimeMillis() + ".csv");
	try (PrintWriter writer = new PrintWriter(outputFile)) {

		StringBuilder sb = new StringBuilder();
		sb.append("blank,");
		for( int i = 0; i < testInputSizes.length; i++ ) {
			sb.append(String.format("%5d", testInputSizes[i]) + ","); 	
		}
		sb.append('\n');
		
		for (int j = 0; j < sorts.size(); j++) {
			sb.append(sorts.get(j).toString());
			sb.append(',');
			for (Map.Entry<Integer,Double> sortTypes : sorts.get(j).randomSortBenchmarkResults.entrySet()){
				sb.append(String.format("%.3f", sortTypes.getValue()));
				sb.append(',');
			}
			sb.append('\n');

		}
		

		writer.write(sb.toString());

		System.out.println("\ndone!");
		
		writer.close();

	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	}
	}

}



