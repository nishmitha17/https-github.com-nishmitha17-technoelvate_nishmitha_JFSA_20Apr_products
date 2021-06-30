package com.te.productweb.service;

import com.te.productweb.beans.ProductInfoBean;
import java.util.List;
public interface ProductService {
	  public ProductInfoBean searchProduct(int id);

	public ProductInfoBean authenticate(int id, String accessType);
	public boolean deleteProduct(int id);

	public boolean addProduct(ProductInfoBean product);

	boolean updateRecord(ProductInfoBean productInfoBean);
	List<ProductInfoBean> getAllProduct();
	  
}
