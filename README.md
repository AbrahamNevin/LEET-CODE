

LeetCode Solutions

This repository contains my solutions to various problems from LeetCode. The solutions are written in C++ and organized by problem type. Below is a list of the problems I have solved, along with a brief description of each file.


---

Files and Descriptions

AddTwoNums.cpp

Problem: Add two numbers represented by linked lists.
Solution: Implements a function to add two numbers represented as linked lists and return the sum as a new linked list.

BinaryTreePostorder.cpp

Problem: Postorder traversal of a binary tree.
Solution: Implements a recursive algorithm to traverse a binary tree in postorder.

BinaryTreePreorder.cpp

Problem: Preorder traversal of a binary tree.
Solution: Implements a recursive algorithm to traverse a binary tree in preorder.

ContainsDuplicate.cpp

Problem: Check if an array contains any duplicates.
Solution: Uses a hash set to detect duplicates efficiently.

LongestSubstring.cpp

Problem: Find the length of the longest substring without repeating characters.
Solution: Uses the sliding window technique to track the longest unique substring.

MaximumDepth.cpp

Problem: Find the maximum depth of a binary tree.
Solution: Recursively calculates the depth of the tree.

MergeSortedArray.cpp

Problem: Merge two sorted arrays.
Solution: Efficiently merges two sorted arrays into one.

RemoveDuplicateFromSortedList.cpp

Problem: Remove duplicates from a sorted linked list.
Solution: Iterates through the list and adjusts pointers to remove duplicates.

RomanToInteger.cpp

Problem: Convert a Roman numeral to an integer.
Solution: Converts Roman numerals to integers using a predefined rule set.

RotateList.cpp

Problem: Rotate a linked list by k places.
Solution: Uses two-pointer technique to rotate the list efficiently.

SearchInsertPosition.cpp

Problem: Find the position to insert a number in a sorted array.
Solution: Uses binary search to find the correct index.

TwoSum.cpp

Problem: Find two numbers in an array that sum up to a given target.
Solution: Uses a hash map for quick lookups to find the pair.

Solved multiple problems using Java 
---

Additional Problems

BalancedBinaryTree.cpp

Problem: Check if a binary tree is balanced.
Solution: Determines if the tree is height-balanced.

PascalsTriangle1.cpp

Problem: Generate the first n rows of Pascal's Triangle.
Solution: Iteratively generates rows of the triangle.

PascalsTriangle2.cpp

Problem: Generate the nth row of Pascal's Triangle.
Solution: Uses dynamic programming to calculate the row efficiently.


---

SQL Practice Problems

Here are some SQL queries I've practiced for database-related challenges:

1. Customers Who Bought All Products

SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (
    SELECT COUNT(*) FROM Product
);

2. First Year of Sales for Each Product

WITH RankedSales AS (
    SELECT *, 
           ROW_NUMBER() OVER (PARTITION BY product_id ORDER BY year) AS rn
    FROM Sales
)
SELECT product_id, year AS first_year, quantity, price
FROM RankedSales
WHERE rn = 1;

3. Average Experience per Project

SELECT 
    p.project_id, 
    ROUND(AVG(e.experience_years), 2) AS average_years
FROM Project p
JOIN Employee e 
    ON p.employee_id = e.employee_id
GROUP BY p.project_id;


---

How to Use

1. Clone the repository:



git clone https://github.com/yourusername/leetcode-solutions.git

2. Compile and run a file:



g++ AddTwoNums.cpp -o AddTwoNums
./AddTwoNums


---

Feel free to explore, use, or contribute to this repository. Update the GitHub URL to your actual profile and adapt any paths or filenames as needed. 
Happy codeing!!!!

---

