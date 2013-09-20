package com.HurricaneElectric.MatrixCalculator.client;

import com.HurricaneElectric.MatrixCalculator.client.service.LUServiceClientImplementation;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class MatrixCalculator implements EntryPoint {
	
	private LUServiceClientImplementation clientImp;

	public void onModuleLoad() {

		clientImp = new LUServiceClientImplementation(GWT.getHostPageBaseURL() + "matrixcalculator/luservice"); 
		RootPanel.get("matrixInput").add(clientImp.getGUI());

	}
}
