package com.HurricaneElectric.MatrixCalculator.client.service.QRFactor;

import com.HurricaneElectric.MatrixCalculator.client.GUI.MainGUI;
import com.HurricaneElectric.MatrixCalculator.shared.QRMatricesAndAnswer;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class QRServiceClientImplementation {

	private QRServiceAsync qrService;
	private MainGUI gui;
	
	public QRServiceClientImplementation(String url, MainGUI gui) {
		//System.out.println(url);
		this.gui = gui;
		this.qrService = GWT.create(QRService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.qrService;
		//System.out.print((ServiceDefTarget)this.luService);
		endpoint.setServiceEntryPoint(url);
	}
	
	public void qrFactor(String matrixString) {
		this.qrService.qrFactor(matrixString, new QRCallback());
	}
	
	private class QRCallback implements AsyncCallback {

		public void onFailure(Throwable caught) {
			System.out.println("Error with callback.\n");
			
		}

		public void onSuccess(Object result) {
			
			if(result==null) { 
				System.out.print("Problem Parsing\n");
			}
			else if (result instanceof QRMatricesAndAnswer){
				QRMatricesAndAnswer tempMatrices = (QRMatricesAndAnswer)result;
				double tempQ[][] = tempMatrices.getQ();
				double tempR[][] = tempMatrices.getR();
				gui.updateAnswer(tempQ,tempR);
			}
			
		}
		
	}
	
}
