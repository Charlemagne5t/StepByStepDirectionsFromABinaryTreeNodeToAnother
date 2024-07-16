public class Solution {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        String[] res = new String[2];
        dfs(root, startValue, destValue, new StringBuilder(), res);

        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(true){
            if(i < res[0].length() && j < res[1].length() && res[0].charAt(i) == res[1].charAt(j)) {
                i++;
                j++;
                continue;
            }
            while(i < res[0].length()) {
                sb.append("U");
                i++;
            }
            while(j < res[1].length()) {
                sb.append(res[1].charAt(j));
                j++;
            }
            break;
        }
        return sb.toString();
    }

    void dfs(TreeNode root, int s, int d, StringBuilder path, String[] res) {
        if(res[0] != null && res[1] != null) {
            return;
        }
        if(root == null) {
            return;
        }
        if(root.val == s) {
            res[0] = path.toString();
        }
        if(root.val == d) {
            res[1] = path.toString();
        }
        path.append("L");
        dfs(root.left, s, d, path, res);
        path.deleteCharAt(path.length() - 1);
        path.append("R");
        dfs(root.right, s, d, path, res);
        path.deleteCharAt(path.length() - 1);
    }
}
