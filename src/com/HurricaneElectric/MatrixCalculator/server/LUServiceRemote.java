package com.HurricaneElectric.MatrixCalculator.server;

import com.HurricaneElectric.MatrixCalculator.client.service.LUService;
import com.HurricaneElectric.MatrixCalculator.shared.LUMatriciesAndAnswer;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LUServiceRemote extends RemoteServiceServlet implements LUService {

	public LUMatriciesAndAnswer luFactor(String matrixString) {
		
		double matrix[][] = MatrixParse.squareParse(matrixString);
				
		// Initialize L and U matrices
		double [][] L = new double[matrix.length][matrix.length], U = matrix;
		boolean unstable = false;
		double pivot = 0;
		
		// Set the diagonal of L to 1
		for(int i = 0; i < matrix.length; i++) {
			L[i][i] = 1;
		}
		
		for(int i = 0; i < matrix.length - 1 && !unstable; i++) {
			
			pivot = U[i][i];
			// If the pivot is 0, then the factoring is unstable
			if(pivot == 0)
				unstable = true;
			
			for(int j = i+1; j < matrix.length && !unstable; j++) {
				
				// Populate the L matrix
				L[j][i] = U[j][i]/U[i][i];
				
				for(int k = i; k < matrix.length; k++) {
					if(k == i)
						// Get rid of any small non-zero values arbitrarily
						U[j][k] = 0; 
					else
						U[j][k] = (-L[j][i])*U[i][k] + U[j][k];
				}
				
			}
		}
		
		
		//new LUMatriciesAndAnswer(L,U).printMatrices();
		
		return new LUMatriciesAndAnswer(L,U);
	}

	
}
