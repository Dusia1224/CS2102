/*
 * Instructions
 * 
 * Geologists want to monitor a local mountain for potential earthquake activity. They have installed a sensor to track seismic (vibration of the earth) activity. The sensor sends measurements one at a time over the network to a computer at a research lab. The sensor inserts markers among the measurements to indicate the date of the measurement. The sequence of values coming from the sensor looks as follows:
  20151004 200 150 175 20151005 0.002 0.03 20151007 130 0.54 20151101 78 ...
The 8-digit numbers are dates (in year-month-day format). Numbers between 0 and 500 are vibration frequencies (in Hz). This example shows readings of 200, 150, and 175 on October 4th, 2015 and readings of 0.002 and 0.03 on October 5th, 2015. There are no data for October 6th (sometimes there are problems with the network, so data go missing). Assume that the data are in order by dates (so a later date never appears before an earlier one in the sequence) and that all data are from the same year. The dates will always be 8-digit numbers in the format show above (and starting with a non-0 digit).
You may also assume that every date is followed by at least one frequency (in other words, every date has at least one measurement).

Design a program dailyMaxForMonth that consumes a list of sensor data (doubles) and a month (represented by a number between 1 and 12) and produces a list of reports (maxHzReport) indicating the highest frequency reading for each day in that month. Only include entries for dates that are part of the data provided (so don’t report anything for October 6th in the example shown). Ignore data for months other than the given one. Each entry in your report should be an instance of the maxHzReport class in the starter files.

For example, given the sequence of values above and the month 10 (for October), the resulting list should be:

  [maxHzReport(20151004, 200), maxHzReport(20151005, 0.03), maxHzReport(20151007, 130)]
 * 
 */

import java.util.LinkedList;

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
 
 //method that outputs a list of MaxHzReport and takes in two inputs: a List of data (which contains a date and 1 or more frequency 
 //values)  and an integer that represents the month
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
	  
	  //list that stores the resulting MaxHzReport values
	  LinkedList<MaxHzReport> reportHighestFreq = new LinkedList<MaxHzReport>();

	  //function that serves as a dummy variable for an empty MaxHzReport
	  MaxHzReport currentReport = new MaxHzReport(0,0);
	  
	 //iterate through items in the MaxHzReport data
	  for (double item : data){
		  //check if date and determine the month
		  if (isDate(item)){
			 double amonth = extractMonth(item);
			 //check if the month from the MaxHzReport is the same as the input month 
			 if (amonth == month){
				 //set currentRepoort to contain the specified month and add it to the output list   
				 currentReport = new MaxHzReport(item, 0);
				 reportHighestFreq.add(currentReport);
			 }
		  } else {
			  // when item is a frequency check if item is greater than maxReading(holds the frequency values),
			  //then the item replaced that value
			  if (item > currentReport.maxReading) {
				  currentReport.maxReading = item;
			  }
		  }
	  }
	  return reportHighestFreq;
  }
}  

