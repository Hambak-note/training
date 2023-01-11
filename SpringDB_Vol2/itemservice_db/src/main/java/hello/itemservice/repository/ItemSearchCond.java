package hello.itemservice.repository;


import lombok.Data;


/**
 * 검색 조건으로 사용
 * 상품명, 최대 가격 존재
 * 참고 : 상품명의 일부만 포함되어도 검색이 가능해야 한다.(like 검색)
 * cond => condition 을 줄여서 사용
 * => 이 프로젝트에서 검색 조건은 뒤에 Cond를 붙이도록 규칙을 정했다.
 *
 * ItemSearchCond도 DTO 역할을 하지만, 이 프로젝트에서 Cond는 검색 조건으로 사용한다는 규칙을 정함
 * 따라서 DTO를 붙이지 않았다.
 * 참고: 이런 규칙은 정해진 것이 없기 때문에해당 프로젝트 안에서 일관성 있게 규칙을 정한다.
 */
@Data
public class ItemSearchCond {

    private String itemName;
    private Integer maxPrice;

    public ItemSearchCond() {
    }

    public ItemSearchCond(String itemName, Integer maxPrice) {
        this.itemName = itemName;
        this.maxPrice = maxPrice;
    }
}
