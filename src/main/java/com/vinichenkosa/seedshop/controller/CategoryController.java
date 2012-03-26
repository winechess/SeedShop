/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinichenkosa.seedshop.controller;

import com.vinichenkosa.seedshop.ejb.CategoryFacadeLocal;
import com.vinichenkosa.seedshop.entity.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author vinichenkosa
 */
@Named(value = "categoryController")
@Dependent
@Stateless
public class CategoryController {

    private String title;
    private String description;
    private Category parentCategory;
    @Inject
    private CategoryFacadeLocal facade;

    /**
     * Creates a new instance of CategoryController
     */
    public CategoryController() {
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryFacadeLocal getFacade() {
        return facade;
    }

    public void setFacade(CategoryFacadeLocal facade) {
        this.facade = facade;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getRootCategories(){
        return facade.findRootCategories();
    }
    
    public List<Category> getAllCategories(){
        return facade.findAll();
    }

    public String createCategory(){
        Category cat = new Category();
        cat.setTitle(title);
        cat.setDescription(description);
        cat.setParentCategory(parentCategory);
        facade.create(cat);
        return "list";
    }

}
