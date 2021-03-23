import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Random;
/*
 * コンソール入出力用クラス
 *
 * copyright:Nakamura,Atsushi
 *
 * ver.1.00 2018-07-13.0833
 * ver.1.01 2020-01-19.1616
 * ver.1.02 2020-02-25.0542
 */
public class PConsole {
	/**
	 *   整数入力
	 *
	 * 戻り値: 入力された整数
	 */
	public static int inputIntNum() {
		InputStreamReader isr;        // 入力のための仕組装置
		BufferedReader reader;        // 入力のための仕組装置

		String str;                   // 入力された文字列を格納する
		int num = 0;                  // 変換された整数
		String prompt = "整数入力>";  // 入力用のプロンプト

		// 入力のための仕組み装置を用意する
		isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);

		//reader = new BufferedReader(new InputStreamReader(System.in));

		// 入力ループ
		while(true) {
			try {
				System.out.print(prompt);
				str = reader.readLine();
				num = Integer.parseInt(str);
			} catch (IOException e) {
				; // 教材用なので例外送出はしない。
			} catch (NumberFormatException e) {
				System.out.println("整数ではありません.入力し直してください.");
				continue;
			}
			break;
		}

		return num;
	}

	/**
	 *   整数入力:入力範囲指定版
	 *
	 * 戻り値: 入力された整数
	 * min:最少値
	 * max:最大値
	 */
	public static int inputIntNum(int min, int max) {
		int num;         // 入力された整数
		String message;  // 入力メッセージ

		message = String.format("%d~%dの整数を入力してください.",min ,max);
		while (true) {
			System.out.println(message);
			num = inputIntNum();
			if (num < min || num > max) {
				System.out.println("入力値が範囲外です.");
			} else {
				break;
			}
		}
		return num;
	}

	/**
	 *    文字列入力
	 *
	 * 戻り値: 入力された整数
	 */
	public static String inputString() {
		InputStreamReader isr;        // 入力のための仕組装置
		BufferedReader reader;        // 入力のための仕組装置

		String str;                   // 入力された文字列を格納する
		String prompt = "文字列入力>";  // 入力用のプロンプト

		// 入力のための仕組み装置を用意する
		isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);

		// 入力
		str = "";
		try {
			System.out.print(prompt);
			str = reader.readLine();
		} catch (IOException e) {
			; // 教材用なので例外送出はしない。
		}

		return str;
	}


	/**
	 * 最大値、最小値を指定して、乱数を発生（整数）
	 *
	 * 戻り値: 発生した乱数（整数）
	 * min:最少値
	 * max:最大値
	 */
	public static int getRandomInt(int min, int max) {

		if (max <= min) {
			throw new IllegalArgumentException("must be \'max <= min\'");
		}
		max++;

		Random rand = new Random();
		int res = rand.nextInt(max - min) + min;

		return res;

	}

	/**
	 * 全要素にランダムな整数を入れた配列を生成する
	 *
	 * 戻り値: ランダムな整数の入った配列
	 *
	 * min:最少値
	 * max:最大値
	 * count:配列の個数
	 * disp: true:生成された配列内容を表示する false:表示しない
	 */
	public static int[] createRandomIntArray(int min, int max, int count, boolean disp) {
		int[] array;

		if (max <= min) {
			throw new IllegalArgumentException("must be \'max <= min\'");
		}
		max++;
		array = new int[count];
		Random rand = new Random();
		for (int i = 0; i < count ; i++) {
			//System.out.printf("max:%d,min:%d,max- min:%d" ,max,min,max - min) ;
			array[i] = rand.nextInt(max - min) + min;
		}

		if (disp) {
			System.out.println("=====================================================");
			System.out.printf( "    作成された配列 --- 要素数:%d\n",count);
			System.out.printf( "    by PConsole.createRandamIntArray()\n");
			System.out.println("=====================================================");
			int j = 1;
			for (int i = 0; i < count ; i++) {
				System.out.print(array[i]);
				if (i < count -1) {
					System.out.print(",");
				}
				if (j < 10) {
					j++;
				} else {
					System.out.println();
					j = 1;
				}
			}
		}
		System.out.println("\n=====================================================");
		return array;
	}

	/**
	 * 日本語交じりの書式指定（コンソール出力）（左寄せ）
	 *
	 * 　target:出力文字列
	 * 	 length:出力桁数　
	 */
	public static void printfJpn(String target, int length) {
        printfJpn(target, length, true);
    }

	/**
	 * 日本語交じりの書式指定（コンソール出力）
	 *
	 *    target:出力文字列
	 *    length:出力桁数　
	 *    right: true:左寄せ / false:右寄せ
	 */
    public static void printfJpn(String target, int length,boolean right) {
        System.out.print(formatJpnString(target, length, right));
    }

	/**
	 * 日本語交じりの書式指定（文字列作成）
	 *
	 *    target:出力文字列
	 *    int length:出力桁数　
	 *    boolean right: true:左寄せ / false:右寄せ
	 */
    public static String formatJpnString(String target, int length, boolean right) {
        String string = null;
        int byteDiff = (target.getBytes(Charset.forName("UTF-8")).length - target.length())/2;

        if (right) string = String.format("%-" + (length - byteDiff) + "s", target);
        else       string = String.format("%" + (length - byteDiff) + "s", target);

        return string;
	}

	/**
	 * 日本語交じりの書式指定（文字列作成、左寄せ）
	 *
	 * 戻り値: 書式化された文字列
	 *
	 *    target:書式化する文字列
	 *    length:出力桁数　
	 */
	public static String formatJpnString(String target, int length) {
		final boolean LEFT = false;
		return formatJpnString(target,length, LEFT);
	}

	/**
	 *  全角文字の巾に対応した printf
	 *
	 * 戻り値: 書式指定文字列
	 * 可変長引数 書式化するデータを必要なだけ
	 *
	 *  2021-02-20.1528 A.Nakamura;
	 */
	public static void printf(String str, Object... obj) {

		boolean D = false; // デバッグフラグ

		String[] escapeStr = new String[obj.length];
		                           // 書式指定を格納する配列
		int escapeCnt = 0;         // 書式設定数
		boolean inEscape = false;  // エスケープイン

		int start = 0;             // 書式指定開始位置
		int end = 0;               // 書式指定終了位置

		// 書式指定文字列を探して配列 escapeStr に格納
		for (int i = 0 ; i < str.length() ; i++) {

			// %をさがす
			char c = str.charAt(i);
			if (c == '%') {
				 inEscape = true;
				start = i;
				continue;
			}

			// 書式指定外ならスキップ
			if (!inEscape) continue;

			// 終わりの指定子を探す
			switch(c) {
			case 't':// 日時関係指定子は %t? と2文字なので対応
			case 'T':
				i++;
			case 's':// 通常書式指定子
			case 'S':
			case 'b':
			case 'B':
			case 'c':
			case 'C':
			case 'd':
			case 'D':
			case 'e':
			case 'E':
			case 'f':
			case 'F':
			case 'o':
			case 'O':
			case 'x':
			case 'X':
				end = i + 1;
				escapeStr[escapeCnt++] = str.substring(start,end);
			case 'n':// nは改行のみなので、書式文字の個数に入らない

				// 書式指定部分を抜け出したのでフラグをfalse に
				inEscape = false;
				break;

			default:// 書式指定子でなければスキップ
				; // 何もしない
			}
		}

		// 指定文字列の置き換え
		for (int i = 0 ; i < escapeCnt ; i++) {

			String form = escapeStr[i];

			if(D) System.out.println("-----------------------1");
			if(D) System.out.println(form.charAt(form.length()-1));

			// 日時指定の場合、２文字目がｓの場合があるので排除
			if (form.charAt(form.length()-2) == 'T' ||
				form.charAt(form.length()-2) == 't' ) {

				if(D) System.out.println("---------if t?");
				if(D) System.out.println(form);

				; // 何もしない

			// 文字列指定S,sの場合 変換処理
			} else if (form.charAt(form.length()-1) == 'S' ||
					   form.charAt(form.length()-1) == 's' ) {

				if(D) System.out.println("---------if S");
				if(D) System.out.println(form);

				// 書式の解釈
				boolean left = false;  // 左寄せ指定
				start = 1;             // 巾数指定開始位置


				// ハイフン指定なら左寄せ
				if(D) System.out.println(form.charAt(1));
				if (form.charAt(start) == '-') {
					start++;
					left = true;

				}

				// 巾数指定を取得
				String width = form.substring(start,form.length()-1);
				int len = 0;
				if(D) System.out.println("-----------------------3");
				if(D) System.out.println(width);
				if (width.length() > 0) {
					len = Integer.parseInt(width);
				}

				// 指定巾、指定寄せで文字列を作成し引数配列を交換
				obj[i] = formatJpnString((String)obj[i],len,left);

				// 書式指定の方の巾指定を消去
				str = str.replace(form,"%s");
				if(D) System.out.println(form);
				if(D) System.out.println("-----------------------4");
			}
		}

		if(D) System.out.println("-----------------------5");
		if(D) System.out.println(str);

		// 標準出力にprintf で出力
		System.out.printf(str,obj);
	}


	/**
	 * テスト用メイン
	 */
	public static void main(String[] args) {
		// 使用例：入力
		int num = inputIntNum(0,18);
		System.out.println(num);


		// 使用例：ランダムな値の配列を取得
		int[] array;
		int cnt = num;
		int maxSetting = 100;
		int minSetting = -10;
		array = createRandomIntArray(minSetting,  maxSetting,  cnt,  true);
		//                           最小値,最大値,要素数,表示/非表示

		// 要素数、最大値、最小値が指定内に収まっているかどうかどおりかどうか確認
		int max = array[0];
		int min = array[0];
		for (int i = 0 ; i < array.length ; i++) {
			if (max < array[i]) max = array[i];
			if (min > array[i]) min = array[i];
		}
		System.out.print("\n\n");

		System.out.println("length = " + array.length);
		System.out.println("max = " + max + ":" + maxSetting);
		System.out.println("min = " + min + ":" + minSetting);

	}

}


