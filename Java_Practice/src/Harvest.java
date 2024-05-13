import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//あなたは農場で働いています。あなたが働いている農場では、一年のうちに n 回、同じ畑で作物を栽培します。
//あなたが担当している畑は、h 行 w 列の正方形状の区画に分割されています。以下では、i 行 j 列目の区画を区画 (i, j) と表記します。
//また、あなたが担当している畑では、一年を通して m 種類の作物を栽培します。ここでは、それぞれの作物に 1 から順番に番号を振り、作物 1、作物 2、…、作物 m と呼ぶことにします。
//
//一年のはじめには、畑では何も栽培されていません。この状態から、次の手順に則り作物を栽培していきます。
//
//・第 i 期には、a_i 行から b_i 行まで、c_i 列から d_i 列までの長方形の区画の作物をすべて収穫する。そして、同じ区画に作物 e_i を植える
//
//ただし、第 i 期に植えた作物は、第 i + 1 期には収穫可能な状態まで育っているとします(1 ≦ i ≦ n - 1)。また、それぞれの作物は丈夫なため、一度収穫可能な状態まで育った後に枯れることは無いものとします。
//
//あなたは、事前に n 期分の栽培計画のデータを手渡されました。第 n 期までの手順が終わったあとに、m 種類の作物がそれぞれいくつ収穫できるかを計算してください。また、第 n 期の作業が終わった後に、それぞれの区画に植えられている作物の情報を表示してください。
//
//入力される値
//入力は以下のフォーマットで与えられます。
//
//n m
//h w
//a_1 b_1 c_1 d_1 e_1
//a_2 b_2 c_2 d_2 e_2
//...
//a_n b_n c_n d_n e_n
//・1 行目に、一年の作業回数を表す整数 n、作物の種類数を表す整数 m がこの順で半角スペース区切りで与えられます。
//・2 行目に、それぞれ畑の行数と列数を表す整数 H, W がこの順で半角スペース区切りで与えられます。
//・続く n 行のうちの i 行目 (1 ≦ i ≦ n) には、第 i 期の作業範囲を表す整数 a_i, b_i, c_i, d_i と、第 i 期に植える作物の種類を表す整数 e_i がこの順で半角スペース区切りで与えられます。
//・入力は合計で n + 2 行となり、入力値最終行の末尾に改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください
//期待する出力
//それぞれの作物の収穫数と、第 n 期の作業後の畑の状態を以下の形式で出力してください。
//r_1
//r_2
//...
//r_m
//s_1
//s_2
//...
//s_h
//・期待する出力は m + h 行からなります。
//・i 行目 (1 ≦ i ≦ m) には作物 i の収穫数を表す整数 r_i を出力して下さい。
//・続く h 行のうちの i 行目 (1 ≦ i ≦ h) には半角数字および "." からなる長さ w の文字列 s_i を出力してください。s_i の j 番目 (1 ≦ j ≦ w) の文字は第 n 期の作業後の畑の区画 (i, j) 状態を表し、半角数字である場合、区画 (i, j) にその数の作物が植えられていることを、"." は区画 (i, j) に何も植えられていないことを表します。
//・m + h 行目の出力の最後に改行を入れ、余計な文字、空行を含んではいけません。
//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・1 ≦ n ≦ 50
//・1 ≦ m ≦ 9
//・1 ≦ w, h ≦ 30
//・1 ≦ a_i ≦ b_i ≦ h (1 ≦ i ≦ n)
//・1 ≦ c_i ≦ d_i ≦ w (1 ≦ i ≦ n)
//・1 ≦ e_i ≦ m (1 ≦ i ≦ n)
//入力例1
//3 2
//2 4
//1 2 3 4 1
//1 1 1 4 2
//1 2 2 3 1
//出力例1
//3
//2
//2112
//.111
//入力例2
//7 4
//1 10
//1 1 1 9 4
//1 1 2 3 3
//1 1 7 9 1
//1 1 4 7 3
//1 1 2 3 2
//1 1 1 3 1
//1 1 3 3 3
//出力例2
//2
//2
//2
//9
//113333311.

public class Harvest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int workCount = scanner.nextInt();
		int vegetables = scanner.nextInt();
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		scanner.nextLine(); // 改行読み飛ばし

		int[][] workArea = new int[workCount][5];

		for (int i = 0; i < workCount; i++) {
			String[] line = scanner.nextLine().split(" ");
			for (int j = 0; j < 5; j++) {
				workArea[i][j] = Integer.parseInt(line[j]);
			}
		}

		simulateCultivation(workCount, vegetables, rows, columns, workArea);
	}

	public static void simulateCultivation(int workCount, int vegetables, int rows, int columns, int[][] workArea) {
		String[][] harvest = new String[rows][columns];
		Map<Integer, Integer> harvestCounts = new HashMap<>();

		for (String[] row : harvest) {
			Arrays.fill(row, ".");
		}

		for (int i = 0; i < workCount; i++) {
			int startRow = workArea[i][0] - 1;
			int endRow = workArea[i][1] - 1;
			int startColumn = workArea[i][2] - 1;
			int endColumn = workArea[i][3] - 1;
			int crop = workArea[i][4];

			for (int row = startRow; row <= endRow; row++) {
				for (int column = startColumn; column <= endColumn; column++) {
					if (harvest[row][column].equals(".")) {
						harvest[row][column] = String.valueOf(crop);
					} else {
						harvestCounts.put(Integer.parseInt(harvest[row][column]),
								harvestCounts.getOrDefault(Integer.parseInt(harvest[row][column]), 0) + 1);
						harvest[row][column] = String.valueOf(crop);
					}
				}
			}
		}

		for (int i = 1; i <= vegetables; i++) {
			System.out.println(harvestCounts.getOrDefault(i, 0));
		}

		for (String[] row : harvest) {
			System.out.println(String.join("", row));
		}
	}
}