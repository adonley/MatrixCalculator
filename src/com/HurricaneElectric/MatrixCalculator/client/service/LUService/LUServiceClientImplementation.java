package com.HurricaneElectric.MatrixCalculator.client.service.LUService;

import com.HurricaneElectric.MatrixCalculator.client.GUI.MainGUI;
import com.HurricaneElectric.MatrixCalculator.shared.LUMatriciesAndAnswer;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class LUServiceClientImplementation {

	private LUServiceAsync luService;
	private MainGUI gui;
	
	public LUServiceClientImplementation(String url,MainGUI gui) {
		//System.out.println(url);
		this.gui = gui;
		this.luService = GWT.create(LUService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.luService;
		//System.out.print((ServiceDefTarget)this.luService);
		endpoint.setServiceEntryPoint(url);
	}
	
	public void luFactor(String matrixString) {
		this.luService.luFactor(matrixString, new LUCallback());
	}
	
	private class LUCallback implements AsyncCallback {

		public void onFailure(Throwable caught) {
			System.out.println("Error with callback.\n");
			
		}

		public void onSuccess(Object result) {
			
			if(result==null) { 
				System.out.print("Problem Parsing\n");
			}
			else {
				LUMatriciesAndAnswer tempMatrices = (LUMatriciesAndAnswer)result;
				double tempL[][] = tempMatrices.getL();
				double tempU[][] = tempMatrices.getU();
				gui.updateAnswer(tempL,tempU);
			}
			
		}
		
	}
	
}
