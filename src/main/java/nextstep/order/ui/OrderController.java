package nextstep.order.ui;

import lombok.RequiredArgsConstructor;
import nextstep.order.application.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponse order(@RequestBody OrderRequest request) {
        int total = orderService.order(
                request.getMemberId(), request.getProductIds(), request.getQuantities(), request.getCouponCode());
        return new OrderResponse(total);
    }
}
