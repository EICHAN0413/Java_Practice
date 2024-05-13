import java.util.Scanner;

//N × N のビンゴカードが 1 枚あります。
//どのビンゴカードにも中央のマスには 0 が書かれており、最初から開けることができます。また、他のマスには数字がランダムに書かれています。
//ただし、同じ数字が書かれたマスはありません。
//
//これから K 回の抽選が行われます。
//抽選では数字がランダムに排出されます。同じ数字が2回以上排出されることはありません。
//ビンゴカードに抽選された数字と同じ数字が書かれたマスがあれば、そのマスを開けることができます。
//
//ビンゴカードの縦横もしくは対角の斜め N 個のマスがすべて開けられたとき、ビンゴとします。
//K 回の抽選の後、ビンゴの数を出力してください。

//入力される値
//入力は以下のフォーマットで与えられます。
//
//N K
//b_{1,1} b_{1,2} ... b_{1,N}
//b_{2,1} b_{2,2} ... b_{2,N}
//...
//b_{N,1} b_{1,2} ... b_{N,N}
//c_1 c_2 ... c_K
//・1 行目にビンゴカードの縦横の大きさを表す整数 N と抽選回数を表す整数 K が半角スペース区切りで与えられます。
//・続く 2 行目から N+1 行目までビンゴカードに書かれた数字が半角スペース区切りで与えられます。
//・続く N+2 行目に抽選された数字が半角スペース区切りで与えられます。
//・入力は合計で N+2 行となり、末尾に改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください
//期待する出力
//K 回の抽選の後のビンゴの数を出力してください。
//末尾に改行を入れ、余計な文字、空行を含んではいけません。
//
//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・3 ≦ N ≦ 21
//・0 ≦ b_{i,j} ≦ 3*N^2 (1 ≦ i,j ≦ N)
//・0 ≦ c_i ≦ 3*N^2 (1 ≦ i ≦ K)
//・1 ≦ K ≦ N^2-1
//・N は奇数
//・ビンゴカードの中央に書かれている数字は 0
//・b_{i,j} および c_i に重複はない
//
//入力例1
//3 8
//13 3 9
//8 0 2
//16 17 15
//7 14 9 10 3 13 16 8
//出力例1
//3
//入力例2
//5 8
//7 6 15 32 41
//29 5 48 3 43
//26 13 0 1 18
//2 17 49 8 40
//11 50 36 22 27
//3 21 16 41 11 40 34 17
//出力例2
//1
//入力例3
//3 8
//1 2 3
//4 0 5
//6 7 8
//1 2 3 4 5 6 7 8
//出力例3
//8

public class BingoGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cardSize = sc.nextInt();
		int drawCount = sc.nextInt();
		sc.nextLine(); // 改行読み飛ばし

		String[][] bingoCard = new String[cardSize][cardSize];

		for (int i = 0; i < cardSize; i++) {
			bingoCard[i] = sc.nextLine().split(" ");
		}

		String[] drawNumbers = sc.nextLine().split(" ");

		int bingoCount = countBingos(bingoCard, drawNumbers);

		System.out.println(bingoCount);
	}

	public static int countBingos(String[][] bingoCard, String[] drawNumbers) {
		int bingoCount = 0;

		for (String number : drawNumbers) {
			markNumber(bingoCard, number);
			bingoCount = Math.max(bingoCount, checkBingos(bingoCard));
		}

		return bingoCount;
	}

	public static void markNumber(String[][] bingoCard, String number) {
		for (int i = 0; i < bingoCard.length; i++) {
			for (int j = 0; j < bingoCard[i].length; j++) {
				if (bingoCard[i][j].equals(number) || bingoCard[i][j].equals("0")) {
					bingoCard[i][j] = "B";
				}
			}
		}
	}

	public static int checkBingos(String[][] bingoCard) {
		int bingoCount = 0;

		// 行と列をチェック
		for (int i = 0; i < bingoCard.length; i++) {
			boolean rowBingo = true;
			boolean colBingo = true;
			for (int j = 0; j < bingoCard.length; j++) {
				if (!bingoCard[i][j].equals("B")) {
					rowBingo = false;
				}
				if (!bingoCard[j][i].equals("B")) {
					colBingo = false;
				}
			}
			if (rowBingo) {
				bingoCount++;
			}
			if (colBingo) {
				bingoCount++;
			}
		}

		// 対角線をチェック
		boolean mainDiagonalBingo = true;
		boolean secondaryDiagonalBingo = true;
		for (int i = 0; i < bingoCard.length; i++) {
			if (!bingoCard[i][i].equals("B")) {
				mainDiagonalBingo = false;
			}
			if (!bingoCard[i][bingoCard.length - 1 - i].equals("B")) {
				secondaryDiagonalBingo = false;
			}
		}
		if (mainDiagonalBingo) {
			bingoCount++;
		}
		if (secondaryDiagonalBingo) {
			bingoCount++;
		}

		return bingoCount;
	}
}