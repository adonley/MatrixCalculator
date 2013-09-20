package com.HurricaneElectric.MatrixCalculator.client.service;

import com.HurricaneElectric.MatrixCalculator.client.GUI.MainGUI;
import com.HurricaneElectric.MatrixCalculator.shared.LUMatriciesAndAnswer;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class LUServiceClientImplementation {

	private LUServiceAsync luService;
	private MainGUI gui;
	
	public LUServiceClientImplementation(String url) {
		//System.out.println(url);
		this.luService = GWT.create(LUService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.luService;
		//System.out.print((ServiceDefTarget)this.luService);
		endpoint.setServiceEntryPoint(url);
		this.gui = new MainGUI(this);
	}
	
	public void luFactor(String matrixString) {
		this.luService.luFactor(matrixString, new LUCallback());
	}
	
	public MainGUI getGUI() { return gui; }
	
	private class LUCallback implements AsyncCallback {

		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			System.out.println("Error.\n");
			
		}

		public void onSuccess(Object result) {
			
			if(result==null) { 
				System.out.print("Problem Parsing\n");
			}
			else {
				LUMatriciesAndAnswer tempMatrices = (LUMatriciesAndAnswer)result;
				double tempL[][] = tempMatrices.getL();
				double tempU[][] = tempMatrices.getU();
				gui.updateLU(tempL,tempU);
			}
			
		}
		
	}
	
}
