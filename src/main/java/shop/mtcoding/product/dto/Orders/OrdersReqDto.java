package shop.mtcoding.product.dto.orders;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.product.model.orders.Orders;

@Getter
@Setter
public class OrdersReqDto {
    private Integer id;
    private String ordersName;
    private Integer ordersPrice;
    private Integer ordersQty;
    private Integer productId;

    public Orders toModel(int principalId) {
        Orders orders = new Orders();
        orders.setOrdersId(id);
        orders.setOrdersName(ordersName);
        orders.setOrdersQty(ordersQty);
        orders.setProductId(productId);
        orders.setOrdersPrice(ordersPrice);
        orders.setUserId(principalId);
        return orders;
    }
}