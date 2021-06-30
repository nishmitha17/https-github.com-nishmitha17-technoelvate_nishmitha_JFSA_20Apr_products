package com.te.productweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;

import com.te.productweb.beans.ProductInfoBean;

@Repository
public class ProductHibernateImpl implements ProductDao{

	@Override
	public ProductInfoBean authenticate(int id, String accesstype) {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		try {
			factory=Persistence.createEntityManagerFactory("emsPeristenceUnit");
		    manager=factory.createEntityManager();
		    ProductInfoBean product=manager.find(ProductInfoBean.class, id);
		    if(product.getAccessType().equalsIgnoreCase(accesstype)) {
				return product;
			}else {
				return null;
			}
	} 
		    catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		}
				
		return null;
	}

	@Override
	public ProductInfoBean searchProduct(int id) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		try {
			factory=Persistence.createEntityManagerFactory("emsPeristenceUnit");
		    manager=factory.createEntityManager();
		    ProductInfoBean product=manager.find(ProductInfoBean.class, id);
		    if(product!=null) {
				return product;
			}else {
				return null;
			}
	} 
		    catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		}
				
		return null;
	}

	@Override
	public boolean deleteProduct(int id) {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		boolean deleted=false;
		EntityTransaction transaction=null;
		try {
			factory=Persistence.createEntityManagerFactory("emsPeristenceUnit");
		    manager=factory.createEntityManager();
		    transaction=manager.getTransaction();
		    transaction.begin();
		    ProductInfoBean product=manager.find(ProductInfoBean.class, id);
		    if(product!=null) {
		    	 manager.remove(product);
		    	 deleted=true;
		    }
		    transaction.commit();
	} 
		    catch (Exception e) {
		    	transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		}
				
		return deleted;
	}

	@Override
	public boolean addProduct(ProductInfoBean product) {
		boolean isInserted = false;
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			
			transaction.begin();
			manager.persist(product);
			transaction.commit();
			isInserted = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isInserted;
	
	}
	@Override
	public boolean updateRecord(ProductInfoBean productInfoBean) {
		boolean isUpdated = false;

		EntityManagerFactory factory=Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			
			ProductInfoBean actualInfo = manager.find(ProductInfoBean.class,productInfoBean.getId());

			if (productInfoBean.getPname() != null && productInfoBean.getPname() != "") {
				actualInfo.setPname(productInfoBean.getPname());
			}

			if (productInfoBean.getMyDate()!= null) {
				actualInfo.setMyDate(productInfoBean.getMyDate());
			}
			if (productInfoBean.getExDate()!= null) {
				actualInfo.setExDate(productInfoBean.getExDate());
			}
			if (productInfoBean.getPrice()!= 0) {
				actualInfo.setPrice(productInfoBean.getPrice());
			}
			if (productInfoBean.getQuantity()!= 0) {
				actualInfo.setQuantity(productInfoBean.getQuantity());
			}
			if (productInfoBean.getAccessType()!= null && productInfoBean.getAccessType() != "") {
				actualInfo.setAccessType(productInfoBean.getAccessType());
			}
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isUpdated;
	}

	
	@Override
	public List<ProductInfoBean> getAllProduct() {


		EntityManagerFactory factory=Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from ProductInfoBean");
		ArrayList<ProductInfoBean> productInfoBeans = new ArrayList<ProductInfoBean>();
		try {
			productInfoBeans = (ArrayList<ProductInfoBean>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			productInfoBeans = null;
		}

		return productInfoBeans;
	}

}
