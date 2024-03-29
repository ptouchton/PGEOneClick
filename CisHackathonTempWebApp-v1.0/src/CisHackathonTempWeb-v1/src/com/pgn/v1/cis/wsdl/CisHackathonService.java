//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package com.pgn.v1.cis.wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.pgn._2010._07.common.xsd.ServiceResponse;

@WebService(name = "CisHackathonService", targetNamespace = "http://www.pgn.com/v1/cis/wsdl")
@XmlSeeAlso({
    com.pgn._2010._07.fault.xsd.ObjectFactory.class,
    com.pgn._2010._07.common.xsd.ObjectFactory.class,
    com.pgn.v1.cis.wsdl.ObjectFactory.class
})
public interface CisHackathonService {


    /**
     * 
     * @param paymentDate
     * @param customerCode
     * @param paymentAmount
     * @param premiseCode
     * @return
     *     returns com.pgn._2010._07.common.xsd.ServiceResponse
     * @throws InsertOneClickPaymentServiceFaultMsg
     */
    @WebMethod(action = "http://www.pgn.com/v1/cis/wsdl/insertOneClickPayment")
    @WebResult(name = "serviceResponse", targetNamespace = "")
    @RequestWrapper(localName = "insertOneClickPayment", targetNamespace = "http://www.pgn.com/v1/cis/wsdl", className = "com.pgn.v1.cis.wsdl.InsertOneClickPayment")
    @ResponseWrapper(localName = "insertOneClickPaymentResponse", targetNamespace = "http://www.pgn.com/v1/cis/wsdl", className = "com.pgn.v1.cis.wsdl.InsertOneClickPaymentResponse")
    public ServiceResponse insertOneClickPayment(
        @WebParam(name = "customerCode", targetNamespace = "")
        Integer customerCode,
        @WebParam(name = "premiseCode", targetNamespace = "")
        String premiseCode,
        @WebParam(name = "paymentAmount", targetNamespace = "")
        Float paymentAmount,
        @WebParam(name = "paymentDate", targetNamespace = "")
        XMLGregorianCalendar paymentDate)
        throws InsertOneClickPaymentServiceFaultMsg
    ;

}
