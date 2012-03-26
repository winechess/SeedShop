/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinichenkosa.seedshop.ejb;

import com.vinichenkosa.seedshop.entity.Category;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vinichenkosa
 */
@Local
public interface CategoryFacadeLocal {

    void create(Category category);

    void edit(Category category);

    void remove(Category category);

    Category find(Object id);

    List<Category> findAll();

    List<Category> findRange(int[] range);

    int count();

    List<Category> findRootCategories();
    
}
