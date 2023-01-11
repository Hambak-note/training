package hello.itemservice.domain;


import lombok.Data;

/**
 * 상품 자체를 나타내는 객체, 이름, 가격,수량을 속성으로 가지고 있다.
 */
@Data
public class Item {

    private Long id;

    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(){

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
