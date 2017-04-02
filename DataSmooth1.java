
/*
 * 
 * Problem 2: Data Smoothing

In data analysis, smoothing a data set means approximating it to capture important patterns in the data while eliding noise or other fine-scale structures and phenomena. One simple smoothing technique is to replace each (internal) element of a sequence of values with the average of that element and its predecessor and successor. Assuming that extreme outlier values are an abberation caused, perhaps, through poor measurement, this averaging process replaces them with a more plausible value in the context of that sequence.
For example, consider this sequence of heartRate values taken from a list of personal health records (defined above):

  95 102 98 88 105
The resulting smoothed sequence should be
  95.0 98.33333 96.0 97.0 105.0
where:
102 was substituted by 98.33333: (95 + 102 + 98) / 3
98 was substituted by 96: (102 + 98 + 88) / 3
88 was substituted by 97: (98 + 88 + 105) / 3
 * 
 * Design a program dataSmooth that consumes a list of PHRs and produces a list of the smoothed heartRate values (not the entire records).
 * 
 */


import java.util.LinkedList;

class DataSmooth1 {
  DataSmooth1(){}
  
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
   //empty list for storing the smoothed data
	  LinkedList<Double> heartRateList = new LinkedList<Double>(); 
   
   //adds the heartRate at first index to the smoothed list
   heartRateList.add((double)phrs.get(0).heartRate);
   
   //index based for loop gets three elements from the phrs.heartRates and takes their average, adds resulting value to smoothed list
   for (int i = 1; i < phrs.size() - 1; i++ ){
	  heartRateList.add((phrs.get(i - 1).heartRate + phrs.get(i).heartRate +phrs.get(i + 1).heartRate)/3.0);
	  }
   //adds the heartRate at last index to the smoothed list
   heartRateList.add((double)phrs.get(phrs.size() - 1).heartRate);
	  
    return heartRateList;
  }
}