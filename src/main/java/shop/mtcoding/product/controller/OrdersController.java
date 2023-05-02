package shop.mtcoding.product.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.product.dto.orders.OrdersReqDto;
import shop.mtcoding.product.model.orders.OrdersRepository;
import shop.mtcoding.product.model.product.Product;
import shop.mtcoding.product.model.product.ProductRepository;
import shop.mtcoding.product.model.user.User;

@RequiredArgsConstructor
@Controller
public class OrdersController {
	private final HttpSession session;
	private final OrdersRepository ordersRepository;
	private final ProductRepository productRepository;

	@GetMapping("/orders/ordersList")
	public String ordersListForm(Model model) {
		User principal = (User) session.getAttribute("principal");
		List<OrdersReqDto> orderslist = ordersRepository.findAll(principal.getId());
		model.addAttribute("orderslist",orderslist);
        return "orders/ordersList"; 
    }

	@PostMapping("/orders/{productId}")
	public String ordersList(@PathVariable Integer productId, OrdersReqDto ordersReqDto, Model model) {
		User principal = (User) session.getAttribute("principal");

		if (principal == null) {
			return "redirect:/loginForm";
		}

		// 상품수량 - 구매수량 < 0
		Product productPS = productRepository.findById(productId);
		if (productPS.getQty() - ordersReqDto.getOrdersQty() < 0) {
			return "redirect:/product/" + productId;
		}

		// 상품 구매 -> 구매목록 페이지로
		productRepository.productQtyUpdate(ordersReqDto);
		ordersRepository.insert(ordersReqDto.toModel(principal.getId()));
		return "redirect:/orders/ordersList";
	}
}