package hello.itemservice.repository;

import lombok.Data;


/**
 * 상품을 수정할 때 사용하는 객체
 * 단순히 데이터를 전달하는 용도로 사용되므로 DTO를 뒤에붙임
 */
@Data
public class ItemUpdateDto {

    private String itemName;
    private Integer price;
    private Integer quantity;

    public ItemUpdateDto() {
    }

    public ItemUpdateDto(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
