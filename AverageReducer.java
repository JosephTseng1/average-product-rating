package stubs;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, Text> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
	  
	  int sum = 0;
	  int count= 0;
	  String statistics = "";
	  double result = 0;
	  
	  for(IntWritable value: values) {
		  sum += value.get();
		  count++;
	  }
	  
	  
	  if (count != 0) {
		  result = (double)sum/(double)count;
	  }
	  
	  statistics = "Count: " + Integer.toString(count) + "    " + "Average :" + Double.toString(result);
	  
	  context.write(key, new Text(statistics));
  }
}