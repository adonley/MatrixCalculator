package com.HurricaneElectric.MatrixCalculator.shared;

import java.io.Serializable;

public class LUMatriciesAndAnswer implements Serializable {
	
	private static final long serialVersionUID = 6052289893393235058L;
	private double L[][];
	private double U[][];
	private double ans[];
	
	public LUMatriciesAndAnswer(int size) {
		setL(new double[size][size]);
		setU(new double[size][size]);
		setAns(new double[size]);
	}
	
	public LUMatriciesAndAnswer(double [][]L, double [][]U) {
		this.setL(L);
		this.setU(U);
	}
	
	public LUMatriciesAndAnswer(double [][]L, double [][]U, double[]ans) {
		this.setL(L);
		this.setU(U);
		this.setAns(ans);
	}

	public double[] getAns() {
		return ans;
	}

	public void setAns(double ans[]) {
		this.ans = ans;
	}

	public double[][] getU() {
		return U;
	}

	public void setU(double u[][]) {
		U = u;
	}

	public double[][] getL() {
		return L;
	}

	public void setL(double l[][]) {
		L = l;
	}
	
	public void printMatrices() {
		
		for(int i = 0; i < U.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < U.length; j++) {
				System.out.print(U[i][j] + " ");
			}
		}
		
		System.out.print("\n");
		
		for(int i = 0; i < L.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < L.length; j++) {
				System.out.print(L[i][j] + " ");
			}
		}
		
	}

}
