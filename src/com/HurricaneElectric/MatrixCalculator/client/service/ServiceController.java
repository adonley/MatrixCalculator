package com.HurricaneElectric.MatrixCalculator.client.service;

import com.HurricaneElectric.MatrixCalculator.client.GUI.MainGUI;
import com.HurricaneElectric.MatrixCalculator.client.service.LUService.LUServiceClientImplementation;
import com.google.gwt.core.client.GWT;

public class ServiceController {

	private LUServiceClientImplementation luService;
	private MainGUI gui;
	
	public ServiceController() {
		
		// Start up GUI
		this.gui = new MainGUI(this);
		
		// Start up the lu factoring service
		luService = new LUServiceClientImplementation(GWT.getHostPageBaseURL() + "matrixcalculator/luservice",gui); 

	}

	/*
	 * This method passes back a gui instance for use in the MatrixCalculator class for instantiation
	 */
	public MainGUI getGUI() { return gui; }
	
	// This calls the remote method in luService
	public void luFactor(String matrixString) { luService.luFactor(matrixString); }
	
	public LUServiceClientImplementation getLUService() { return luService; }
	
	
}
