package relationaldbs.test;

import relationaldbs.dao.ProductDao;
import relationaldbs.dao.ProductoDaoImpl;
import relationaldbs.model.Producto;

public class ProductoDaoTest {
    public static void main(String[] args) {

        ProductoDaoImpl productoDao = new ProductoDaoImpl();

        productoDao.createTable();

        productoDao.insert(new Producto(1L, "Camiseta", "15.99", 1.0, "Nike", 10));
        System.out.println(productoDao.insert(new Producto(1L, "Camiseta", "15.99", 1.0, "Nike", 10)));

        // System.out.println(productoDao.delete(1L));

        System.out.println(productoDao.update(new Producto(1L, "Camiseta Nueva", "19.99", 2.0, "Adidas", 20)));
        System.out.println(productoDao.find(1L));
        System.out.println(productoDao.findall());
    }
}