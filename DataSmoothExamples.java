import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples {  
  LinkedList<PHR> PHR1 = new LinkedList<PHR>();
  LinkedList<Double> PHR1Results = new LinkedList<Double>();
  DataSmooth1 D1 = new DataSmooth1();
  
  public DataSmoothExamples() {
    // four sample PHRs
    PHR1.add(new PHR("Andy", 1.8, 55, 96));
    PHR1.add(new PHR("Jill", 2, 75, 102));
    PHR1.add(new PHR("Ming", 1.7, 60, 87));
    PHR1.add(new PHR("Sophia", 1.8, 63, 105));

    // the smoothing results on the sample PHRs
    PHR1Results.add(96.0);
    PHR1Results.add(95.0);  // average of 96, 102, 87
    PHR1Results.add(98.0);  // average of 102, 87, 105
    PHR1Results.add(105.0);
  }
  
  @Test
  public void instructorTestDS() {
    assertEquals(PHR1Results,D1.dataSmooth(PHR1));
  }  
}

//Subtasks for Problem 2 Method 1.
/*
1)create an empty list to hold the smoothed heart rates from phrs 

2)add element 0 from phs.heartRate unchanged to list

3)go through heart rates in phrs using index based for loop

4)take the values at the previous index, that index, and the index right after, and calculate their average

5)concatenate these averages into the same list

5)add last value to list which is also an original element phs.heartRate 

6)return the smoothed list

*/
