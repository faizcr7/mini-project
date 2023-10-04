package model;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *
 * @author faiz
 */
public interface ModelInterface{
    public void doBusiness(HttpServletRequest request,HttpServletResponse response,ServletContext ctx);
    
}
