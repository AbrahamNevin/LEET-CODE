class Solution {
    public:
        int romanToInt(string s) {
             unordered_map<char, int> romanValues = {
                {'I', 1}, {'V', 5}, {'X', 10}, 
                {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}
            };
            
            int total = 0;  // To store the result
            
            for (int i = 0; i < s.length(); i++) {
                // If the current value is less than the next value, subtract it
                if (i < s.length() - 1 && romanValues[s[i]] < romanValues[s[i + 1]]) {
                    total -= romanValues[s[i]];
                } else {
                    // Otherwise, add the current value
                    total += romanValues[s[i]];
                }
            }
            
            return total;
        }
        
    };