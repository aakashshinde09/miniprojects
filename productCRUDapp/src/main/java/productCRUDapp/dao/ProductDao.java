package productCRUDapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productCRUDapp.model.Product;

@Component
public class ProductDao {

	@Autowired	
	private HibernateTemplate hibernateTemplate;
	
	// Method to create a product
	@Transactional
	public void createProduct(Product product) {
		// save or update means if id is available in database then update
		// if id is not available in database then update
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	// get all products
	public List<Product> getProducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	// Delete the single product
	@Transactional
	public void deleteProduct(int pid) {
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
	
	// Get the single product
	
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
	}
}
