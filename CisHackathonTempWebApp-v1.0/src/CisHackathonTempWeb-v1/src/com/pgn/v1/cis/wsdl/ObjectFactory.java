//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package com.pgn.v1.cis.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.pgn._2010._07.fault.xsd.ServiceFault;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pgn.v1.cis.wsdl package. 
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

    private final static QName _InsertOneClickPaymentFault1ServiceFault_QNAME = new QName("http://www.pgn.com/v1/cis/wsdl", "insertOneClickPaymentFault1_serviceFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pgn.v1.cis.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertOneClickPaymentResponse }
     * 
     */
    public InsertOneClickPaymentResponse createInsertOneClickPaymentResponse() {
        return new InsertOneClickPaymentResponse();
    }

    /**
     * Create an instance of {@link InsertOneClickPayment }
     * 
     */
    public InsertOneClickPayment createInsertOneClickPayment() {
        return new InsertOneClickPayment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pgn.com/v1/cis/wsdl", name = "insertOneClickPaymentFault1_serviceFault")
    public JAXBElement<ServiceFault> createInsertOneClickPaymentFault1ServiceFault(ServiceFault value) {
        return new JAXBElement<ServiceFault>(_InsertOneClickPaymentFault1ServiceFault_QNAME, ServiceFault.class, null, value);
    }

}
