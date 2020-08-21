package com.webservice.asix2.client;


import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

import com.webservice.asix2.service.Axis2WebServiceMapParameterExampleStub;
import com.webservice.asix2.service.Axis2WebServiceMapParameterExampleStub.Entry1;
import com.webservice.asix2.service.Axis2WebServiceMapParameterExampleStub.GetWebServiceMap;
import com.webservice.asix2.service.Axis2WebServiceMapParameterExampleStub.GetWebServiceMapResponse;
import com.webservice.asix2.service.Axis2WebServiceMapParameterExampleStub.Map1;
import com.webservice.asix2.service.Axis2WebServiceMapParameterExampleStub.Map2;



public class Axis2WebServiceMapParameterClientExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Axis2WebServiceMapParameterClientExample main = new Axis2WebServiceMapParameterClientExample();
		
		main.callWebServiceGetWebServiceMap();

	}
	
	public void callWebServiceGetWebServiceMap() {
		
		try {
			
//			req_parameter.
			
			
			Axis2WebServiceMapParameterExampleStub stub = new Axis2WebServiceMapParameterExampleStub();
			Axis2WebServiceMapParameterExampleStub.GetWebServiceMap request = new GetWebServiceMap();
			
			
			Map1 req_parameter = new Map1();
			Entry1 entry1 = new Entry1();
			entry1.setKey("echo-key1");
			entry1.setValue("echo-value1");
			
			req_parameter.addEntry(entry1);
			
			//req_parameter.setEntry(param);
			request.setParam(req_parameter);
			
//			request.set_return(parameter);
//			System.out.println("resultmsg:" + response.get_return());
			
			/*
			 * https://issues.apache.org/jira/browse/AXIS2-5064
			 * */
			GetWebServiceMapResponse response = stub.getWebServiceMap(request);
			
			
			Map2 responseMap2 = response.get_return();
			
			System.out.println("key : " + responseMap2.getEntry()[0].getKey());
			System.out.println("Value : " + responseMap2.getEntry()[0].getValue());
			
			
			
			
			System.out.println("end");
			
		} catch (AxisFault  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( RemoteException re ) {
			re.printStackTrace();
			
		}
		
		
	}

}
