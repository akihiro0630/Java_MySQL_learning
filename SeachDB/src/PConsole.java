import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Random;
/*
 * �R���\�[�����o�͗p�N���X
 *
 * copyright:Nakamura,Atsushi
 *
 * ver.1.00 2018-07-13.0833
 * ver.1.01 2020-01-19.1616
 * ver.1.02 2020-02-25.0542
 */
public class PConsole {
	/**
	 *   ��������
	 *
	 * �߂�l: ���͂��ꂽ����
	 */
	public static int inputIntNum() {
		InputStreamReader isr;        // ���͂̂��߂̎d�g���u
		BufferedReader reader;        // ���͂̂��߂̎d�g���u

		String str;                   // ���͂��ꂽ��������i�[����
		int num = 0;                  // �ϊ����ꂽ����
		String prompt = "��������>";  // ���͗p�̃v�����v�g

		// ���͂̂��߂̎d�g�ݑ��u��p�ӂ���
		isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);

		//reader = new BufferedReader(new InputStreamReader(System.in));

		// ���̓��[�v
		while(true) {
			try {
				System.out.print(prompt);
				str = reader.readLine();
				num = Integer.parseInt(str);
			} catch (IOException e) {
				; // ���ޗp�Ȃ̂ŗ�O���o�͂��Ȃ��B
			} catch (NumberFormatException e) {
				System.out.println("�����ł͂���܂���.���͂������Ă�������.");
				continue;
			}
			break;
		}

