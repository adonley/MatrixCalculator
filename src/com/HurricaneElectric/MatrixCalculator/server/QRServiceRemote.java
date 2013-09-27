package com.HurricaneElectric.MatrixCalculator.server;

import com.HurricaneElectric.MatrixCalculator.client.service.QRFactor.QRService;
import com.HurricaneElectric.MatrixCalculator.shared.QRMatricesAndAnswer;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class QRServiceRemote extends RemoteServiceServlet implements QRService {

	private static final long serialVersionUID = -8787592976571518889L;

	public QRMatricesAndAnswer qrFactor(String matrixString) {
		
		double matrix[][] = MatrixParse.squareParse(matrixString);
				
		// Initialize L and U matrices
		double [][] Q = new double[matrix.length][matrix.length], R = matrix, tempMatrix = new double[matrix.length][matrix.length];
		double [] x = new double[matrix.length], v = new double[matrix.length], w = new double[matrix.length], u = new double[matrix.length];
		double xNorm = 0, vNorm = 0;
		//boolean unstable = false;
		
		// Make Q an Identity Matrix
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix.length; j++)
				if(j!=i)
					Q[i][j] = 0;
				else
					Q[i][j] = 1;
		
		for(int k = 0; k < matrix.length; k++) {
			
			// Make the arrays zero arrays
			for(int i = 0; i < matrix.length; i++) {
				x[i] = 0;
				v[i] = 0;
			}
			
			for(int i = k; i < matrix.length; i++) {
				x[i] = R[i][k];
			}
			
			xNorm = get2Norm(x);
			v = x;
			
			v[k] = x[k] + xNorm;
			vNorm = get2Norm(v);
			
			if(vNorm != 0) {
				
				for(int j = 0; j < w.length; j++)
					w[j] = v[j] / vNorm;
				
				tempMatrix = matrixTranspose(R);
				tempMatrix = multMatrixAndScalar(2.0, tempMatrix);
				u = multMatrixAndVector(tempMatrix, w);
				
				//multVectorAndVector(w,u);
				R = subtractMatrixAndMatrix( R, multVectorAndVector(w,u) );
				
				//Q = subtractMatrixAndMatrix( Q, multMatrices( multMatrixAndScalar(2.0, Q ), multVectorAndVector(w,w) ) );
				
			}
			
		}
		
		for(int i = 0; i < R.length; i++)
			for(int j = 0; j < R.length; j++)
				if(i > j)
					R[i][j] = 0;
		
		return new QRMatricesAndAnswer(Q,R);
	}
	
	public double [][] subtractMatrixAndMatrix(double matrix1[][], double matrix2[][]) {
		
		double [][] retMatrix = new double[matrix1.length][matrix2.length];
		
		for(int i = 0; i < matrix1.length; i++)
			for(int j = 0; j < matrix1.length; j++)
				retMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
		
		return retMatrix;
	}
	
	public double [] multMatrixAndVector(double matrix[][], double vector[]) {
		
		double retVector[] = new double[vector.length];
		
		for(int i = 0; i < matrix.length; i++)
			retVector[i] = 0;
		
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix.length; j++) 
				retVector[i] += matrix[i][j] * vector[j];
			
		return retVector;
	}
	
	public double [][]multVectorAndVector(double vector1[], double vector2[]) {
		
		double retMatrix[][] = new double[vector1.length][vector1.length];
		
		for(int i = 0; i < vector1.length; i++) {
			for(int j = 0; j < vector1.length; j++) {
				retMatrix[i][j] = vector1[i]*vector2[j];
			}
		}
		
		return retMatrix;
	}
	
	public double [][] multMatrices(double matrix1[][], double matrix2[][]) {
		
		double retMatrix[][] = new double[matrix1.length][matrix1.length];
		double temp;
		
		for(int i = 0; i < matrix1.length; i++) {
			for(int j = 0; j < matrix1.length; j++) {
				temp = 0;
				for(int k = 0; k < matrix1.length; k++) {
					temp += matrix1[i][k]*matrix2[k][j];
				}
				retMatrix[i][j] = temp;
			}
		}
		return retMatrix;
	}
	
	public double [][] multMatrixAndScalar(double scalar, double [][] matrix) {
		
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix.length; j++) 
				matrix[i][j] = matrix[i][j]*scalar;
		
		return matrix;
	}
	
	/* 
	 * Transposes a double square matrix
	 */
	public double [][] matrixTranspose(double [][] matrix) {

		double [][] transpose = new double[matrix.length][matrix.length];
		
		for(int i = 0; i < matrix.length; i ++)
			for(int j = 0; j < matrix.length; j++) {
				transpose[i][j] = matrix[j][i];
			}
		
		return transpose;
		
	}
	
	public double [] normalize(double vector[]) {
		
		double magnitude = 0;
		
		for(int i = 0; i < vector.length; i++)
			magnitude += vector[i]*vector[i];
		
		magnitude = Math.sqrt(magnitude);
		
		for(int i = 0; i < vector.length; i++)
			vector[i] = vector[i] / magnitude;
		
		return vector;
	}
	
	public double get2Norm(double vector[]) {
		
		double magnitude = 0;
		
		for(int i = 0; i < vector.length; i++)
			magnitude += vector[i]*vector[i];
		
		magnitude = Math.sqrt(magnitude);
		
		return magnitude;
		
	}


}
