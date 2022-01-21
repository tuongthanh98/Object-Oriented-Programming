package fit.se.edu.main;

import fit.se.edu.entity.ClientBuilder;
import fit.se.edu.entity.ImmutableClient;
import fit.se.edu.entity.RequiredFieldAnnotation;
import fit.se.edu.entity.Widget;

/**
 * Main class
 * 
 * @author ISV-04
 *
 */
public class Main {

	public static void main(String[] args) {
		// Sử dụng @Builder trên class
		Widget widget = Widget.builder().name("foo").id(0).build();

		System.out.println(widget.getName());
		System.out.println(widget.getId());

		/*
		 * Nếu trong class có một số thuộc tính là bắt buộc khi khởi tạo 
		 * thì chúng ta cần điều chỉnh một số thứ khi sử dụng @Builder 
		 * Và bây giờ chúng ta có thể sử dụng builder method 
			 với các tham số bắt buộc
			 Nếu field bắt buộc không có (null) thông báo lỗi
		 * */
		try {
			 
			RequiredFieldAnnotation.builder("NameField")
									.description("Field Description").build();
		} catch (NullPointerException e) {
			System.out.println("Message Error when required field is null: " + e.getMessage());
		}

		// Sử dụng @Builder trên method
		ImmutableClient testImmutableClient = ClientBuilder.builder().name("foo").id(1).build();
		System.out.println(testImmutableClient.getName());
		System.out.println(testImmutableClient.getId());
	}
	

}
