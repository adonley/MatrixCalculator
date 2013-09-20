package com.HurricaneElectric.MatrixCalculator.server;

import java.util.Scanner;

public class MatrixParse {
	
	public static double [][] squareParse(String matrixString) {
		
		int length = 0;
		
		matrixString = matrixString.replaceAll(" {2,}|\n|,"," ");
		String temp = matrixString;
		
		Scanner s = new Scanner(temp);
		
		// Count the number of doubles
		while(s.hasNextDouble()) {
			length++;
			s.nextDouble();
		}
		
		//Check to see if the length of the sides of the matrix are square
		if(Math.sqrt(length) != Math.round(Math.sqrt(length))) {
			// Meaning this is not square
			return null;
		}
		
		length = (int)Math.sqrt(length);
		
		double answer[][] = new double[length][length]; 
		s = new Scanner(matrixString);
		
		// Load up the values into the array
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length && s.hasNextDouble(); j++) {
				answer[i][j] = s.nextDouble();
			}
		}
		
		return answer;
	}

}
