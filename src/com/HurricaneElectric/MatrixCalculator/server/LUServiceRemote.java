package com.HurricaneElectric.MatrixCalculator.server;

import com.HurricaneElectric.MatrixCalculator.client.service.LUService;
import com.HurricaneElectric.MatrixCalculator.shared.LUMatriciesAndAnswer;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LUServiceRemote extends RemoteServiceServlet implements LUService {

	public LUMatriciesAndAnswer luFactor(double[][] matrix) {
		
		// Initialize L and U matrices
		double [][] L = new double[matrix.length][matrix.length], U = matrix;
		double []tempRow = new double[matrix.length];
		boolean unstable = false;
		double pivot = 0;
		
		for(int i = 0; i < matrix.length && !unstable; i++) {
			
			pivot = U[i][i];
			// If the pivot is 0, then the factoring is unstable
			if(pivot == 0)
				unstable = true;
			
			for(int j = i; j < matrix.length && !unstable; j++) {
				// Populate the L matrix
				if(i!=j)
					L[i][j] = U[i][j]/U[i][i];
				else
					L[i][j] = 1;
				
				for(int k = i; k < matrix.length; k++) {
					U[j][k] = (-L[i][k])*U[i][k]+U[j][k];
				}
				
			}
		}
		
		
		
		
		return new LUMatriciesAndAnswer(L,U);
	}

	
}
