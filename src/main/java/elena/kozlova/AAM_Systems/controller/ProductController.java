package elena.kozlova.AAM_Systems.controller;

import elena.kozlova.AAM_Systems.dto.ProductDto;
import elena.kozlova.AAM_Systems.entity.Product;
import elena.kozlova.AAM_Systems.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для CRUD - операций с сущностью Продукт
 */

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    /**
     * Добавление продукта
     * @param productDto dto
     */
    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    }

    /**
     * Удаление продукта
     * @param id идентификатор продукта
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.removeProduct(id);
    }

    /**
     * Поиск продукта по вхождению строки в имя продукта
     * @param name поисковая строка
     * @return список продуктов, удовлетворяющих запросу
     */
    @GetMapping
    public List<Product> findProductByName(@RequestParam String name){
        return productService.findProductByName(name);
    }

    /**
     * Обновление полей продукта
     * @param id идентификатор продукта
     * @param productDto - dto
     */
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        productService.updateProduct(id, productDto);
    }
}
