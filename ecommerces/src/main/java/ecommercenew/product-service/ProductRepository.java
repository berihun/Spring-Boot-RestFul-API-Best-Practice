package ecommercenew.productservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ecommercenew.productservice.Product, Long> {
}
