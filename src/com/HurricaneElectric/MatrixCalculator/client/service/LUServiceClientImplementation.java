package com.HurricaneElectric.MatrixCalculator.client.service;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class LUServiceClientImplementation {

	private LUServiceAsync luService;
	
	public LUServiceClientImplementation(String url) {
		this.luService = GWT.create(LUService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.luService;
		endpoint.setServiceEntryPoint(url);
	}
	
	void luFactor(double [][] matrix) {
		this.luService.luFactor(matrix, new LUCallback());
	}
	
	private class LUCallback implements AsyncCallback {

		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			System.out.println("Error.\n");
			
		}

		public void onSuccess(Object result) {
			
			System.out.println("Response Received.");
			
		}
		
	}
	
}
