
import java.util.Scanner;

// ウェブサイトでプレゼント企画を実施しました。
//プレゼントには A と B の二種類があります。
//
//当選者は以下の条件に従って、選出されます。
//
//・整数 X の倍数番目の応募者はプレゼント A の当選者とする
//・整数 Y の倍数番目の応募者はプレゼント B の当選者とする
//
//応募者の数が与えられるので、各応募者のプレゼント当選情報を出力してください。プレゼント A と B の両方当選した人は AB、A だけ当選した人は A、B だけ当選した人は B、どちらも当選してない人は N を出力してください。
//
//入力例 1 の場合、応募者の人数は 5 人なので、5 人の当選情報を出力します。プレゼント A の当選者は、2 の倍数番目の応募者で、プレゼント B の当選者は 4 の倍数の当選者なので、2 番目の応募者は A、4 番目の応募者は AB となり、それ以外の応募者は N になります。
//
//入力される値
//入力は以下のフォーマットで与えられます。
//
//N X Y
//・1 行目にはそれぞれ整数 N, X, Y がこの順で半角スペース区切りで与えられます。これらは応募者が N 人であることを示し、X の倍数番目の応募者がプレゼント A の当選者となり、Y の倍数番目の応募者がプレゼント B の当選者となることを示します。
//・入力は 1 行となり、末尾に改行が 1 つ入ります。
//
//期待する出力
//おそれぞれの応募者の当選情報を以下の形式で出力してください。
//a_1
//a_2
//...
//a_N
//・期待する出力は N 行からなります。
//・i 行目 (1 ≦ i ≦ N) にはそれぞれ i 番目の応募者の当選情報を出力してください。
//・プレゼント A に当選しているとき、大文字アルファベットの A を、プレゼント B に当選しているとき、大文字アルファベットの B を、プレゼント A、Bの両方当選しているとき、大文字アルファベットの AB を出力し、当選していないとき、大文字アルファベットの N を出力してください。
//・出力最終行の末尾に改行を入れ、余計な文字、空行を含んではいけません。
//
//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・1 ≦ N ≦ 1,000
//・1 ≦ X, Y ≦ N

public class gift_project {
	
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        String line = sc.nextLine();
	        String N[] = line.split(" ");
	        int member[] = new int[3];
	        member[0] = Integer.parseInt(N[0]);
	        member[1] = Integer.parseInt(N[1]);
	        member[2] = Integer.parseInt(N[2]);
	        
	        for(int i = 0, j = 1; i < member[0]; i++, j++) {
	            
	            if(j % member[1] == 0 && j % member[2] ==0) {
	                System.out.println("AB");
	                continue;
	            } else if(j % member[1] == 0) {
	                System.out.println("A");
	                continue;
	            } else if(j % member[2] == 0) {
	                System.out.println("B");
	            } else {
	                System.out.println("N");
	            }
	            
	        }
	    }
}

