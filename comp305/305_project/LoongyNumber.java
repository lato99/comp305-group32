import java.io.File;  // File Class
import java.io.FileNotFoundException;  // Error Handling
import java.util.Scanner; // Scanner for reading files



public class LoongyNumberOld{

     public static void main(String []args){

     String fileName = args[0]; //This is the file name that will be provided from the command line

     int number_of_test_cases;
     int number_of_students;
     	try {

      //Open the input file
      File fileObj = new File(fileName);
      Scanner fileReader = new Scanner(fileObj);
     
     //First line is the number of test cases
      String line = fileReader.nextLine(); 
      number_of_test_cases = Integer.parseInt(line); 

      //we need run our algorithm for every test_case, run it in a for loop since we now the loop count
      for(int test = 0; test < number_of_test_cases ; test++){
      		//read the first line first, which will give you the number of students(each student has 6 numbers)
      		 line = fileReader.nextLine();

      		 //get the number of students
      		 number_of_students = Integer.parseInt(line); 
      
      		 //in a for loop, put every number in a big enough array, the length is number_of_students * 6
      		 int big_arr_length = number_of_students *6;
      		 int big_arr[];    //declaring array
			 big_arr = new int[big_arr_length];  // allocating memory to array

			 int big_arr_filler = 0; //store the index for filling the big_arr

			 //put the numbers in the big_arr
			 for(int current_student = 0; current_student < number_of_students; current_student++){
			 		//get the next line where the number of the student is stored
			 		line = fileReader.nextLine();
			 		
			 		//split them with " " and store them in an array to put them into the bigger array
			 		String[] numbers = line.split(" ");

			 		//transfer numbers to big_arr
			 		for(int i = 0; i< 6 ; i++){
			 			big_arr[big_arr_filler] = Integer.parseInt(numbers[i]);
			 			big_arr_filler++;
			 		}
			 }
			 

      		 //
      }
      
      fileReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

     
     }

}
