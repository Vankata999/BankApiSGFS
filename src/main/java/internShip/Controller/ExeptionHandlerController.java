package internShip.controller;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import internShip.EResponse;
import internShip.EResponse.ResponseStatus;
import internShip.errormessages.ErrorMessage;
import jdk.internal.org.jline.utils.Log;

@ControllerAdvice

public class ExeptionHandlerController {
	
	@ExceptionHandler(ErrorMessage.class)
	public ResponseEntity<String> exception(ErrorMessage excp)
    {
        EResponse resp = new EResponse(null,null,null,null,null,null,null,null);
    
        ResponseStatus st = excp.getStatus();
        String code = excp.getStatus().getCode();
        
		resp.setErrorCode(code);
		resp.setErrorDes(st.toString());
       
        
        return new ResponseEntity(resp ,HttpStatus.NOT_FOUND) ;
    }
}
