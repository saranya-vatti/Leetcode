class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nameIndex = 0, typedIndex = 0;
        while(nameIndex < name.length() && typedIndex < typed.length()) {
            if(nameIndex < name.length() && typedIndex < typed.length() && name.charAt(nameIndex) != typed.charAt(typedIndex)) return false;
            if(nameIndex < name.length()-1 && name.charAt(nameIndex) == name.charAt(nameIndex+1)) {
                while(nameIndex < name.length() && typedIndex < typed.length() && name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                    //System.out.println("1 checking "+name.charAt(nameIndex) + " at " + nameIndex + " and " + typed.charAt(typedIndex) + " at " + typedIndex);
                    typedIndex++;
                    nameIndex++;
                }
                if(nameIndex < name.length() && typedIndex < typed.length() && name.charAt(nameIndex) != typed.charAt(typedIndex) && typed.charAt(typedIndex) != name.charAt(nameIndex-1)) return false;
                nameIndex--;
                //System.out.println("3 checking "+name.charAt(nameIndex) + " at " + nameIndex + " and " + typed.charAt(typedIndex) + " at " + typedIndex);
            }
            if(nameIndex < name.length() && typedIndex < typed.length() && name.charAt(nameIndex) != typed.charAt(typedIndex) && typed.charAt(typedIndex) != name.charAt(nameIndex-1)) return false;
            while(typedIndex < typed.length() && name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                //System.out.println("2 checking "+name.charAt(nameIndex) + " and " + typed.charAt(typedIndex));
                typedIndex++;
            }
            nameIndex++;
        }
        if(nameIndex <= name.length() -1 || typedIndex <= typed.length() - 1) return false;
        return true;
    }
}
