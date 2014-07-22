#include "list_node.h"

#include <iostream>
using namespace std;

class AddTwoNumbers {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode *head = new ListNode(0);
        ListNode *tail = head;
        int carry = 0;
        int sum;
        for ( ; l1 != NULL && l2 != NULL; 
                l1 = l1->next, l2 = l2->next, tail = tail->next) {
            sum = l1->val + l2->val + carry;
            carry = sum / 10;
            if (sum >= 10) {
                sum -= 10;
            }
            tail->next = new ListNode(sum);
        }
        for ( ; l1 != NULL; l1 = l1->next, tail = tail->next) {
            sum = l1->val + carry;
            carry = sum / 10;
            if (sum >= 10) {
                sum -= 10;
            }
            tail->next = new ListNode(sum);
        }
        for ( ; l2 != NULL; l2 = l2->next, tail = tail->next) {
            sum = l2->val + carry;
            carry = sum / 10;
            if (sum >= 10) {
                sum -= 10;
            }
            tail->next = new ListNode(sum);
        }
        if (carry != 0) {
            tail->next = new ListNode(carry);
        }
        return head->next;
    }
};

int main(int argc, char *argv[]) {
    AddTwoNumbers solver;
    ListNode *l1 = new ListNode(0);
    ListNode *l2 = new ListNode(1);
    solver.addTwoNumbers(l1, l2);
    return 0;
}
