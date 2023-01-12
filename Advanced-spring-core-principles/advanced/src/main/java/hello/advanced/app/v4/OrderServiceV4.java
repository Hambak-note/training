package hello.advanced.app.v4;

import hello.advanced.app.v3.OrderRepositoryV3;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){

        /**
         * AbstractTemplate<Void>
         *제네릭에서 반환 타입이 필요한데, 반환할 내용이 없으면 Void 타입을 사용하고 null 을 반환하면
         * 된다. 참고로 제네릭은 기본 타입인 void , int 등을 선언할 수 없다.
         */
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };

        template.execute("OrderService.orderItem()");
    }
}
