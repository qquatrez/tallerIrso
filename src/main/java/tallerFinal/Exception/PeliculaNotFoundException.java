package tallerFinal.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PeliculaNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionDetail;
    private Object fieldValue;
    
    public PeliculaNotFoundException (String exceptionDetail, Integer fieldValue) {
    	
    	super(exceptionDetail+" - "+fieldValue);
        this.exceptionDetail = exceptionDetail;
        this.fieldValue = fieldValue;
    }
    public String getExceptionDetail() {
        return exceptionDetail;
    }
    public Object getFieldValue() {
        return fieldValue;
    }
    

}
