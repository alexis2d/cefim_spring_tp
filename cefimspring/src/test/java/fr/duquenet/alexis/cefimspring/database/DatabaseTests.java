package fr.duquenet.alexis.cefimspring.database;

import fr.duquenet.alexis.cefimspring.classes.Product;
import fr.duquenet.alexis.cefimspring.classes.ProductDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private EntityManager entityManager;
    private Logger logger = LoggerFactory.getLogger(DatabaseTests.class);

    @Test
    void testDatabase(){
        Query query = entityManager.createNativeQuery("show tables;");
        List<String> results = ((List<String>) query.getResultList());
        String resultList = String.join(" - ", results);
        logger.info("Connexion à la BDD :: SUCCESS");
        logger.info("Table list of databases = [{}]", resultList);
    }

}
