#include "base_include.h"
#include "list_node.h"

class MergeKSortedLists {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        int n = lists.size();
        if (0 == n) {
            return NULL;
        }
        for ( ; 1 < n; n = (n + 1) / 2) {
            for (int i = 0; i < n - 1; i += 2) {
                lists[i / 2] = mergeTwoLists(lists[i], lists[i + 1]);
            }
            if (1 == (n % 2)) {
                lists[n / 2] = lists[n - 1];
            }
        }
        return lists[0];
   }

private:
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2) {
        ListNode *head = new ListNode(0);
        ListNode *tail = head;
        for ( ; list1 != NULL && list2 != NULL; tail = tail->next) {
            if (list1->val < list2->val) {
                tail->next = list1;
                list1 = list1->next;
            } else {
                tail->next = list2;
                list2 = list2->next;
            }
        }
        for ( ; list1 != NULL; tail = tail->next) {
            tail->next = list1;
            list1 = list1->next;
        }
        for ( ; list2 != NULL; tail = tail->next) {
            tail->next = list2;
            list2 = list2->next;
        }
        ListNode *token = head;
        head = head->next;
        delete token;
        return head;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
