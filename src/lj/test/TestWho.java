package lj.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestWho {
	
	static String str;
	static char[] strs;
	static int length;
	static int[] mask;
	static int[] permutationCache;
	static int[] stateCache;
	
	private static int checkPermutation(int state){
		if (permutationCache[state] != -1 ){
			return permutationCache[state];
		}
		char pervious = 0;
		char current;
		int result = 1;
		for(int i = 0;i<length;++i){
			if ((mask[i] & state) ==0){
				continue;
			}
			current = strs[i];
			if (current<=pervious){
				result = 0;
				break;
			}
			pervious = current;
		}
		return permutationCache[state] = result;
	}
	private static int checkState(int state){
		if (stateCache[state]!= -1){
			return stateCache[state];
		}
		int result = 0;
		int next;
		for(int i=0;i<length;++i){
			if((mask[i] & state) == 0){
				continue;
			}
			next = state & ~mask[i];
			if (checkPermutation(next) ==0  || checkState(next) == 0){
				result = 1;
				break;
			}
		}
		return stateCache[state] = result;
	}
	public static int who(String word){
		str = word;
		strs = str.toCharArray();
		length = str.length();
		permutationCache = new int[1 << length];
		for (int i=0;i<permutationCache.length;i++){
			permutationCache[i]=-1;
		}
		stateCache = new int[1 << length];
		for (int i=0;i<stateCache.length;i++){
			stateCache[i] = -1;
		}
		mask = new int[16];
		for(int i=0;i<16;++i){
			mask[i] = 1 << i;
		}
		return checkState((1 << length) - 1);
	}

	
	public static int play(char[] source) {
		int countsOfRes = 1;
		for (int i = 0; i < source.length; i++) {
			int temp = 1;
			char tempChar=source[i];
			for (int j = i + 1; j < source.length; j++) {		
				if (tempChar < source[j]){
					tempChar=source[j];
					temp++;
					if(countsOfRes<temp){
						countsOfRes=temp;
					}
				}
			}
		}
		return (source.length-countsOfRes)%2;
	}
	
	public static boolean isAsc(String s){
		char[] c = s.toCharArray();
		for(int i=0;i<c.length - 1;i++){
			if (c[i] >= c[i+1]){
				return false;
			}
		}
		return true;
	}
	static Map<String, Integer> m = new HashMap<String, Integer>(); 
	public static int who1(String s){
		if (m.containsKey(s)){
			return m.get(s);
		}
		if(s.length() == 2){
			m.put(s, 1);
			return 1;
		}else if(s.length() == 3){
			for(int i=0;i<3;i++){
				if (isAsc(s.substring(0, i) + s.substring(i+1))){
					m.put(s, 1);
					return 1;
				}
			}
			m.put(s, 0);
			return 0;
		}else{
			int count = 0;
			for(int i=0;i<s.length();i++){
				count += 1 - who1(s.substring(0, i) + s.substring(i+1));
			}
			if(count>0){
				m.put(s, 1);
				return 1;
			}else{
				m.put(s, 0);
				return 0;
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s;
		s = "acaasjuhytsqdrf";
//		System.out.println(who(s));
		System.out.println(play(s.toCharArray()));
		System.out.println(who1(s));
	}

}
