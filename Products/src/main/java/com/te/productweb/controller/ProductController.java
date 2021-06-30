package com.te.productweb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.productweb.beans.ProductInfoBean;
import com.te.productweb.dao.ProductDao;
import com.te.productweb.service.ProductService;

@Controller
public class ProductController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("init Binder");
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
    @Autowired
	private ProductService service;
	@GetMapping("/login")
	public String getProductForm() {
		return "productLogin";
	}
	
	@PostMapping("/login")
	public String getProductData(int id,String accessType,HttpServletRequest request,ModelMap map) {
		ProductInfoBean product=service.authenticate(id,accessType);
        
		if(product!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("loggedIn", product);
			return "productHome";		
		}
		else {
			map.addAttribute("errMsg", "Invalid Credential");
			return "productLogin";
		}
		
	}
	
	@GetMapping("/searchproduct")
	public String searchProduct(HttpSession session,ModelMap map) {
		ProductInfoBean product=(ProductInfoBean) session.getAttribute("loggedIn");
		
		if(product!=null) {
			return "searchProduct";	
		}else {
			map.addAttribute("errMsg","Please login");
			return "productLogin";
		}
		//get search page
		
	}
	
	@GetMapping("/search")
	public String getSearchProduct(int id,@SessionAttribute(name="loggedIn",required = false) ProductInfoBean product,ModelMap map) {
		if(product!=null) {
			ProductInfoBean pi=service.searchProduct(id);
			if(pi!=null) {
				System.out.println(pi);
				map.addAttribute("product",product);
	          	return "displaySearchProduct";	
			}else {
			map.addAttribute("errMsg","Invalid Id");
			return "searchProduct";
		}
		}
		else {
			map.addAttribute("errMsg","Please login ");
				return "productLogin";
			}
		
	}
	
	@GetMapping("/logout")
	public String getLout(HttpSession session,ModelMap map) {
		map.addAttribute("msg","Logout successfully");
		session.invalidate();
		return "productLogin";
	}
	
	@GetMapping("/deleteProductData")
	public String getDeletedData(@SessionAttribute(name="loggedIn",required = false) ProductInfoBean product,ModelMap map) {

		if(product!=null) {
			return "deleteProduct";	
		}else {
			map.addAttribute("errMsg","Please login");
			return "productLogin";
		}
		
	}//get search page
	
	@GetMapping("/delete")
	public String deleteData(int id,@SessionAttribute(name="loggedIn",required = false) ProductInfoBean product,ModelMap map) {
		if (product != null) {
			System.out.println("hello");
			if (service.deleteProduct(id)) {
				map.addAttribute("msg", "Data Deleted successfully for id : " + id);
			} else {
				map.addAttribute("msg", "Could not find Record for id : " + id);
			}
			return "deleteProduct";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}
		
	}
	
	@GetMapping("/addproduct")
	public String getAddFrom(@SessionAttribute(name = "loggedIn", required = false) ProductInfoBean product,
			ModelMap map) {
		if (product != null) {
			return "insertProduct";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "productLogin";
		}

	}
	
	@PostMapping("/add")
	public String addProduct(ProductInfoBean productData,
			@SessionAttribute(name = "loggedIn", required = false) ProductInfoBean product, ModelMap map) {
		System.out.println(productData.getId());
		if (product != null) {
			if (service.addProduct(product)) {
				map.addAttribute("msg", "Successfully Inserted");
			} else {
				map.addAttribute("msg", "Failed to Insert");
			}
			return "insertProduct";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "productLogin";
		}

	}// add Product
	
	@GetMapping("/updateProduct")
	public String getUpadatePage(@SessionAttribute(name = "loggedIn", required = false)ProductInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			map.addAttribute("id", infoBean);
			return "updateProduct";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "productLogin";

		}
	}//

	@PostMapping("/update")
	public String updateEmployeeData(@SessionAttribute(name = "loggedIn", required = false) ProductInfoBean infoBean,
			ModelMap map, ProductInfoBean product) {
		if (infoBean != null) {
			if (service.updateRecord(product)) {
				map.addAttribute("msg", "Updated Successfully");
				map.addAttribute("id", product);
			} else {
				map.addAttribute("msg", "Updation Failed");
				map.addAttribute("id", infoBean);
			}
			return "updateProduct";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "productLogin";
		}
	}//

	@GetMapping("/getAll")
	public String getAllRecords(@SessionAttribute(name = "loggedIn", required = false) ProductInfoBean 
		infoBean	,
			ModelMap map) {
		if (infoBean != null) {
			List< ProductInfoBean > product = service.getAllProduct();
			if (product != null) {
				
				map.addAttribute("infos", product);
			}else {
				map.addAttribute("errMsg", "No Records Found");
			}
			return "productHome";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "productLogin";
		}
	}

}


