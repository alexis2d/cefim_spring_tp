package fr.duquenet.alexis.cefimspring.database;

import fr.duquenet.alexis.cefimspring.classes.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.duquenet.alexis.cefimspring.feature.database.DatabaseService;
import java.util.List;

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
        List<Product> results = databaseService.getProductList();
        assertEquals(results.get(0).getName(), expected);
    }

}
