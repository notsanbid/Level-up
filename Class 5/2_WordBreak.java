// LC : 139 (TLE)
class Solution {
    public boolean solution(String given, String sfs, HashSet<String> hs, int idx){
	    if(idx == given.length()){
	        System.out.println(sfs);
	        return true;
	    }
	    String temp = "";
	    boolean flag = false;
	    for(int i=idx; i<given.length(); i++){
	        temp = temp + given.charAt(i);
	        if(hs.contains(temp)){
	            flag = solution(given, sfs + " " + temp, hs, i+1) || flag ;
	        }
	    }
	    return flag;
	}
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for(String str : wordDict) hs.add(str);
        return solution(s, "", hs, 0);
    }
}