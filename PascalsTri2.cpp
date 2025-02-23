class Solution {
    public:
        vector<int> getRow(int rowIndex) {
            vector<int> res(rowIndex + 1, 1); // Step 1: Initialize row with 1s
    
            for (int i = 1; i < rowIndex; i++) { // Step 2: Loop for each row
                for (int j = i; j > 0; j--) { // Step 3: Update in reverse order
                    res[j] = res[j] + res[j - 1];
                }
            }
            
            return res;
        }
    };
    