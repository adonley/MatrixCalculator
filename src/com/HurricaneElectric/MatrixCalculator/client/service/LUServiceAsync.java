package com.HurricaneElectric.MatrixCalculator.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LUServiceAsync {
	
	void luFactor(double [][] matrix, AsyncCallback callback);

}
