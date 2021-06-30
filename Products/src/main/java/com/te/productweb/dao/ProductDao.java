package com.te.productweb.dao;

import java.util.List;

import com.te.productweb.beans.ProductInfoBean;

public interface ProductDao {
  public ProductInfoBean authenticate(int id,String accesstype);
  public ProductInfoBean searchProduct(int id);
  public boolean deleteProduct(int id);
public boolean addProduct(ProductInfoBean product);
boolean updateRecord(ProductInfoBean productInfoBean);
List<ProductInfoBean> getAllProduct();
  
}
