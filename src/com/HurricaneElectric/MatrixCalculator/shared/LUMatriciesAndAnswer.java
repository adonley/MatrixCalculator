package com.HurricaneElectric.MatrixCalculator.shared;

public class LUMatriciesAndAnswer {
	
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
			for(int j = 0; j < U.length; j++) {
				
			}
		}
		
	}

}
