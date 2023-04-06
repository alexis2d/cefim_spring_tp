package fr.duquenet.alexis.cefimspring.database;

import fr.duquenet.alexis.cefimspring.classes.Product;
import fr.duquenet.alexis.cefimspring.classes.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.duquenet.alexis.cefimspring.feature.database.DatabaseService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class DatabaseTests {

    @Autowired
    private DatabaseService databaseService;
    @Test
    void getProductNameListTest() {
        String expected = "Sloe Gin - Mcguinness";
        List<String> results = databaseService.getProductNameList();
        assertTrue(results.contains(expected));
    }

    @Test
    void getProductListTest() {
        String expected = "Sloe Gin - Mcguinness";
        List<ProductDto> results = databaseService.getProductList();
        assertEquals(results.get(0).getName(), expected);
    }

    boolean testEquality(Product productEntity, ProductDto productDto){
        return Objects.equals(productEntity.getName(), productDto.getName()) && Objects.equals(productEntity.getDescription(), productDto.getDescription())
                && Objects.equals(BigDecimal.valueOf(productEntity.getPrice()), productDto.getPrice());
    }

    @Test
    void testProductFromEntity(){
        ProductDto p1 = new ProductDto(1, "Sloe Gin - Mcguinness", "test desc", BigDecimal.valueOf(97.15));
        ProductDto p2 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));

        List<Product> listProductFromEntity = databaseService.getListProductFromEntity();
        assertTrue(testEquality(listProductFromEntity.get(0), p1) && testEquality(listProductFromEntity.get(1), p2));
    }

    @Test
    void testGetDriedTomatoes(){
        ProductDto p1 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));
        ProductDto oneProduct = databaseService.getOneProduct(p1.getId());
        assert oneProduct.equals(p1);
    }

    @Test
    void testGetDriedTomatoesFromEntity(){
        ProductDto p1 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));
        Product oneProduct = databaseService.getOneProductEntity(p1.getId());
        assert testEquality(oneProduct, p1);
    }

}
