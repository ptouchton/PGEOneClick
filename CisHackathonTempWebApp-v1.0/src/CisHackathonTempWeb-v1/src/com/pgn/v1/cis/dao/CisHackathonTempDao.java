package com.pgn.v1.cis.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;

import com.pgn._2010._07.common.xsd.ServiceResponse;
import com.pgn._2010._07.fault.xsd.ServiceFault;
import com.pgn.util.logging.PGELogger;
import com.pgn.utils.DateUtils;
import com.pgn.utils.dataaccess.DataAccessException;
import com.pgn.utils.dataaccess.PGEDataAccess;
import com.pgn.v1.cis.wsdl.InsertOneClickPaymentServiceFaultMsg;

public class CisHackathonTempDao {

	private static PGELogger logger;
	static {
		logger = PGELogger.getLogger(CisHackathonTempDao.class.getName());

	}

	protected static final String INSERT_ONE_CLICK = "{?=call OL_PAYMENT_PKG.InsertOneClickPayment(?,?,?,?,?,?)}";
	protected static final int INSERT_ONE_CLICK_RESULT_OUT 					= 1;
	protected static final int INSERT_ONE_CLICK_CUST_CODE_IN 				= 2;
	protected static final int INSERT_ONE_CLICK_PREM_CODE_IN 				= 3;
	protected static final int INSERT_ONE_CLICK_PAYMENT_AMOUNT_IN 			= 4;
	protected static final int INSERT_ONE_CLICK_PAYMENT_DATE_IN 			= 5;
	protected static final int INSERT_ONE_CLICK_ERROR_CODE_OUT 				= 6;
	protected static final int INSERT_ONE_CLICK_ERROR_MSG_OUT 				= 7;

	private static final String SERVICE_FAULT = ServiceFault.class.getSimpleName();

	private PGEDataAccess cisDataAccess = null;
	private CallableStatement callable = null;

	public CisHackathonTempDao(DataSource cisDataSource) {
		cisDataAccess = new PGEDataAccess(cisDataSource);	
	}

	//Used for testing, so that the dataAccess can be mocked
	protected CisHackathonTempDao(PGEDataAccess dataAccess) {
		cisDataAccess = dataAccess;
	}

	public ServiceResponse insertOneClickPayment(Integer customerCode, String premiseCode, Float paymentAmount, XMLGregorianCalendar paymentDate) throws InsertOneClickPaymentServiceFaultMsg { 
		{
			if (customerCode == null||customerCode == 0) {
				String errorMessage = "The CustomerCode must contain a valid value.";
				logger.error(errorMessage);
				ServiceFault fault = new ServiceFault();
				fault.setReason(errorMessage);
				throw new InsertOneClickPaymentServiceFaultMsg(SERVICE_FAULT, fault);
			}

			if (premiseCode == null ||premiseCode.trim() == "") {
				String errorMessage = "The PremiseCode must contain a valid value.";
				logger.error(errorMessage);
				ServiceFault fault = new ServiceFault();
				fault.setReason(errorMessage);
				throw new InsertOneClickPaymentServiceFaultMsg(SERVICE_FAULT, fault);
			}

			ServiceResponse response = new ServiceResponse();

			try{
				boolean retryable = true;
				while (retryable) {
					try {
						callable = cisDataAccess.getStatement(INSERT_ONE_CLICK);
						callable.registerOutParameter(INSERT_ONE_CLICK_RESULT_OUT,Types.NUMERIC);
						callable.setInt(INSERT_ONE_CLICK_CUST_CODE_IN, customerCode);
						callable.setString(INSERT_ONE_CLICK_PREM_CODE_IN, premiseCode.toString());
						callable.setFloat(INSERT_ONE_CLICK_PAYMENT_AMOUNT_IN, paymentAmount);
						callable.setDate(INSERT_ONE_CLICK_PAYMENT_DATE_IN,DateUtils.ConvertCalToSQLDate(paymentDate.toGregorianCalendar())); 
						callable.registerOutParameter(INSERT_ONE_CLICK_ERROR_CODE_OUT, Types.VARCHAR);
						callable.registerOutParameter(INSERT_ONE_CLICK_ERROR_MSG_OUT, Types.VARCHAR);               

						cisDataAccess.executeQuery(INSERT_ONE_CLICK_ERROR_MSG_OUT, false);    
						retryable = false;
					} 
					catch (SQLException e) {
						retryable = cisDataAccess.isRetryable(e);
						if (!retryable) {
							throw new DataAccessException(e);
						}
					}
				}

				int result=callable.getInt(INSERT_ONE_CLICK_RESULT_OUT);
				// Expecting: 0 = success
				//			  -1 = failure
				if(result == 0) {
					response.setResult(true);
					logger.info("A sucessful response was returned from the OL_PAYMENT_PKG.InsertOneClick call for: " + customerCode + "-" + premiseCode.toString());
				}else{ 
					response.setResult(false);
					response.setFailureCode(callable.getString(INSERT_ONE_CLICK_ERROR_CODE_OUT));
					response.setFailureDescription(callable.getString(INSERT_ONE_CLICK_ERROR_MSG_OUT));
				}
			}catch (Exception e) {
				String errorMessage = "An Exception was caught when executing OL_PAYMENT_PKG.InsertOneClick call for: " + customerCode + "-" + premiseCode.toString() + ". Error message: " + e.getMessage();
				logger.error(errorMessage);
				throw new DataAccessException(errorMessage);
			} finally {
				cisDataAccess.closeResources();
			}

			return response;
		}

	}


}
