//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package com.pgn.v1.cis.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "insertOneClickPaymentResponse", namespace = "http://www.pgn.com/v1/cis/wsdl")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertOneClickPaymentResponse", namespace = "http://www.pgn.com/v1/cis/wsdl")
public class InsertOneClickPaymentResponse {

    @XmlElement(name = "serviceResponse", namespace = "")
    private com.pgn._2010._07.common.xsd.ServiceResponse serviceResponse;

    /**
     * 
     * @return
     *     returns ServiceResponse
     */
    public com.pgn._2010._07.common.xsd.ServiceResponse getServiceResponse() {
        return this.serviceResponse;
    }

    /**
     * 
     * @param serviceResponse
     *     the value for the serviceResponse property
     */
    public void setServiceResponse(com.pgn._2010._07.common.xsd.ServiceResponse serviceResponse) {
        this.serviceResponse = serviceResponse;
    }

}