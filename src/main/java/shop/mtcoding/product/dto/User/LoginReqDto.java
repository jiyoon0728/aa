package shop.mtcoding.product.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginReqDto {
	private String username;
	private String password;
}