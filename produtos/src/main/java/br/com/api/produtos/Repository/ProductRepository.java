package br.com.api.produtos.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.Model.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel  , Long> {
    
}
