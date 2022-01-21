package fit.se.edu.entity;

import lombok.Builder;

import lombok.Getter;
import lombok.NonNull;

/**
 * RequiredFieldAnnotation class
 * 
 * @author ISV-04
 *
 */
@Builder(builderMethodName = "internalBuilder")
@Getter
public class RequiredFieldAnnotation {

	@NonNull
	private String name;
	private String description;
	
	public static RequiredFieldAnnotationBuilder builder(String name) {
		return internalBuilder();
	}
}
