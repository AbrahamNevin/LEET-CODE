class Solution {
    public:
        vector<vector<int>> generate(int numRows) {
            vector<vector<int>> res(numRows); // Initialize result
    
            for (int i = 0; i < numRows; i++) {
                res[i].resize(i + 1, 1); // Resize row to (i+1) and fill with 1s
    
                for (int j = 1; j < i; j++) { // Compute inner elements
                    res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                }
            }
            
            return res;
        }
    };
    