
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//「じゃんけん列車」というゲームを行います。
//じゃんけん列車のおける「列車」とは、園児が一列に並んだ様子を列車に見立てた表現です。
//じゃんけん列車は、次のようなルールのゲームです。
//
//・初め、それぞれの園児は 1 人からなる列車である。
//・先生が「やめ」の合図をするまで、以下が繰り返される。
//1. 2 つの列車の先頭の園児同士がジャンケンをする(勝敗が決まるまで続ける)。
//2. 負けた列車は、勝った列車の最後尾に連結し、一つの列車となる。
//・「やめ」の合図があった時点で、最も長い列車の先頭の園児が優勝者となる。ただし、そのような列車が複数存在するなら、それらの先頭の園児は全員優勝者とする。
//
//園児の人数と、ゲーム中のじゃんけんの勝敗記録の情報が与えられたときに、ゲームの優勝者の出席番号の一覧を表示するプログラムを作成してください。
//ただし、園児たちはルールを守ってゲームを楽しみ、ジャンケンの勝敗記録は正確に記録されました。
//
//たとえば、入力例 1 では、あなたのクラスには 5 人の園児がいます。
//ゲーム中に、合計 3 回のじゃんけんが行われました。
//1 回目のじゃんけんでは、出席番号 1 の園児が出席番号 2 の園児に勝ちます。
//2 回目のじゃんけんでは、出席番号 3 の園児が出席番号 4 の園児に勝ちます。
//3 回目のじゃんけんでは、出席番号 5 の園児が出席番号 3 の園児に勝ちます。

//入力は以下のフォーマットで与えられます。
//
//N M
//x_1 y_1
//x_2 y_2
//...
//x_M y_M
//・1 行目に園児の人数を表す整数 N と、じゃんけんの勝敗記録の個数を表す整数 M が与えられます。
//・続く M 行のうちの i 行目 (1 ≦ i ≦ M) には、i 回目のじゃんけんの勝敗記録の情報を表す整数 x_i, y_i がこの順で半角スペース区切りで与えられます。これは、「i 回目のじゃんけんでは、出席番号 x_i の園児が出席番号 y_i の園児に勝った」という情報を表します。
//・入力は合計で M + 1 行となり、入力値最終行の末尾に改行が 1 つ入ります。
//
//期待する出力
//じゃんけん列車の優勝者の出席番号を以下の形式で出力してください。
//
//a_1
//a_2
//...
//a_K
//・優勝者が K 人いる場合、期待する出力は K 行からなります。
//・i 行目 (1 ≦ i ≦ K) には、優勝者の出席番号のうち、i 番目に小さいものを表す整数 a_i を出力してください。
//・すべて整数で出力してください。
//・K 行目の出力の最後に改行を入れ、余計な文字、空行を含んではいけません。
//
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・各添字の範囲は 1 ≦ i ≦ M とする。
//・2 ≦ N ≦ 1,000
//・1 ≦ M ≦ N - 1
//・1 ≦ x_i, y_i ≦ N
//・x_i ≠ y_i
//・じゃんけんの勝敗記録に矛盾はない。つまり、i 回目のじゃんけんの時点で、出席番号が x_i の園児と出席番号が y_i の園児はそれぞれの列の先頭にいる。

public class Goo_Choki_Paa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line0 = sc.nextLine();
		String N0[] = line0.split(" ");
		int N1[] = new int[2];
		N1[0] = Integer.parseInt(N0[0]);
		N1[1] = Integer.parseInt(N0[1]);

		Map<String, String> member = new HashMap<>();
		for (int m = 1; m < N1[0] + 1; m++) {
			member.put(String.valueOf(m), String.valueOf(m));
		}

		for (int i = 0; i < N1[1]; i++) {
			int m = 0;
			String line1 = sc.nextLine();
			String N2[] = line1.split(" ");
			if (member.containsKey(N2[m])) {
				String obj1 = member.get(N2[m++]);
				String obj2 = member.get(N2[m--]);
				member.put(N2[m++], obj1 + obj2);
				member.remove(N2[m]);
			}
		}

		int maxLength = 0;
		List<String> longestValues = new ArrayList<>();

		for (Map.Entry<String, String> entry : member.entrySet()) {

			String value = entry.getValue();
			int valueLength = value.length();

			if (valueLength > maxLength) {

				maxLength = valueLength;
				longestValues.clear();
				longestValues.add(entry.getKey());

			} else if (valueLength == maxLength) {

				longestValues.add(entry.getKey());

			}
		}

		for (int i = 0; i < longestValues.size(); i++) {
			String value = longestValues.get(i);
			System.out.println(value);
		}

	}

}
