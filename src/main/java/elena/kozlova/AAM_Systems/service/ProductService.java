package elena.kozlova.AAM_Systems.service;

import elena.kozlova.AAM_Systems.dto.ProductDto;
import elena.kozlova.AAM_Systems.entity.Product;
import elena.kozlova.AAM_Systems.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Сервисный слой для упраления сущностью Продукт
 */

@Service
@AllArgsConstructor
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
     * Добавление продукта
     * @param productDto dto
     */
    public void addProduct(ProductDto productDto){
        Product product = convertToProductFromDto(productDto);
        productRepository.save(product);
    }

    /**
     * Удаление продукта
     * @param id идентификатор продукта
     */
    public void removeProduct(Long id){
        productRepository.deleteById(id);
    }

    /**
     * Поиск продукта по вхождению строки в имя продукта
     * @param name поисковая строка
     * @return список продуктов, удовлетворяющих запросу
     */
    @Transactional(readOnly = true)
    public List<Product> findProductByName(String name){
       return productRepository.findByNameContains(name);
    }

    /**
     * Обновление полей продукта
     * @param id идентификатор продукта
     * @param productDto - dto
     */
    public void updateProduct(Long id, ProductDto productDto){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    /**
     * Конвертирует dto в сущность Продукт
     * @param productDto dto
     * @return Product
     */
    public Product convertToProductFromDto(ProductDto productDto){
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .build();
    }

}
