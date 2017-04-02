
/*
 * Problem 1: The BMI Sorter

Body mass index (BMI) is a measure that attempts to quantify an individual’s tissue mass. It is commonly collected during annual checkups or clinic visits. It is defined as:
  BMI = weight / ( height * height )
A simplified BMI scale classifies a value below 18.5 as "underweight", a value at least 18.5 but under 25 as "healthy", a value at least 25 but under 30 as "overweight", and a value at least 30 as "obese".
Design a program called bmiReport that consumes a list of personal health records (defined above) and produces a report containing a list of names (not the entire records) of patients in each BMI classification category. The names within each list in the report should be in the same order as in the original list of health records (you may assume that no two people have the same name). Use the BMISummary class in the starter files for the report.

The starter files provide a concrete test case for this method.

In a comment at the bottom of the BMIExamples.java file, identify the subtasks for Problem 1. Your comment will be graded.
 */


import java.util.LinkedList;

class BMI1 {
		
  BMI1(){}
  
  public BMISummary bmiReport(LinkedList<PHR> phrs) {
	  
	  //four empty lists in which to segregate people(names) based on BMI
	  LinkedList<String> underweight = new LinkedList<String>();
	  LinkedList<String> healthy = new LinkedList<String>();
	  LinkedList<String> overweight = new LinkedList<String>();
	  LinkedList<String> obese = new LinkedList<String>();
	  
	  //element based for loop goes through all records in phrs
	  for (PHR patientRecord: phrs){
		  
		double bmi = patientRecord.weight/ (patientRecord.height * patientRecord.height);//calculation for BMI
		
		//if statements check BMI and add the name to the appropriate list 
		if (bmi < 18.5){
			underweight.add(patientRecord.name);
		}
		else if ((bmi >= 18.5)&&( bmi < 25)){
			healthy.add(patientRecord.name);
		} 
		else if ((bmi >= 25)&&( bmi < 30)){
			overweight.add(patientRecord.name);
		} 
		else {
			obese.add(patientRecord.name);
		}
	  }
	//create a instance of BMISummary which inputs these BMI lists
    return new BMISummary(underweight,healthy,overweight,obese);
  }
}