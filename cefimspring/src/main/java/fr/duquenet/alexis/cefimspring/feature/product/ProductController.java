package fr.duquenet.alexis.cefimspring.feature.product;

import fr.duquenet.alexis.cefimspring.classes.Product;
import fr.duquenet.alexis.cefimspring.classes.ProductDto;
import fr.duquenet.alexis.cefimspring.feature.database.DatabaseService;
import fr.duquenet.alexis.cefimspring.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private DatabaseService databaseService;
    @PostMapping("")
    public Product insertNewProduct(@RequestBody Product product){
        ResponseEntity.status(HttpStatus.CONFLICT).body("Product with name table already exists");
        return productService.insertNewProduct(product);
    }

    @RequestMapping(value = "/id/{id}",method=RequestMethod.DELETE)
    public void deleteNewProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
    }

    @RequestMapping(value = "/byName",method=RequestMethod.DELETE)
    public void deleteNewProduct(@RequestParam("name") String name){
        ProductDto product = databaseService.getProductByName(name).get(0);
        productService.deleteProduct(product.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Integer id){
        try{
            return ResponseEntity.ok(productService.updateProduct(id, product));
        } catch (EntityNotFoundException notFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (ConstraintViolationException constraintViolationException){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
