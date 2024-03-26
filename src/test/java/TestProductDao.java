import com.ITFactory.dao.ProductDao;
import com.ITFactory.model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestProductDao {
    ProductDao productDao = new ProductDao();
    Product testProduct1 = new Product("T-Shirt", 35, 3);
    Product testProduct2 = new Product("Jacket", 120, 5);

    @Before
    public void testsWarmup() {
        System.out.println("===Warmup===");
        System.out.println(" ");
        if (productDao.retrieveAllProducts().isEmpty()) {
            productDao.addNewProduct(testProduct1);
        } else {
            productDao.retrieveAllProducts().clear();
            for (int i = 0; i <= productDao.retrieveAllProducts().size(); i++) {
                productDao.removeProduct(productDao.retrieveAllProducts().getFirst());
            }
            assertEquals(0, productDao.retrieveAllProducts().size());
            productDao.addNewProduct(testProduct1);
        }
        System.out.println(" ");
    }

    @Test
    public void addNewProductPositive() {
        productDao.addNewProduct(testProduct2);
        assertEquals(2, productDao.retrieveAllProducts().size());
        System.out.println(" ");
    }

    @Test
    public void addNewProductNegative() {
        productDao.addNewProduct(testProduct2);
        assertNotEquals(1, productDao.retrieveAllProducts().size());
        System.out.println(" ");

    }

    @Test
    public void updateProductPricePositive() {
        productDao.updateProductPrice(testProduct1, 26);
        assertEquals(26, productDao.retrieveAllProducts().getFirst().getProductPrice(), 0);
        System.out.println(" ");
    }

    @Test
    public void updateProductPriceNegative() {
        productDao.updateProductPrice(testProduct1, 15);
        assertNotEquals(35, productDao.retrieveAllProducts().getFirst().getProductPrice(), 0);
        System.out.println(" ");
    }

    @Test
    public void removeProductPositive() {
        productDao.removeProduct(testProduct1);
        assertEquals(0, productDao.retrieveAllProducts().size());
        System.out.println(" ");
    }

    @Test
    public void removeProductNegative() {
        productDao.removeProduct(testProduct1);
        assertNotEquals(1, productDao.retrieveAllProducts().size());
        System.out.println(" ");
    }

    @After
    public void testsCleanup() {
        System.out.println("===Cleanup===");
        System.out.println(" ");
        if (!productDao.retrieveAllProducts().isEmpty()) {
            productDao.removeProduct(testProduct1);
            productDao.removeProduct(testProduct2);
        }
    }
}
