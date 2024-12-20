import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        boolean odd = false;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        

        while(!q.isEmpty()) {
            int size = q.size();
            Deque<TreeNode> level = new ArrayDeque<>();
            Deque<Integer> values = new ArrayDeque<>();
            for(int i = 0; i < size; i++) {
                if(odd) {
                    TreeNode cur = q.poll();
                    level.offer(cur);
                    values.push(cur.val);
                    if(cur.left != null){
                        q.offer(cur.left);
                        q.offer(cur.right);
                    }
                    
                }else {
                    TreeNode cur = q.poll();
                     if(cur.left != null){
                        q.offer(cur.left);
                        q.offer(cur.right);
                    }
                }
            }
            if(odd){
                while(!level.isEmpty()) {
                    level.poll().val = values.pop();
                }
            }
            odd = !odd;
        }

        return root;
    }
}