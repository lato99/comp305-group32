# comp305-group32
//Note: Our code is LoongyNumber.java. We first started with LoongyNumberOld.java which is in comp305/305_project, but then we changed to LoongyNumber.java (because of technical difficulties )
//Sunday May 16 2021, We have came up with an efficient algorithm.
//Monday May 17 2021, We have initialized the necessary variables, imported necessary file reading classes, read the file and stored the necessary data for the algorithm.
//Tuesday May 18 2021, we wrote the code for the algorithm, that has no erros, but it does not give the desired output for the given input file(provided from the google drive)
//Wednesday May 19 2021,  We came up with another algorithm but. Here is the algorithm:
Put every number in a graph(each number of a student is considered as the vertices)
and the edge weights are always 1. There is only edge from vertex v1 to v2 if and only if v1== v2+1 && if v1 and v2 are the numbers from different students.
//Creating a new class for storing numbers, in order to link the number to the belonged student. This way every number can be connected to the student, and when finding the maximum length, it would be more optimal to find check whether the next number should be considered for the continous subsequence or not. However, this also complicates the structure implementatons.
Note: Our first git commit is the LoongyNumber.java class inside the comp305/comp305-project file. ( We did this accidentaly without knowing, but our second and further commits will be directly in the LoongyNumber.java (which is not in the comp305/comp305-project file.).


TO DO :
Find how to select which student's number if there are numbers that more than one student has. (Two or more students have the same number.) //With the algorithm we found on Wednesday May 19 2021, we believe that this problem is solved.

Find how to evaluate multidigit numbers students may provide. We can use modulo 10 to evaluate each digit and check if the previous digit is one less than the next one. Discard number if it's not.


Potential Algorithms we thought of:
1) Create a struct "Number" for each number which has 2 variables; value(value of number) and student(specifies which student the number came from). Afterwards put every number in an array and sort them in increasing order by their values. Evaluate the longest consecutive number sequence where each Number has a different student value (and therefore comes from a different student).

2) Create a 2D array and fill with students and their 6 numbers. Start from [0][0] and move forward until/if 1 is found. If found try to find 2 from the arrays excluding the one we find 1 in. Repeat process with 2-3-...-9 until max length is found. For less computations we can make it so if current_max_length > 9-(number we came up to evaluate) we return the current_max_length. For example if current_max_length=5 if we came up to 5 to evaluate we can directly return current_max_length, as a sequence which starts from 5 can max be of length 5 (56789) which doesn't change our desired outcome. Sequences starting from 6-7-8-9 are even shorter.

Downside of these two methods: Could not find how to evaluate numbers with same values that come from different students, how do we choose which student to take the number from?

3) Put every number in a tree. Every tree node stores which student the number belongs to and the tree itself is sorted by the value of the number. Take the longest consecutive  branch from the root to the end leaf to find max length. If no consecutive found recursively search left child and right child.

4)There is also a different algorithm that can be followed with arrays. That is using AugmentedNumbers class, where every number of each student can be converted to a member of this class, so that every number can be conected to the student that owns it. We did not implemented this because we could not manage to get better accuracy and efficency from the normal int implementation.

Downside: Hard to implement.

The program runtime in miliseconds: 896060856 (We obtained it with System.nanoTime() function.)
