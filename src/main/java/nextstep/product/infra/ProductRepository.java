package nextstep.product.infra;

import nextstep.product.domain.Product;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductRepository extends Repository<Product, Long> {

    Product findById(Long id);

    List<Product> findAll();

    Product save(Product product);
}
