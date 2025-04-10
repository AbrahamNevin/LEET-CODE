class Solution {
public:
    int myAtoi(string s) {
        int i = 0, n = s.length();
        long result = 0;
        int sign = 1;

        // Step 1: Skip leading whitespace
        while (i < n && s[i] == ' ') {
            i++;
        }

        // Step 2: Check for optional '+' or '-' sign
        if (i < n && (s[i] == '+' || s[i] == '-')) {
            sign = (s[i] == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Read digits and build the number
        while (i < n && isdigit(s[i])) {
            int digit = s[i] - '0';

            // Step 4: Handle overflow/underflow
            if (result > (INT_MAX - digit) / 10) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }
};