		return num;
	}

	/**
	 *   ��������:���͔͈͎w���
	 *
	 * �߂�l: ���͂��ꂽ����
	 * min:�ŏ��l
	 * max:�ő�l
	 */
	public static int inputIntNum(int min, int max) {
		int num;         // ���͂��ꂽ����
		String message;  // ���̓��b�Z�[�W

		message = String.format("%d~%d�̐�������͂��Ă�������.",min ,max);
		while (true) {
			System.out.println(message);
			num = inputIntNum();
			if (num < min || num > max) {
				System.out.println("���͒l���͈͊O�ł�.");
			} else {
				break;
			}
		}
		return num;
	}

	/**
	 *    ���������
	 *
	 * �߂�l: ���͂��ꂽ����
	 */
	public static String inputString() {
		InputStreamReader isr;        // ���͂̂��߂̎d�g���u
		BufferedReader reader;        // ���͂̂��߂̎d�g���u

		String str;                   // ���͂��ꂽ��������i�[����
		String prompt = "���������>";  // ���͗p�̃v�����v�g

		// ���͂̂��߂̎d�g�ݑ��u��p�ӂ���
		isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);

		// ����
		str = "";
		try {
			System.out.print(prompt);
			str = reader.readLine();
		} catch (IOException e) {
			; // ���ޗp�Ȃ̂ŗ�O���o�͂��Ȃ��B
		}

		return str;
	}


	/**
	 * �ő�l�A�ŏ��l���w�肵�āA�����𔭐��i�����j
	 *
	 * �߂�l: �������������i�����j
	 * min:�ŏ��l
	 * max:�ő�l
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
	 * �S�v�f�Ƀ����_���Ȑ�������ꂽ�z��𐶐�����
	 *
	 * �߂�l: �����_���Ȑ����̓������z��
	 *
	 * min:�ŏ��l
	 * max:�ő�l
	 * count:�z��̌�
	 * disp: true:�������ꂽ�z����e��\������ false:�\�����Ȃ�
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
			System.out.printf( "    �쐬���ꂽ�z�� --- �v�f��:%d\n",count);
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
	 * ���{�������̏����w��i�R���\�[���o�́j�i���񂹁j
	 *
	 * �@target:�o�͕�����
	 * 	 length:�o�͌����@
	 */
	public static void printfJpn(String target, int length) {
        printfJpn(target, length, true);
    }

	/**
	 * ���{�������̏����w��i�R���\�[���o�́j
	 *
	 *    target:�o�͕�����
	 *    length:�o�͌����@
	 *    right: true:���� / false:�E��
	 */
    public static void printfJpn(String target, int length,boolean right) {
        System.out.print(formatJpnString(target, length, right));
    }

	/**
	 * ���{�������̏����w��i������쐬�j
	 *
	 *    target:�o�͕�����
	 *    int length:�o�͌����@
	 *    boolean right: true:���� / false:�E��
	 */
    public static String formatJpnString(String target, int length, boolean right) {
        String string = null;
        int byteDiff = (target.getBytes(Charset.forName("UTF-8")).length - target.length())/2;

        if (right) string = String.format("%-" + (length - byteDiff) + "s", target);
        else       string = String.format("%" + (length - byteDiff) + "s", target);

        return string;
	}

	/**
	 * ���{�������̏����w��i������쐬�A���񂹁j
	 *
	 * �߂�l: ���������ꂽ������
	 *
	 *    target:���������镶����
	 *    length:�o�͌����@
	 */
	public static String formatJpnString(String target, int length) {
		final boolean LEFT = false;
		return formatJpnString(target,length, LEFT);
	}

	/**
	 *  �S�p�����̋ЂɑΉ����� printf
	 *
	 * �߂�l: �����w�蕶����
	 * �ϒ����� ����������f�[�^��K�v�Ȃ���
	 *
	 *  2021-02-20.1528 A.Nakamura;
	 */
	public static void printf(String str, Object... obj) {

		boolean D = false; // �f�o�b�O�t���O

		String[] escapeStr = new String[obj.length];
		                           // �����w����i�[����z��
		int escapeCnt = 0;         // �����ݒ萔
		boolean inEscape = false;  // �G�X�P�[�v�C��

		int start = 0;             // �����w��J�n�ʒu
		int end = 0;               // �����w��I���ʒu

		// �����w�蕶�����T���Ĕz�� escapeStr �Ɋi�[
		for (int i = 0 ; i < str.length() ; i++) {

			// %��������
			char c = str.charAt(i);
			if (c == '%') {
				 inEscape = true;
				start = i;
				continue;
			}

			// �����w��O�Ȃ�X�L�b�v
			if (!inEscape) continue;

			// �I���̎w��q��T��
			switch(c) {
			case 't':// �����֌W�w��q�� %t? ��2�����Ȃ̂őΉ�
			case 'T':
				i++;
			case 's':// �ʏ폑���w��q
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
			case 'n':// n�͉��s�݂̂Ȃ̂ŁA���������̌��ɓ���Ȃ�

				// �����w�蕔���𔲂��o�����̂Ńt���O��false ��
				inEscape = false;
				break;

			default:// �����w��q�łȂ���΃X�L�b�v
				; // �������Ȃ�
			}
		}

		// �w�蕶����̒u������
		for (int i = 0 ; i < escapeCnt ; i++) {

			String form = escapeStr[i];

			if(D) System.out.println("-----------------------1");
			if(D) System.out.println(form.charAt(form.length()-1));

			// �����w��̏ꍇ�A�Q�����ڂ����̏ꍇ������̂Ŕr��
			if (form.charAt(form.length()-2) == 'T' ||
				form.charAt(form.length()-2) == 't' ) {

				if(D) System.out.println("---------if t?");
				if(D) System.out.println(form);

				; // �������Ȃ�

			// ������w��S,s�̏ꍇ �ϊ�����
			} else if (form.charAt(form.length()-1) == 'S' ||
					   form.charAt(form.length()-1) == 's' ) {

				if(D) System.out.println("---------if S");
				if(D) System.out.println(form);

				// �����̉���
				boolean left = false;  // ���񂹎w��
				start = 1;             // �А��w��J�n�ʒu


				// �n�C�t���w��Ȃ獶��
				if(D) System.out.println(form.charAt(1));
				if (form.charAt(start) == '-') {
					start++;
					left = true;

				}

				// �А��w����擾
				String width = form.substring(start,form.length()-1);
				int len = 0;
				if(D) System.out.println("-----------------------3");
				if(D) System.out.println(width);
				if (width.length() > 0) {
					len = Integer.parseInt(width);
				}

				// �w��ЁA�w��񂹂ŕ�������쐬�������z�������
				obj[i] = formatJpnString((String)obj[i],len,left);

				// �����w��̕��̋Ўw�������
				str = str.replace(form,"%s");
				if(D) System.out.println(form);
				if(D) System.out.println("-----------------------4");
			}
		}

		if(D) System.out.println("-----------------------5");
		if(D) System.out.println(str);

		// �W���o�͂�printf �ŏo��
		System.out.printf(str,obj);
	}


	/**
	 * �e�X�g�p���C��
	 */
	public static void main(String[] args) {
		// �g�p��F����
		int num = inputIntNum(0,18);
		System.out.println(num);


		// �g�p��F�����_���Ȓl�̔z����擾
		int[] array;
		int cnt = num;
		int maxSetting = 100;
		int minSetting = -10;
		array = createRandomIntArray(minSetting,  maxSetting,  cnt,  true);
		//                           �ŏ��l,�ő�l,�v�f��,�\��/��\��

		// �v�f���A�ő�l�A�ŏ��l���w����Ɏ��܂��Ă��邩�ǂ����ǂ��肩�ǂ����m�F
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


