class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int partSize = length / k;
        int extraNodes = length % k;

        ListNode[] result = new ListNode[k];
        curr = head;

        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(-1); 
            ListNode newList = dummy;          

            int currentPartSize = partSize + (extraNodes > 0 ? 1 : 0);
            extraNodes--; 

            for (int j = 0; j < currentPartSize; j++) {
                newList.next = new ListNode(curr.val);
                newList = newList.next;
                if (curr != null) {
                    curr = curr.next;
                }
            }
            
            result[i] = dummy.next;
        }

        return result;
    }
}
