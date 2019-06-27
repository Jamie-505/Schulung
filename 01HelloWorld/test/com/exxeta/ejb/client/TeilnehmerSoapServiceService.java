
package com.exxeta.ejb.client;

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
@WebServiceClient(name = "TeilnehmerSoapServiceService", targetNamespace = "http://ejb.exxeta.com/", wsdlLocation = "http://localhost:8080/01HelloWorld_war_exploded/TeilnehmerSoapService?wsdl")
public class TeilnehmerSoapServiceService
    extends Service
{

    private final static URL TEILNEHMERSOAPSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException TEILNEHMERSOAPSERVICESERVICE_EXCEPTION;
    private final static QName TEILNEHMERSOAPSERVICESERVICE_QNAME = new QName("http://ejb.exxeta.com/", "TeilnehmerSoapServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/01HelloWorld_war_exploded/TeilnehmerSoapService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TEILNEHMERSOAPSERVICESERVICE_WSDL_LOCATION = url;
        TEILNEHMERSOAPSERVICESERVICE_EXCEPTION = e;
    }

    public TeilnehmerSoapServiceService() {
        super(__getWsdlLocation(), TEILNEHMERSOAPSERVICESERVICE_QNAME);
    }

    public TeilnehmerSoapServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TEILNEHMERSOAPSERVICESERVICE_QNAME, features);
    }

    public TeilnehmerSoapServiceService(URL wsdlLocation) {
        super(wsdlLocation, TEILNEHMERSOAPSERVICESERVICE_QNAME);
    }

    public TeilnehmerSoapServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TEILNEHMERSOAPSERVICESERVICE_QNAME, features);
    }

    public TeilnehmerSoapServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TeilnehmerSoapServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TeilnehmerSoapService
     */
    @WebEndpoint(name = "TeilnehmerSoapServicePort")
    public TeilnehmerSoapService getTeilnehmerSoapServicePort() {
        return super.getPort(new QName("http://ejb.exxeta.com/", "TeilnehmerSoapServicePort"), TeilnehmerSoapService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TeilnehmerSoapService
     */
    @WebEndpoint(name = "TeilnehmerSoapServicePort")
    public TeilnehmerSoapService getTeilnehmerSoapServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ejb.exxeta.com/", "TeilnehmerSoapServicePort"), TeilnehmerSoapService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TEILNEHMERSOAPSERVICESERVICE_EXCEPTION!= null) {
            throw TEILNEHMERSOAPSERVICESERVICE_EXCEPTION;
        }
        return TEILNEHMERSOAPSERVICESERVICE_WSDL_LOCATION;
    }

}