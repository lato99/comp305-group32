import java.io.File;  // File Class
import java.io.FileNotFoundException;  // Error Handling
import java.util.Scanner; // Scanner for reading files
import java.util.Arrays;

public class LoongyNumber{
     public static void main(String []args){
     String fileName = args[0]; //This is the file name that will be provided from the command line
     int number_of_test_cases;
      try {
      //Open the input file
      File fileObj = new File(fileName);
      Scanner fileReader = new Scanner(fileObj);     
     //First line is the number of test cases
      String line = fileReader.nextLine(); 
      number_of_test_cases = Integer.parseInt(line); 
      //we need run our algorithm for every test_case, run it in a for loop since we now the loop count
      for(int test = 0; test < number_of_test_cases ; test++){
          //read the first line first, which will give the number of students(each student has 6 numbers)
           line = fileReader.nextLine();
           //get the number of students
           int number_of_students;
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
       //Create the two dimensional array to store each number of the belonging student 
       //Use double arrays for easier use
       int[][] student_and_nums = new int[number_of_students][6];       
       int temp = 0;
       for(int i = 0; i < number_of_students ; i++){
        for(int j = 0; j < 6 ; j++){
          student_and_nums[i][j] = big_arr[temp];
          temp++;
        }
       }
       //----------------------------------------
       Arrays.sort(big_arr); //sort the array to find the consecutive numbers.
        int max_length = 1; //store the max lengt, initialized to 1
        int last_found_index = -1; //keep track of the student which you got the last number from
        int current_length = 1; //at every step, keep the length, so that it can later be checked
        int check = 0;   //see if the next number is +1 before it (these are all done on the big_arr)
        for( int index = 0 ; index < big_arr.length ; index++){
              check = 0;
              if(index +1 == big_arr.length){
                break;
              } 
              else if( big_arr[index] == big_arr[index+1]){
                continue;
               }
              else if( big_arr[index] == big_arr[index+1]-1){
                 if(last_found_index != -1){
                   for(int i = 0; i < number_of_students ; i++){
                         for( int j = 0 ; j < 6; j++){
                              if( i<=last_found_index){
                                 continue; //iterate until a valid student is found
                               }
                             else if(student_and_nums[i][j] == big_arr[index]&&check!=1){ //check!=1 is for not stopping after the first student with the number is found.
                               last_found_index = i; //update the last student whose number is taken
                                check =1; //valid number
                             }
                         }
                     }
                     if(check == 1) { //if a number is found, increment the current_length.
                       current_length++; 
                     }
                     if( current_length> max_length) { //if a bigger length is found, update it
                         max_length  = current_length;}    
                 }
                 else if(last_found_index == -1){
                    current_length++;
                    //last_found_index is -1, so it is the beginning of the algorithm for this test case or it is the start of a new sequence (where the previous sequene is broken), initialize the last_found_index so that we can check whether or not we can get the number of the student, if it is a valid student, then check is set to 1, and we can increment the lenght. (This is for the further steps of the code)
                    for(int i = 0; i < number_of_students ; i++){ //update the last_found_index variable.
                         for( int j = 0 ; j < 6; j++){
                             if(student_and_nums[i][j] == big_arr[index]){
                                last_found_index = i;
                             }
                         }
                     }
                  }
                 }
                else{ //if the sequence is broken, when the next number is not +1:
                   if( current_length> max_length) { //check if the current lenght is bigger than max, if so, update current_length
                       max_length  = current_length;
                       }
                     current_length = 1;
                     last_found_index = -1;
               }
                 }
               System.out.println(max_length); //output the max_length.
           }
     //----------------------------
           //
      fileReader.close();
      } 
      catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace(); 
    }
    }
     }
