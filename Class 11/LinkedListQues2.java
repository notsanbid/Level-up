public class LinkedListQues2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;

        ListNode dummy = new ListNode(-1), prev = dummy, c1 = list1, c2 = list2;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;
        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }

    // Question :

    // 148
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = midNode(head), nHead = mid.next;
        mid.next = null;
        return mergeTwoLists(sortList(head), sortList(nHead));
    }

    // 23
    public ListNode mergeKLists_bruteForce(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists)
            ans = mergeTwoLists(ans, list);

        return ans;
    }

    public ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if (si >= ei)
            return si > ei ? null : lists[si];
        int mid = (si + ei) / 2;

        return mergeTwoLists(mergeKLists(lists, si, mid), mergeKLists(lists, mid + 1, ei));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        return mergeKLists(lists, 0, n - 1);
    }

    // 25
    ListNode th = null, tt = null;

    private void addFirst(ListNode node) {
        if (th == null)
            th = tt = node;
        else {
            node.next = th;
            th = node;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        int len = length(head);
        ListNode ah = null, at = null, curr = head;
        while (len >= k) {
            int tempK = k;
            while (tempK-- > 0) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }

            if (ah == null) {   
                ah = th;
                at = tt;
            } else {
                at.next = th;
                at = tt;
            }

            th = tt = null;
            len -= k;
        }
        at.next = curr;
        return ah;
    }

    // 92
    public ListNode reverseBetween(ListNode head, int n, int m) {
        if (head == null || head.next == null || n == m)
            return head;
        int idx = 1;
        ListNode prev = null, curr = head;
        while (curr != null) {
            while (curr != null && idx >= n && idx <= m) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
                idx++;
            }

            if (idx > m) {
                if (prev != null) {
                    prev.next = th;
                    tt.next = curr;
                    return head;
                } else {
                    tt.next = curr;
                    return th;
                }
            }

            idx++;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    // 817
    // This is better solution than mine
    public int numComponents(ListNode head, int[] nums) {
        if (head == null || nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums)
            set.add(ele);

        ListNode curr = head;
        int components = 0;
        while (curr != null) {
            if (set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val)))
                components++;
            curr = curr.next;
        }
        return components;
    }

    // 1171
    public ListNode removeZeroSumSublists(ListNode head) {
        return head;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 138
    public Node copyRandomList(Node head) {
        return head;
    }
}
