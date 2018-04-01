package lnminh.vn;

import java.util.Arrays;

public class LearnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int M[]= new int[4]; M[0]=3;...
		int M[] = { 1, 2, 5, 7, 3, 12, 11, 60 };
		for (int i = 0; i < M.length; i++) {
			System.out.print("\t" + M[i]);
		}
		Arrays.sort(M);
		System.out.println("\nSau khi sắp xếp");
		for (int i = 0; i < M.length; i++) {
			System.out.print("\t" + M[i]);
		}

		System.out.println("\nCác số nguyên tố là");
		for (int i = 0; i < M.length; i++) {
			int dem = 0;
			for (int j = 1; j <= M[i]; j++) {
				if (M[i] % j == 0)
					dem++;
			}
			if (dem == 2) {
				System.out.print("\t" + M[i]);
			}

		}

	}
}
