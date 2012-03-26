/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinichenkosa.seedshop.converter;

import com.vinichenkosa.seedshop.ejb.CategoryFacadeLocal;
import com.vinichenkosa.seedshop.entity.Category;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author vinichenkosa
 */
@ManagedBean
@RequestScoped
public class CategoryConverter implements Converter{

    @EJB
    private CategoryFacadeLocal facade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.equals("")) return null;
        return facade.find(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Category)value).getId());
    }
    
}
