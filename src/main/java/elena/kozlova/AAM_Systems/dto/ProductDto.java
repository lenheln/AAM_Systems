package elena.kozlova.AAM_Systems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Dto для сущности Продукт
 */
@AllArgsConstructor
@Getter
public class ProductDto {
    private String name;
    private String description;
    private Long price;
}
