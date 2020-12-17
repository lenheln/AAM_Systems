package elena.kozlova.AAM_Systems.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Сущность Продукт
 */

@Entity
@Table(name = "products")
@Getter @Setter
@Builder
@AllArgsConstructor
public class Product {

    //Идентификатор продукта
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Название продукта
    @NotNull
    @Column(name = "name")
    private String name;

    //Описание продукта
    @Column(name = "description")
    private String description;

    //Стоимость продукта
    @Positive
    @Column(name = "price")
    private Long price;

    Product(){}
}
