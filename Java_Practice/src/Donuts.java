//あなたは、「ドーナツの絵」が大好きです。
//
//「ドーナツの絵」とは以下のように、中心のマスが白、それを囲む 8 マスが黒である 3 × 3 の模様を指します。
//なお、"." はそのマスが白であることを表し、"#" はそのマスが黒であることを表します。
// 例
//　###
//　#.#
//　###
//あくまで上記のような 3 × 3 の模様を「ドーナツの絵」と言うのであり、以下のような模様は「ドーナツの絵」ではないことに注意してください。
//    ####    #####   ######
//    #..#    #...#   ######
//    #..#    #...#   ##..##
//    ####    #...#   ##..##
//            #####   ######
//                    ######
//
//地上絵の模様が与えられるので、「ドーナツの絵」がいくつ含まれているか数え上げるプログラムを作成してください。
//
//
//入力される値
//入力は以下のフォーマットで与えられます。
//
//H W
//s_1
//s_2
//...
//s_H
//
//・1 行目にそれぞれ地上絵の縦方向のマス数、横方向のマス数を表す整数 H, W がこの順で半角スペース区切りで与えられます。
//・続く H 行のうちの i 行目 (1 ≦ i ≦ H) には半角記号 "." および "#" からなる長さ W の文字列 s_i が与えられます。s_i の j 番目 (1 ≦ j ≦ W) の文字は地上絵における i 行 j 列目のマスの色を表します。
//・入力は合計で H + 1 行となり、入力値最終行の末尾に改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください
//期待する出力
//地上絵に含まれる「ドーナツの絵」の数を整数で出力してください。
//末尾に改行を入れ、余計な文字、空行を含んではいけません。
//
//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・3 ≦ H ≦ 100
//・3 ≦ W ≦ 100
//・s_i は半角記号"#", "."のいずれかで構成される長さ W の文字列 (1 ≦ i ≦ H)

import java.util.Scanner;

public class Donuts {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
		int width = scanner.nextInt();
		int count = 0;
		String[][] donuts = new String[height][width];

		// 入力を2次元配列に格納
		for (int i = 0; i < height; i++) {

			String input = scanner.next();
			String[] row = input.split("");

			for (int j = 0; j < width; j++) {
				donuts[i][j] = row[j];
			}
		}

		// ドーナツの絵をカウント
		for (int i = 1; i < height - 1; i++) {

			for (int j = 1; j < width - 1; j++) {

				if (donuts[i][j].equals(".")) {
					if (isDonuts(donuts, i, j)) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

	// ドーナツの絵かどうかを判定するメソッド
	public static boolean isDonuts(String[][] donuts, int x, int y) {

		return donuts[x - 1][y - 1].equals("#") && donuts[x - 1][y].equals("#") && donuts[x - 1][y + 1].equals("#")
				&& donuts[x][y - 1].equals("#") && donuts[x][y + 1].equals("#") && donuts[x + 1][y - 1].equals("#")
				&& donuts[x + 1][y].equals("#") && donuts[x + 1][y + 1].equals("#");
	}
}