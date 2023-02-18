package br.com.api.produtos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.Model.ExceptionsProduct;
import br.com.api.produtos.Model.ProductModel;
import br.com.api.produtos.Services.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

 
   @Autowired
   private ProductService productService;

   @GetMapping("/list") 
    public Iterable<ProductModel> listAll(){
        return  productService.listAll();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductModel pm){
        return productService.updateProduct(pm);
    }

    @PostMapping("/register")
    public ResponseEntity<?> insertProduct(@RequestBody ProductModel pm){
        return productService.insertProduct(pm);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ExceptionsProduct> insertProduct(@PathVariable  Long id){
        return productService.deleteProduct(id);
    }
   
}
