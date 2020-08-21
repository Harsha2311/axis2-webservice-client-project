package com.webservice.asix2.client;


import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.webservice.asix2.client.Axis2WebServiceMapStub.GetWebServiceMap;


public class Axis2WebServiceMapClientExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Axis2WebServiceMapClientExample main = new Axis2WebServiceMapClientExample();
		
		main.callWebServiceGetWebServiceMap();

	}
	
	public void callWebServiceGetWebServiceMap() {
		
		try {
			Axis2WebServiceMapStub stub = new Axis2WebServiceMapStub();
			
			com.webservice.asix2.client.Axis2WebServiceMapStub.GetWebServiceMap request = new GetWebServiceMap();
			request.setReq("asix2 dev");
			
			
			com.webservice.asix2.client.Axis2WebServiceMapStub.GetWebServiceMapResponse response = stub.getWebServiceMap(request);
			
			System.out.println("resultmsg:" + response.get_return());
			
		} catch (AxisFault  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( RemoteException re ) {
			re.printStackTrace();
			
		}
		
		
	}

}
