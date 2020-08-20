package com.hitech.axis2;


import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;


import org.apache.axis2.Constants;
import org.apache.axis2.util.CommandLineOption;
import org.apache.axis2.util.CommandLineOptionParser;
import org.apache.axis2.util.OptionsValidator;


import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

//import sample.addressbook.entry.Entry;


public class CallAxis2WebServiceClientExample {

	String url = "http://localhost:8080/services/Version/getVersion";
	public static void main(String[] args) {
		CallAxis2WebServiceClientExample main = new CallAxis2WebServiceClientExample();
		
		try {
			main.requestGetVersion();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	
	
	
	/*
		http://ldg.pe.kr/Wiki.jsp?page=RESTfulWebServicesSupport
		axis2 구축된 샘플 호출 ( getVersion )
	*/
	public void requestGetVersion() throws AxisFault{
		
		
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		
		
		options.setTo(new EndpointReference(url));
		
		options.setProperty(Constants.Configuration.ENABLE_REST, Constants.VALUE_TRUE);
		
		ServiceClient sender = new ServiceClient();
//		sender.engageModule(new QName(Constants.MODULE_ADDRESSING));
		
		sender.setOptions(options);
        OMElement result = sender.sendReceive(getPayload());
        String response = result.getFirstElement().getText();
        System.out.println("response:" + response);
        /* 
         * return 값을 출력 하기 위한 처리 
         *  */
        try {
            XMLStreamWriter writer = XMLOutputFactory.newInstance()
                    .createXMLStreamWriter(System.out);
            result.serialize(writer);
            writer.flush();
            
            
            
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FactoryConfigurationError e) {
            e.printStackTrace();
        }
		
	}
	
	private static OMElement getPayload() {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace( "http://axisversion.sample", "example1");
        OMElement method = fac.createOMElement("echo", omNs);
        OMElement value = fac.createOMElement("Text", omNs);
        value.addChild(fac.createOMText(value, "Axis2 Echo String "));
        method.addChild(value);

        return method;
    }

}
