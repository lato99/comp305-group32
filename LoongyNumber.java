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
          //read the first line first, which will give you the number of students(each student has 6 numbers)
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
       
      

       //Create the n arrays to store each number of the belonging student (n is the number of students)
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
       Arrays.sort(big_arr);
       for(int x  : big_arr){
        System.out.printf("%d ",x);
       }
        int max_length = 1;
        int last_found_index = -1;
        int current_length = 1;
        int check = 0;
           
        for( int index = 0 ; index < big_arr.length ; index++){
              check = 0;
              if(index +1 == big_arr.length) break;
              
              if( big_arr[index] == big_arr[index+1]){

                continue;
               }

              if( big_arr[index] == big_arr[index+1]-1){
              
                 if(last_found_index != -1){
               for(int i = 0; i < number_of_students ; i++){
                 
                         for( int j = 0 ; j < 6; j++){
                              if( i == last_found_index){
                             continue;
                         }
                             if(student_and_nums[i][j] == big_arr[index]){
                                check =1;
                    

                   }

                         }
                         

                     }
                     if(check == 1) {
                       current_length++; 
                     }
                     if( current_length> max_length) {
                         max_length  = current_length;}    
                 }
                 else if(last_found_index == -1){
                  current_length++;
                  last_found_index = index % 6;
                  max_length  = current_length;
                 }
                 //if(check == 1) {
                 //    current_length++; 
                 //}
                 }
               else{
                   if( current_length> max_length) {
                       max_length  = current_length;}
                     current_length = 1;
                     last_found_index = -1;
               }

               last_found_index = (int) index /  6;
           }


           System.out.println(max_length);

     //----------------------------

           //
      }
      
      fileReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

     
     }

}






