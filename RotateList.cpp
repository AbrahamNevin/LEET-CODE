class Solution {
    public:
        ListNode* rotateRight(ListNode* head, int k) {
            if (!head || !head->next || k == 0) return head; // Edge cases
            
            // Step 1: Find the length of the list
            ListNode* temp = head;
            int n = 1;
            while (temp->next) {
                temp = temp->next;
                n++;
            }
            
            // Step 2: Optimize k
            k = k % n;
            if (k == 0) return head; // No rotation needed
            
            // Step 3: Find the new tail (n-k)th node
            temp->next = head; // Make it circular
            int stepsToNewHead = n - k;
            ListNode* newTail = head;
            
            for (int i = 1; i < stepsToNewHead; i++) {
                newTail = newTail->next;
            }
            
            // Step 4: Break the loop and set the new head
            head = newTail->next;
            newTail->next = nullptr;
            
            return head;
        }
    };
    