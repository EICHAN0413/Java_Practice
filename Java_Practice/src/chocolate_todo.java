import java.util.Scanner;
public class chocolate_todo {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int tate = sc.nextInt();
        int yoko = sc.nextInt();
        String line99 = sc.nextLine();
        int yokotodo[]= new int[yoko];
        String result[][] = new String[tate][yoko];
        int targetSum = 0;
        int currentSum = 0;
        
        for(int i = 0; i < tate; i++) {
            
            String line = sc.nextLine();
            String[] line1 = line.split(" ");
            int n = 0;
            for(String s : line1) {
            	yokotodo[n] = Integer.parseInt(s);
            	n++;
            }
           
            int sum = 0;
            for (int num : yokotodo) {
                sum += num;
            }
            // 要素数が奇数の場合は条件を満たすことができない
            if (sum % 2 != 0) {
                continue;
            }
            
            targetSum = sum / 2;
            currentSum = 0;
            int o = 0;
            for (int num : yokotodo) {
                if (currentSum < targetSum) {
                    currentSum += num;
                    result[i][o] = ("A");
                } else {
                	result[i][o] = "B";
                }
                o++;
            }
            
            
        }
        
        if(targetSum != currentSum) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            	for(int p = 0; p < result.length; p++) {
                    for(int l = 0; l < result[p].length; l++) {
                        System.out.print(result[p][l]);
                    }
                    System.out.println();
                }
            
        }
        
    }
    
}