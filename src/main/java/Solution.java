public class Solution {
    String result = null;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String res = dfs(root, startValue, destValue);
        //System.out.println(result);

        return result;
    }

    String dfs(TreeNode root, int s, int d) {
        if(result != null){
            return null;
        }
        if (root == null) {
            return "-";
        }

        if (root.val == s) {
            String path1 = "L" + dfs(root.left, s, d);
            if (path1.charAt(path1.length() - 1) != '-') {
                path1 = path1.substring(0, path1.length() - 1);
                if(result == null){
                    result = path1;
                }
                return path1;
            }
            String path2 = "R" + dfs(root.right, s, d);
            if (path2.charAt(path2.length() - 1)  != '-') {
                path2 = path2.substring(0,path2.length() - 1);
                if(result == null){
                    result = path2;
                }
                return path2;
            }

            return "S";
        }
        if (root.val == d) {
            String path1 = "U" + dfs(root.left, s, d);
            if (path1.charAt(path1.length() - 1) != '-') {
                path1 = "U".repeat(path1.length() - 1);
                if(result == null){
                    result = path1;
                }
                return path1;
            }
            String path2 = "U" + dfs(root.right, s, d);
            if (path2.charAt(path2.length() - 1)  != '-') {
                path2 = "U".repeat(path2.length() - 1);
                if(result == null){
                    result = path2;
                }
                return path2;
            }

            return "D";
        }
        String left = "L" + dfs(root.left, s, d);
        String right = "R" + dfs(root.right, s, d);

        if (left.charAt(left.length() - 1) == '-') {
            return right;
        }
        if (right.charAt(right.length() - 1) == '-') {
            return left;
        }

        if(left.charAt(left.length() - 1) == 'S') {
            int len = left.length();
            StringBuilder sb = new StringBuilder();
            sb.append("U".repeat(len - 1));
            if(result == null){
                result = sb + right.substring(0, right.length() - 1);
            }
            return sb + right.substring(0, right.length() - 1);
        }
        if(right.charAt(right.length() - 1) == 'S') {
            int len = right.length();
            StringBuilder sb = new StringBuilder();
            sb.append("U".repeat(len - 1));
            if(result == null){
                result = sb + left.substring(0, left.length() - 1);
            }
            return sb + left.substring(0, left.length() - 1);
        }

        return "-";
    }
}
