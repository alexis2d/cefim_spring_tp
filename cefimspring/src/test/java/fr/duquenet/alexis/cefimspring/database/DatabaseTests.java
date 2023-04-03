package fr.duquenet.alexis.cefimspring.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.duquenet.alexis.cefimspring.feature.database.DatabaseService;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class DatabaseTests {

    @Autowired
    private DatabaseService databaseService;
    @Test
    void getProductNameListTest() {
        //String expected = "product";
        String expected = "Sloe Gin - Mcguinness";
        List<String> result = databaseService.getProductNameList();
        //List<String> result = List.of(new String[]{"Sloe Gin - Mcguinness", "Sun - Dried Tomatoes"});
        assertTrue(result.contains(expected));
    }

    /*@Test
    void getProductListTest() {

    }*/

}
