package com.HurricaneElectric.MatrixCalculator.client;

import com.HurricaneElectric.MatrixCalculator.client.service.ServiceController;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class MatrixCalculator implements EntryPoint {
	
	private ServiceController controller;

	public void onModuleLoad() {

		//clientImp = new LUServiceClientImplementation(GWT.getHostPageBaseURL() + "matrixcalculator/luservice"); 
		controller = new ServiceController();
		RootPanel.get("matrixInput").add(controller.getGUI());

	}
}
