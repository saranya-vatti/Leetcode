class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] aArr = a.split("\\+");
        String[] bArr = b.split("\\+");
        int aReal = Integer.parseInt(aArr[0]);
        int bReal = Integer.parseInt(bArr[0]);
        int aComplex = Integer.parseInt(aArr[1].split("i")[0]);
        int bComplex = Integer.parseInt(bArr[1].split("i")[0]);
        int resReal = (aReal * bReal) - (aComplex * bComplex);
        int resComplex = (aComplex * bReal) + (aReal * bComplex);
        return resReal + "+" + resComplex + "i";
    }
}