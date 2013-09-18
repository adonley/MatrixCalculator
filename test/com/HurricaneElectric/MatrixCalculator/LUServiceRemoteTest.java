package com.HurricaneElectric.MatrixCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.HurricaneElectric.MatrixCalculator.server.LUServiceRemote;

public class LUServiceRemoteTest {

	@Test
	public void test() {
		LUServiceRemote lu = new LUServiceRemote();
		
		double [][] testerMatrix = {{3,2,1},{2,4,5},{6,7,8}};
		lu.luFactor(testerMatrix);
		
		
	}

}
