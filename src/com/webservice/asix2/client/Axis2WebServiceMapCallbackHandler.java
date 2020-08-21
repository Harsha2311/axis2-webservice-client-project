
/**
 * Axis2WebServiceMapCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */

    package com.webservice.asix2.client;

    /**
     *  Axis2WebServiceMapCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class Axis2WebServiceMapCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public Axis2WebServiceMapCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public Axis2WebServiceMapCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getWebServiceMap method
            * override this method for handling normal response from getWebServiceMap operation
            */
           public void receiveResultgetWebServiceMap(
                    com.webservice.asix2.client.Axis2WebServiceMapStub.GetWebServiceMapResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getWebServiceMap operation
           */
            public void receiveErrorgetWebServiceMap(java.lang.Exception e) {
            }
                


    }
    