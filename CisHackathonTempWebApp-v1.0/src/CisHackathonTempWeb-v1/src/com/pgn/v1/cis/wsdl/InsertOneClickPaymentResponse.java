//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package com.pgn.v1.cis.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.pgn._2010._07.common.xsd.ServiceResponse;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceResponse" type="{http://www.pgn.com/2010/07/common/xsd}ServiceResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceResponse"
})
@XmlRootElement(name = "insertOneClickPaymentResponse")
public class InsertOneClickPaymentResponse {

    @XmlElement(required = true, nillable = true)
    protected ServiceResponse serviceResponse;

    /**
     * Gets the value of the serviceResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceResponse }
     *     
     */
    public ServiceResponse getServiceResponse() {
        return serviceResponse;
    }

    /**
     * Sets the value of the serviceResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceResponse }
     *     
     */
    public void setServiceResponse(ServiceResponse value) {
        this.serviceResponse = value;
    }

}
