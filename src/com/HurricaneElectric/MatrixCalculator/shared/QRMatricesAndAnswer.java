package com.HurricaneElectric.MatrixCalculator.shared;

import java.io.Serializable;

public class QRMatricesAndAnswer extends LUMatriciesAndAnswer implements Serializable {

	private static final long serialVersionUID = -6018796981844042300L;
	
	public QRMatricesAndAnswer() {
		L = null;
		U = null;
		ans = null;
	}
	
	public QRMatricesAndAnswer(int size) {
		setL(new double[size][size]);
		setU(new double[size][size]);
		setAns(new double[size]);
	}
	
	public QRMatricesAndAnswer(double [][]Q, double [][]R) {
		this.setL(Q);
		this.setU(R);
	}
	
	public QRMatricesAndAnswer(double [][]Q, double [][]R, double[]ans) {
		this.setL(Q);
		this.setU(R);
		this.setAns(ans);
	}

	public double[] getAns() {
		return ans;
	}

	public void setAns(double ans[]) {
		this.ans = ans;
	}

	public double[][] getR() {
		return U;
	}

	public void setR(double u[][]) {
		U = u;
	}

	public double[][] getQ() {
		return L;
	}

	public void setQ(double l[][]) {
		L = l;
	}

}
