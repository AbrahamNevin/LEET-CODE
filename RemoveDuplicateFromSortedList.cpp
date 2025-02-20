class Solution {
    public:
        ListNode* deleteDuplicates(ListNode* head) {
            if (!head) return nullptr; // If the list is empty, return null.
    
            ListNode* current = head;
    
            while (current->next) {
                if (current->val == current->next->val) {
                    ListNode* temp = current->next;
                    current->next = current->next->next;
                    delete temp; // Free the memory of the removed node.
                } else {
                    current = current->next; // Move to the next distinct element.
                }
            }
    
            return head;
        }
    };
    