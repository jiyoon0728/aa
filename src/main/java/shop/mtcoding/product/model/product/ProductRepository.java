package shop.mtcoding.product.model.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.product.dto.orders.OrdersReqDto;
import shop.mtcoding.product.dto.product.ProductReqDto.ProductAddReqDto;


@Mapper
public interface ProductRepository {
    public List<Product> findAll();

    public Product findById(int id);

    public int insert(ProductAddReqDto productAddReqDto);

    public int delete(@Param("id") int id);

    public int update(@Param("id") int id, @Param("name") String name, @Param("price") int price,
            @Param("qty") int qty);

    // ajax 중복체크
    public Product findByName(String productname);

    public void productQtyUpdate(OrdersReqDto ordersReqDto);

}