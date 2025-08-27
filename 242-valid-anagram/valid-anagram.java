class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm1 =new HashMap<>();
         HashMap<Character, Integer> hm2 =new HashMap<>();
         for(int i=0;i<s.length();i++){
            hm1.put(s.charAt(i),hm1.getOrDefault(s.charAt(i),0)+1);
         }
         for(int i=0;i<t.length();i++){
            hm2.put(t.charAt(i),hm2.getOrDefault(t.charAt(i),0)+1);
         }

         if(hm1.equals(hm2)){
            return true;
         }
         else{
            return false;
         }
    }
}