
package com.exxeta.ejb.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.exxeta.ejb.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindAllTeilnehmer_QNAME = new QName("http://ejb.exxeta.com/", "findAllTeilnehmer");
    private final static QName _FindAllTeilnehmerResponse_QNAME = new QName("http://ejb.exxeta.com/", "findAllTeilnehmerResponse");
    private final static QName _FindTeilnehmerByIdResponse_QNAME = new QName("http://ejb.exxeta.com/", "findTeilnehmerByIdResponse");
    private final static QName _FindTeilnehmerById_QNAME = new QName("http://ejb.exxeta.com/", "findTeilnehmerById");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.exxeta.ejb.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAllTeilnehmerResponse }
     * 
     */
    public FindAllTeilnehmerResponse createFindAllTeilnehmerResponse() {
        return new FindAllTeilnehmerResponse();
    }

    /**
     * Create an instance of {@link FindTeilnehmerByIdResponse }
     * 
     */
    public FindTeilnehmerByIdResponse createFindTeilnehmerByIdResponse() {
        return new FindTeilnehmerByIdResponse();
    }

    /**
     * Create an instance of {@link FindTeilnehmerById }
     * 
     */
    public FindTeilnehmerById createFindTeilnehmerById() {
        return new FindTeilnehmerById();
    }

    /**
     * Create an instance of {@link FindAllTeilnehmer }
     * 
     */
    public FindAllTeilnehmer createFindAllTeilnehmer() {
        return new FindAllTeilnehmer();
    }

    /**
     * Create an instance of {@link Teilnehmer }
     * 
     */
    public Teilnehmer createTeilnehmer() {
        return new Teilnehmer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllTeilnehmer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.exxeta.com/", name = "findAllTeilnehmer")
    public JAXBElement<FindAllTeilnehmer> createFindAllTeilnehmer(FindAllTeilnehmer value) {
        return new JAXBElement<FindAllTeilnehmer>(_FindAllTeilnehmer_QNAME, FindAllTeilnehmer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllTeilnehmerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.exxeta.com/", name = "findAllTeilnehmerResponse")
    public JAXBElement<FindAllTeilnehmerResponse> createFindAllTeilnehmerResponse(FindAllTeilnehmerResponse value) {
        return new JAXBElement<FindAllTeilnehmerResponse>(_FindAllTeilnehmerResponse_QNAME, FindAllTeilnehmerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTeilnehmerByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.exxeta.com/", name = "findTeilnehmerByIdResponse")
    public JAXBElement<FindTeilnehmerByIdResponse> createFindTeilnehmerByIdResponse(FindTeilnehmerByIdResponse value) {
        return new JAXBElement<FindTeilnehmerByIdResponse>(_FindTeilnehmerByIdResponse_QNAME, FindTeilnehmerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTeilnehmerById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.exxeta.com/", name = "findTeilnehmerById")
    public JAXBElement<FindTeilnehmerById> createFindTeilnehmerById(FindTeilnehmerById value) {
        return new JAXBElement<FindTeilnehmerById>(_FindTeilnehmerById_QNAME, FindTeilnehmerById.class, null, value);
    }

}
