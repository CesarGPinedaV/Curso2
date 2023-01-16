
package com.mx.mex.Webservices.Soap.com.praxis.fact.broker.ws.com.praxis.fact.broker.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EfacturaServiceEndpointService", targetNamespace = "http://ws.broker.fact.praxis.com/", wsdlLocation = "http://189.254.87.203:8080/efacturaws/EfacturaService?wsdl")
public class EfacturaServiceEndpointService
    extends Service
{

    private final static URL EFACTURASERVICEENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException EFACTURASERVICEENDPOINTSERVICE_EXCEPTION;
    private final static QName EFACTURASERVICEENDPOINTSERVICE_QNAME = new QName("http://ws.broker.fact.praxis.com/", "EfacturaServiceEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://189.254.87.203:8080/efacturaws/EfacturaService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EFACTURASERVICEENDPOINTSERVICE_WSDL_LOCATION = url;
        EFACTURASERVICEENDPOINTSERVICE_EXCEPTION = e;
    }

    public EfacturaServiceEndpointService() {
        super(__getWsdlLocation(), EFACTURASERVICEENDPOINTSERVICE_QNAME);
    }

    public EfacturaServiceEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EFACTURASERVICEENDPOINTSERVICE_QNAME, features);
    }

    public EfacturaServiceEndpointService(URL wsdlLocation) {
        super(wsdlLocation, EFACTURASERVICEENDPOINTSERVICE_QNAME);
    }

    public EfacturaServiceEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EFACTURASERVICEENDPOINTSERVICE_QNAME, features);
    }

    public EfacturaServiceEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EfacturaServiceEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EfacturaService
     */
    @WebEndpoint(name = "EfacturaServiceEndpointPort")
    public EfacturaService getEfacturaServiceEndpointPort() {
        return super.getPort(new QName("http://ws.broker.fact.praxis.com/", "EfacturaServiceEndpointPort"), EfacturaService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EfacturaService
     */
    @WebEndpoint(name = "EfacturaServiceEndpointPort")
    public EfacturaService getEfacturaServiceEndpointPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.broker.fact.praxis.com/", "EfacturaServiceEndpointPort"), EfacturaService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EFACTURASERVICEENDPOINTSERVICE_EXCEPTION!= null) {
            throw EFACTURASERVICEENDPOINTSERVICE_EXCEPTION;
        }
        return EFACTURASERVICEENDPOINTSERVICE_WSDL_LOCATION;
    }

}
