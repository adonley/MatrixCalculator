package com.HurricaneElectric.MatrixCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.HurricaneElectric.MatrixCalculator.server.LUServiceRemote;

public class LUServiceRemoteTest {

	@Test
	public void test() {
		LUServiceRemote lu = new LUServiceRemote();
		
		//double [][] testerMatrix = {{3,2,1,7},{2,4,5,1},{6,7,8,9},{5,3,2,6}};
		String testerMatrix = "3 4 5 9 8 4 7 6 4";
		lu.luFactor(testerMatrix);
		
		
	}

}
