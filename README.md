Problem: Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.

Solution:

Intuition:
Brute force approach: 
If we pick any element in the array then this problem can be reduced to finding two elements from the remaining array so that the sum of all the three elements is zero. For finding 2 elements in an array, let us pick any element in the array and then the problem can be reduced to finding an element in the remaining array so that the sum of the two elements picked and the element found is zero.  
After we find all the triples for the element selected we can remove that element from the array and repeat the above process by picking any other element in the array. 
This does the job but the algorithm is not efficient because it exhaustively searches for all possible combinations in the solution space. 

A Better approach: Let us sort the array in ascending order. Once the array is sorted, let us pick the first element in the array and then the problem reduces to finding two elements in the remaining array so that the sum of all the three elements is zero. For solving the problem of finding two elements, let us start with first and last elements of the remaining array. If the sum of the picked, first and last elements is equal to zero then we have a triplet that is part of the solution. If the sum is less than or equal to zero then we advance from first to next element, else we advance from last element to the element before it. We check the sum again and advance further based on the sum.
After we find all the triplets for the first element, we move to the second element and repeat the process to find triplets for the second element in the remaining array after removing the first element. We repeat this for all the elements. 
Clearly this approach is better than the first because we are not searching the solution space exhaustively. For every element, we are only checking every other element only once.

Algorithm:
Let us sort the array in ascending order first. Once we have the sorted array we do the following:
for every element in the array
a.	pick the element immediately right to it as second element and the last element in the array as the third element
b.	If the sum of three elements is zero then add triplet to the output and pick the element immediately right to the second element as the new second element
c.	If the sum of three elements is less than zero then pick the element immediately right to the second element as the new second element 
d.	If second and third elements are not at the same index then goto step b else skip the loop for current element
e.	If the sum of three elements is greater than zero then pick the element immediately left to the third element as the new third element
f.	If second and third elements are not at the same index then goto step b
End for
	
Complexity Analysis:
Time complexity: O(n2). We have two loops. The outer loop runs for every element in the array and the inner loop does the same so the complexity is of the order of n2. Average case Θ(n2) and best case Ω(n2) are still the same because we are running through every element in both loops to find all triplets.

Space complexity: O(n). Algorithm needs the array of n elements. Output can be printed or written to a file immediately without storing it in memory. Everything else is constant so it can be ignored. Average case Θ(n) and best case Ω(n) are still the same because both loops stop only after going through every element.

