package com.pgn.v1.cis.wsdl;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;
import com.pgn._2010._07.common.xsd.ServiceResponse;
import com.pgn._2010._07.fault.xsd.ServiceFault;
import com.pgn.v1.cis.dao.CisHackathonTempDao;


@javax.jws.WebService (endpointInterface="com.pgn.v1.cis.wsdl.CisHackathonService", targetNamespace="http://www.pgn.com/v1/cis/wsdl", serviceName="CisHackathonServiceService", portName="CisHackathonServicePort", wsdlLocation="WEB-INF/wsdl/wsdl/v1/CisHackathonServiceService.wsdl")
public class CisHackathonServiceBindingImpl{

	@Resource(name="jdbc/cis")

	private static DataSource cisDataSource;
	
	private CisHackathonTempDao dao;	
	
	private static final String SERVICE_FAULT = ServiceFault.class.getSimpleName();
	
	public CisHackathonServiceBindingImpl() {
		super();
		dao = new CisHackathonTempDao(cisDataSource);
	}
	
	CisHackathonServiceBindingImpl(CisHackathonTempDao dao) {
		super();
		this.dao = dao;
	}
   	
    public ServiceResponse insertOneClickPayment(Integer customerCode, String premiseCode, Float paymentAmount, XMLGregorianCalendar paymentDate) throws InsertOneClickPaymentServiceFaultMsg {
		try {
        	return dao.insertOneClickPayment(customerCode, premiseCode, paymentAmount, paymentDate);
		} catch (RuntimeException e) {
			ServiceFault fault = new ServiceFault();
			fault.setReason(e.getMessage() == null?e.getClass().getName():e.getMessage());
			throw new InsertOneClickPaymentServiceFaultMsg(SERVICE_FAULT, fault, e);
		}
    }
}