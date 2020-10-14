#include <iostream>
using namespace std;

//  Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *reverse(ListNode *l)
    {
        if (!l || !l->next)
            return l;

        ListNode *prev = NULL;
        ListNode *next = l->next;

        while (l)
        {
            l->next = prev;
            prev = l;
            l = next;
            if (l)
                next = l->next;
        }

        return prev;
    }
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode *head = NULL;
        ListNode *tail = NULL;
        int c = 0;

        while (l1 && l2)
        {
            int n = l1->val + l2->val + c;
            c = n / 10;

            if (!head)
            {
                head = new ListNode(n % 10);
                tail = head;
            }
            else
            {
                tail->next = new ListNode(n % 10);
                tail = tail->next;
            }

            l1 = l1->next;
            l2 = l2->next;
        }

        while (l1)
        {
            int n = l1->val + c;
            c = n / 10;

            if (!head)
            {
                head = new ListNode(n % 10);
                tail = head;
            }
            else
            {
                tail->next = new ListNode(n % 10);
                tail = tail->next;
            }

            l1 = l1->next;
        }

        while (l2)
        {
            int n = l2->val + c;
            c = n / 10;

            if (!head)
            {
                head = new ListNode(n % 10);
                tail = head;
            }
            else
            {
                tail->next = new ListNode(n % 10);
                tail = tail->next;
            }

            l2 = l2->next;
        }

        if (c)
        {
            tail->next = new ListNode(c);
            tail = tail->next;
        }

        if (tail)
            tail->next = NULL;

        return reverse(head);
    }
};

// SOLUTION 2 ---------------------------------------------------------------------

class Solution
{
public:
    int calLen(ListNode *l)
    {
        int len = 0;

        while (l)
        {
            l = l->next;
            len++;
        }

        return len;
    }

    pair<ListNode *, int> help(ListNode *l1, ListNode *l2, int len1, int len2)
    {
        ListNode *curr = NULL;
        int c = 0;

        if (!len1 && !len2)
        {
            return make_pair(curr, c);
        }

        if (len1 < len2)
        {
            pair<ListNode *, int> nodePair = help(l1, l2->next, len1, len2 - 1);
            int n = l2->val + nodePair.second;

            c = n / 10;
            curr = new ListNode(n % 10);
            curr->next = nodePair.first;
        }
        else if (len1 > len2)
        {
            pair<ListNode *, int> nodePair = help(l1->next, l2, len1 - 1, len2);
            int n = l1->val + nodePair.second;

            c = n / 10;
            curr = new ListNode(n % 10);
            curr->next = nodePair.first;
        }
        else
        {
            pair<ListNode *, int> nodePair = help(l1->next, l2->next, len1 - 1, len2 - 1);
            int n = l2->val + l1->val + nodePair.second;

            c = n / 10;
            curr = new ListNode(n % 10);
            curr->next = nodePair.first;
        }

        return make_pair(curr, c);
    }

    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        int len1 = calLen(l1);
        int len2 = calLen(l2);

        pair<ListNode *, int> nodePair = help(l1, l2, len1, len2);

        if (nodePair.second)
        {
            ListNode *curr = new ListNode(1);

            curr->next = nodePair.first;

            return curr;
        }

        return nodePair.first;
    }
};