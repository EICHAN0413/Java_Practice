import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class way_rain {
	
	 public static void main(String[] args) {
	        // 自分の得意な言語で
	        // Let's チャレンジ！！
	        Scanner sc = new Scanner(System.in);
	        int way = sc.nextInt();
	        int rain_mount = sc.nextInt();
	        int way_rain[][] = new int[way][way];
	        List<Integer> result = new ArrayList<>();
	        String line99 = sc.nextLine();
	        
	        for(int i = 0; i < way; i++) {
	            
	            String line = sc.nextLine();
	            String[] line1 = line.split(" ");
	            
	            int n = 0;
	            for(String s : line1) {
	                way_rain[i][n] = Integer.parseInt(s);
	                n++;
	            }
	        }
	        
	        
	        int n = 0;
	        for(int i =0; i < way; i++) {
	            
	            int flag = 0;
	            for(int o = 0; o < way; o++) {
	                 if(rain_mount <= way_rain[o][i]) {
	                     flag = 1;
	                 }
	            }
	            
	            if(flag != 1) {
	                result.add(i+1);
	                n++;
	            }
	           
	        }
	        
	        if(result.isEmpty()) {
        		System.out.print("wait");
        	}
	        
	        for (int i = 0; i < result.size(); i++) {
	        	
	            System.out.print(result.get(i));
	            if (i < result.size() - 1) {
	                System.out.print(" ");
	            }
	        }
	        
	    }
	}

