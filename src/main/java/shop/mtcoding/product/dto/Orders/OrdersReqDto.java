package shop.mtcoding.product.dto.Orders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersReqDto {
    private Integer ordersId;
    private String ordersName;
    private Integer ordersPrice;
    private Integer ordersQty;
    private Integer productId;

}