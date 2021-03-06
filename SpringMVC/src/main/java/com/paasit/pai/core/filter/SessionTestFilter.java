package com.paasit.pai.core.filter;


import java.io.IOException;    
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class SessionTestFilter implements Filter {  
  
    private  FilterConfig config;  
      
    public void destroy() {  
        // TODO Auto-generated method stub  
         System.out.println("destroy");  
    }  
  
    public void doFilter(ServletRequest arg0, ServletResponse arg1,  
            FilterChain arg2) throws IOException, ServletException {  
        // TODO Auto-generated method stub  
         System.out.println("doFilter");  
           
         HttpServletRequest request=(HttpServletRequest)arg0;  
           
         HttpServletResponse response=(HttpServletResponse)arg1;  
           
         //获取初始化参数  
        String para=config.getInitParameter("nofilterpath");  
        System.out.println(para);  
           
         if(request.getRequestURI().indexOf("login")!=-1||request.getRequestURI().indexOf("Home/userLogin")!=-1)  
         {  
             arg2.doFilter(arg0, arg1);  
             return;  
         }  
           
         if(request.getSession().getAttribute("username")==null)  
         {  
               
            response.sendRedirect(request.getContextPath()+"/Home/login");  
         }  
         else  
         {  
               
             arg2.doFilter(arg0, arg1);  
         }  
           
    }  
  
    public void init(FilterConfig arg0) throws ServletException {  
        // TODO Auto-generated method stub  
        System.out.println("init");  
        config=arg0;  
          
    }  
  
}  