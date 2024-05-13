import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//勇者であるあなたが森を歩いていると、N 体のモンスターが出現しました。
//モンスターの HP はそれぞれ h_1, h_2, ..., h_N です。
//モンスターは HP を 0 以下にすると倒すことができます。
//
//あなたには攻撃力 A の単体攻撃と攻撃力 B の全体攻撃の 2 つの攻撃手段があります。
//攻撃を行うと、攻撃力分だけのモンスターのHPを減らすことができます。
//単体攻撃と全体攻撃を適切に組み合わせて攻撃したとき、すべてのモンスターを倒すのに必要な最少の攻撃回数は何回になるでしょうか。
//
//たとえば、入力例 1 の場合、全体攻撃、全体攻撃、モンスター3に単体攻撃の順に攻撃を行えば 3 回の攻撃ですべてのモンスターを倒すことができ、これが最少の攻撃回数となります
//入力される値
//入力は以下のフォーマットで与えられます。
//
//A B
//N
//h_1 h_2 ... h_N
//・1 行目に 単体攻撃力を表す整数 A と全体攻撃力を表す整数 B が半角スペース区切りで与えられます。
//・続く 2 行目に出現したモンスターの数を表す整数 N が与えられます。
//・続く 3 行目に出現したモンスターのHPを表す N 個の整数 h_1, h_2, ..., h_N が半角スペース区切りで与えられます。
//・入力は合計で 3 行となり、末尾に改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください
//期待する出力
//すべてのモンスターを倒すのに必要な最少の攻撃回数を出力してください。
//末尾に改行を入れ、余計な文字、空行を含んではいけません。
//
//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・1 ≦ A, B ≦ 1,000
//・1 ≦ N ≦ 1,000
//・1 ≦ h_i ≦ 1,000 (1 ≦ i ≦ N)
//入力例1
//5 3
//3
//3 6 8
//出力例1
//3
//入力例2
//10 1
//5
//1 1 1 1 10
//出力例2
//2

public class MonsterAttack {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 単体攻撃力と全体攻撃力の入力
		int singleAttack = scanner.nextInt();
		int allAttack = scanner.nextInt();

		// モンスターの数とHPの入力
		int monsterCount = scanner.nextInt();
		List<Integer> hpList = new ArrayList<>();
		for (int i = 0; i < monsterCount; i++) {
			hpList.add(scanner.nextInt());
		}

		int minAttacks = calculateMinAttacks(hpList, monsterCount, singleAttack, allAttack);
		System.out.println(minAttacks);
	}

	public static int calculateMinAttacks(List<Integer> hpList, int monsterCount, int singleAttack, int allAttack) {
		// モンスターのHPを降順にソート
		Collections.sort(hpList, Collections.reverseOrder());

		int minAttacks = 0;

		// モンスターのHPが全て0以下になるまで攻撃を繰り返す
		while (!hpList.isEmpty() && hpList.get(0) > 0) {
			// 全体攻撃を行う場合の処理
			if (hpList.size() > 1 && hpList.get(1) > 0) {
				for (int i = 0; i < hpList.size(); i++) {
					hpList.set(i, hpList.get(i) - allAttack);
				}
			} else {
				// 単体攻撃を行う場合の処理
				hpList.set(0, hpList.get(0) - singleAttack);
			}

			// HPが0以下になったモンスターを削除
			hpList.removeIf(hp -> hp <= 0);

			// 攻撃回数をカウント
			minAttacks++;
		}

		return minAttacks;
	}
}