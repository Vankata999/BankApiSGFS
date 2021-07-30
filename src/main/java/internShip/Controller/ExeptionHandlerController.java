package internShip.controller;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import internShip.EResponse;
import internShip.EResponse.ResponseStatus;
import internShip.errormessages.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@ControllerAdvice

public class ExeptionHandlerController {
	
	@ExceptionHandler(value = {ErrorMessage.class})
	public ResponseEntity exception(ErrorMessage excp)
    {
		log.error("Exceptions->"+ excp.getStatus());
        EResponse resp = new EResponse( null,null,null,null,null,null,null,null);
    
        if(HttpStatus.valueOf(null)!=HttpStatus.OK)
        {
        	ResponseStatus st = excp.getStatus();
        	String code = excp.getStatus().G_ERROR.getCode();
        	resp.setErrorCode(code);
        	resp.setErrorDes(st.toString());

            return new ResponseEntity(resp ,HttpStatus.OK) ;

        }
        else {
        ResponseStatus st = excp.getStatus() ;
        String code = excp.getStatus().getCode();
		resp.setErrorCode(code);
		resp.setErrorDes(st.toString());
       
        
        return new ResponseEntity(resp ,HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }
	

	
}
