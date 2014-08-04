#include "base_include.h"
#include "list_node.h"

class RemoveNthNodeFromEndOfList {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        ListNode *token = new ListNode(0);
        token->next = head;
        head = token;
        ListNode *slow = head;
        ListNode *fast = head;
        for (int i = 0; fast != NULL && i < n; ++i, fast = fast->next) {}
        if (NULL == fast) {
            return head;
        }
        for ( ; fast->next != NULL; slow = slow->next, fast = fast->next) {}
        token = slow->next;
        slow->next = slow->next->next;
        delete token;
        token = head;
        head = head->next;
        delete token;
        return head;
    }
};
