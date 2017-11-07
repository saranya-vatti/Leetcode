class Solution {
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        char[] arr = moves.toCharArray();
        for(int i=0;i<arr.length;i++) {
            switch(arr[i]) {
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;
                case 'U':
                    x--;
                    break;
                case 'D':
                    x++;
                    break;
                default:
                    break;
            }
        }
        if(x==0 && y==0) return true;
        return false;
    }
}