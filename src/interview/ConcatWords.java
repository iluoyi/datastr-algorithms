package interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ConcatWords {
    public static void main(String args[]) throws Exception {
    	HashMap<Integer, String> index2Word = new HashMap<Integer, String>();
    	HashMap<String, Frequency> word2Freq = new HashMap<String, Frequency>();
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] ss = line.split(" ");
        int wordSize = ss.length;
       
        line = br.readLine();
        String w = line;
        
        int len = ss[0].length();
        ArrayList<Integer> startIndex = new ArrayList<Integer>();
        		
        for (int i = 0; i < wordSize; i++) {
            int idx = 0;
            
            if (word2Freq.containsKey(ss[i])) {
        		Frequency freq = word2Freq.get(ss[i]);
        		int o = freq.getOrigin();
        		int l = freq.getLatest();
        		freq.setOrigin((o+1));
        		freq.setLatest((l+1));
        		
        		word2Freq.put(ss[i], freq);
        	} else {
        		Frequency freq = new Frequency(1, 1);
        		word2Freq.put(ss[i], freq);
        	}
            
            while ((idx = w.indexOf(ss[i], idx)) != -1) {
            	index2Word.put(idx, ss[i]);
            	
            	startIndex.add(idx);
                idx++;
            }
            
        }

        int count, crt;
        ArrayList<String> updated = new ArrayList<String>();
        
        
        for (Integer start : startIndex) {
        	crt = start;
        	count = 0;
        	
        	resetMap(word2Freq, updated);
        	
        	while (count < wordSize) {
        		if (index2Word.containsKey(crt) &&
        				word2Freq.get(index2Word.get(crt)).getLatest()>0) {
        			//System.out.println(index2Word.get(crt));
        			updated.add(index2Word.get(crt));
        			int l = word2Freq.get(index2Word.get(crt)).getLatest();
        			word2Freq.get(index2Word.get(crt)).setLatest((l-1));
        			crt += len;
        			count ++;
        		} else {
        			break;
        		}
        	}
        	
        	if (count >= wordSize) {
        		System.out.println(start);
        		return;
        	}
        }
    }
    
    public static void resetMap(HashMap<String, Frequency> theMap, ArrayList<String> updated) {
    	if (updated != null && !updated.isEmpty()) {
	    	for (String word : updated) {
	    		int o = theMap.get(word).getOrigin();
	    		theMap.get(word).setLatest(o);
	    	}
    	}
    }
}

class Frequency {
	int origin;
	int latest;
	
	Frequency(int o, int l) {
		origin = o;
		latest = l;
	}
	
	int getOrigin() {
		return origin;
	}
	
	int getLatest() {
		return latest;
	}
	
	void setOrigin(int o) {
		origin = o;
	}
	
	void setLatest(int l) {
		latest = l;
	}
}
