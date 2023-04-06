package fr.duquenet.alexis.cefimspring.feature.product;

import fr.duquenet.alexis.cefimspring.classes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("")
    public Product insertNewProduct(@RequestBody Product product){
        ResponseEntity.status(HttpStatus.CONFLICT).body("Product with name table already exists");
        return productService.insertNewProduct(product);
    }

    @DeleteMapping("/:productId")
    public void deleteNewProduct(@PathVariable("id") Integer productId){
        productService.deleteProduct(productId);
    }

    @DeleteMapping("")
    public void deleteNewProduct(@RequestParam("name") String productName){
        //
    }

}
