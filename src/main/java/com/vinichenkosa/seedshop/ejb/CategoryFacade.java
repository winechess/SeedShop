/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinichenkosa.seedshop.ejb;

import com.vinichenkosa.seedshop.entity.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vinichenkosa
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeLocal {
    @PersistenceContext(unitName = "com.vinichenkosa_SeedShop_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }

    @Override
    public List<Category> findRootCategories() {
        return em.createNamedQuery("Category.findRootCategories").getResultList();
    }
}
