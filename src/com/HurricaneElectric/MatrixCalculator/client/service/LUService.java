package com.HurricaneElectric.MatrixCalculator.client.service;

import com.HurricaneElectric.MatrixCalculator.shared.LUMatriciesAndAnswer;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("luservice")
public interface LUService extends RemoteService {
	
	LUMatriciesAndAnswer luFactor(double [][] matrix);

}
