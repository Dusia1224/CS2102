import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
  }

}

//Subtasks for Problem 3 Method 1.
/*
1)create final list to store the Dates and MaxFreqs

2) create a new MaxHzReport that holds a date and a maxReading of 0 0

3)make a element based for loop to iterate through elements of the data

For each iteration...... 

4)check if element is a date

4)If date, check if month is the desired month 

6) if desired month, enter date into new MaxHzReport

7) compare notDate elements to the maxReading. If element
 is greater, update maxReading.   

8)add this new MaxHzReport to the final list 

*/

