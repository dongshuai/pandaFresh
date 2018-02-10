package com.pf.app.api.util.edit;

import java.math.BigDecimal;

/**
 * 类说明: Number handle utils<br> 
 * 创建时间: 2007-10-4 下午05:08:48<br> 
 *  
 * @author Seraph<br> 
 * @email: seraph@gmail.com<br> 
 */  
public class NumberUtils {  
      
    public static int parseInt(String s){
        return Integer.valueOf(s.trim()).intValue();
    }  
      
    public static long parseLong(String s) {  
        return Long.parseLong(s.trim());  
    }  
      
    public static BigDecimal getBigDecimal(String s) {
        return BigDecimal.valueOf(Long.parseLong(s.trim()));  
    }  
      
}  
