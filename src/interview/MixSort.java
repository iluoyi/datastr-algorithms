package interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MixSort {

	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        String inputLine=null;
	        while(((inputLine=br.readLine())!=null)&& inputLine.length()<=1000){
	            new MixSort().sortString(inputLine);
	        }
	    }
	    
	    public static boolean isNumeric(String s){
	        return s.matches("[-+]?\\d*\\.?\\d+");
	    }
	    
	    public void sortString(String line){
	        ArrayList<Integer> numbers=new ArrayList<Integer>();
	        ArrayList<String> words=new ArrayList<String>();
	        int indexOfNumber=0;
	        int indexOfWord=0;
	        
	        String[] inputStringList=line.split(" ");
	        
	        for(int i=0;i<inputStringList.length;i++){
	            if(isNumeric(inputStringList[i])){
	                numbers.add(Integer.parseInt(inputStringList[i]));
	                inputStringList[i]="n";
	            }
	            else{
	                words.add(inputStringList[i]);
	                inputStringList[i]="w";
	            }
	        }
	        
	        for(int i=0;i<inputStringList.length-1;i++){
	            System.out.print(inputStringList[i]+" ");
	        }
	        System.out.println();
	        
	        Collections.sort(numbers);
	        Collections.sort(words);
	        
	        for(int i=0;i<inputStringList.length;i++){
	            if(inputStringList[i].equals("n")){
	                inputStringList[i]=String.valueOf(numbers.get(indexOfNumber));
	                indexOfNumber++;
	            }
	            else{
	                inputStringList[i]=words.get(indexOfWord);
	                indexOfWord++;
	            }
	        }
	        
	        for(int i=0;i<inputStringList.length-1;i++){
	            System.out.print(inputStringList[i]+" ");
	        }
	        System.out.println(inputStringList[inputStringList.length-1]);
	    }
	    //car truck 8 4 bus 6 1


}
