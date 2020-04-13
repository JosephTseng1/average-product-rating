package stubs;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ProductMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	//Function that determines if a word is an integer 
  public static Boolean integerIndicator(String word) {
	  try {
		  Integer.parseInt(word);
	  } catch(NumberFormatException e) {
		  return false;
	  } catch(NullPointerException e) {
		  return false;
	  }
	  return true;
  }
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

	  String line = value.toString();
	  int count = 0;
	  int rating = 0;
	  String product_id = "";
	  Boolean result = false;

	  
	  
	  for (String word:line.split("\t")) {
		  count++;
	
		  if (count == 4) {
			  product_id = word; 
		  }
		  
		  if (count == 8) {
			  //Parse the word into int if the word is an integer
			  result = integerIndicator(word);
		  	  if (result) {
				  rating = Integer.parseInt(word);
			  }
		  }  
	  }
	  
	  if (result) {
		  //if the result indicator is true we can write it out for the mapper
		  context.write(new Text(product_id), new IntWritable(rating));
	  }
  }
}
