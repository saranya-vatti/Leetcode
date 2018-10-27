class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int inter = (Math.min(C,  G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        if(F >= D || B >= H || E >= C || A >= G) {
            inter = 0;
        }
        return (C-A)*(D-B) + (G-E)*(H-F) - inter;
    }
}
