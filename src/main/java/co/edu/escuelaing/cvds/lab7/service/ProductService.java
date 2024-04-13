package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class ProductService {

    private EntityManager entityManager;

    public ProductService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Product createProduct(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
        return product;
    }

    public Product getProductById(String productId) {
        return entityManager.find(Product.class, productId);
    }

    public List<Product> getAllProducts() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public Product updateProduct(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(product);
        transaction.commit();
        return product;
    }

    public void deleteProduct(String productId) {
        Product product = entityManager.find(Product.class, productId);
        if (product != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(product);
            transaction.commit();
        }
    }

    public void close() {
        entityManager.close();
    }

    public Product partialUpdateProduct(String id, Product product) {
        Product existingProduct = entityManager.find(Product.class, id);

        if (existingProduct != null) {
            if (product.getDescription() != null) {
                existingProduct.setDescription(product.getDescription());
            }
            if (product.getCategory() != 0) {
                existingProduct.setCategory(product.getCategory());
            }
            if (product.getRating() != 0) {
                existingProduct.setRating(product.getRating());
            }
            if (product.getPrice() != 0) {
                existingProduct.setPrice(product.getPrice());
            }
            if (product.getQuantity() != 0) {
                existingProduct.setQuantity(product.getQuantity());
            }

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(existingProduct);
            transaction.commit();

            return existingProduct;
        } else {
            return null;
        }
    }

}
