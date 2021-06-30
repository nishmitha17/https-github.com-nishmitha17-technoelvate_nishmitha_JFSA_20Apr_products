package com.te.productweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.productweb.beans.ProductInfoBean;
import com.te.productweb.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;
	
	@Override
	public ProductInfoBean authenticate(int id, String accessType) {
		if(id<=0) {
			return null;
		}else {
			return dao.authenticate(id, accessType);
		}
	}
	
	@Override
	public ProductInfoBean searchProduct(int id) {
		if(id<=0) {
			return null;
		}else {
			return dao.searchProduct(id);
		}
	}

	@Override
	public boolean deleteProduct(int id) {
		if(id<=0) {
			return false;
		}else {
			return dao.deleteProduct(id);
		}
	}

	@Override
	public boolean addProduct(ProductInfoBean product) {
		
		return dao.addProduct(product);
	}

	@Override
	public boolean updateRecord(ProductInfoBean productInfoBean) {
		return dao.updateRecord(productInfoBean);
		
	}

	@Override
	public List<ProductInfoBean> getAllProduct() {
		return dao.getAllProduct();
	}

	

}
