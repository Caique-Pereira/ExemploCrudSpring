package br.com.api.produtos.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.Model.ExceptionsProduct;
import br.com.api.produtos.Model.ProductModel;
import br.com.api.produtos.Repository.ProductRepository;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ExceptionsProduct exceptionsProduct;

    public Iterable<ProductModel> listAll(){
       return productRepository.findAll();
    }

    public ResponseEntity<?> insertProduct(ProductModel pm) {
         if(pm.getName().equals("")){
            exceptionsProduct.setMessage("Invalid Product Name");
            return new ResponseEntity<ExceptionsProduct>(exceptionsProduct, HttpStatus.BAD_REQUEST );
        }else{
           return new ResponseEntity<ProductModel>( productRepository.save(pm)  , HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> updateProduct(ProductModel pm) {
        if(pm.getName().equals("")){
           exceptionsProduct.setMessage("Invalid Product Name");
           return new ResponseEntity<ExceptionsProduct>(exceptionsProduct, HttpStatus.BAD_REQUEST );
       }else{
          return new ResponseEntity<ProductModel>( productRepository.save(pm)  , HttpStatus.OK);
       }
   }

   public ResponseEntity<ExceptionsProduct> deleteProduct(Long id){
     productRepository.deleteById(id);
     exceptionsProduct.setMessage("The product has been deleted");
     return new ResponseEntity<ExceptionsProduct>(exceptionsProduct, HttpStatus.OK);

   }

    


}