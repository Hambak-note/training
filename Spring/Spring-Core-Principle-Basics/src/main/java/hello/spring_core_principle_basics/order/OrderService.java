package hello.spring_core_principle_basics.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
