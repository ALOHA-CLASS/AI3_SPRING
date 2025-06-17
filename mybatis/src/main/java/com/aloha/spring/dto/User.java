package com.aloha.spring.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	
	private int no;
	private String id;
	
	// 6자리 이상 (영문자+숫자)
	@NotBlank(message = "아이디는 필수입니다.")
    @Size(min = 6, message = "아이디는 6자 이상이어야 합니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "아이디는 영문 또는 숫자만 입력하세요.")
    private String username;

	// 8자리 이상 (영문자/숫자/특수문자 1개이상)
    @NotBlank(message = "비밀번호는 필수입니다.")
    @Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-])[A-Za-z\\d!@#$%^&*()_+=-]{8,}$",
        message = "비밀번호는 8자 이상이며, 영문자/숫자/특수문자를 각각 하나 이상 포함해야 합니다."
    )
    private String password;

    // 2글자 이상
    @NotBlank(message = "이름은 필수입니다.")
    @Size(min = 2, message = "이름은 2자 이상이어야 합니다.")
    private String name;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

	private Date createdAt;
	private Date updatedAt;

}
