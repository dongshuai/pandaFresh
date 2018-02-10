package com.pf.app.api.util.edit;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * BigDecimal
 */
public class IntegerEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {  
        if (StringUtils.isEmpty(text)) {
            setValue(null);  
        } else {  
            setValue(NumberUtils.parseInt(text));
        }  
    }  
}  