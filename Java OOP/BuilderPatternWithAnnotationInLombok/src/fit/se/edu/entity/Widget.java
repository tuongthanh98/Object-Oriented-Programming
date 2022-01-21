package fit.se.edu.entity;

import lombok.Builder;
import lombok.Getter;

/**
 * Widget class
 * 
 * @author ISV-04
 *
 */
@Getter
@Builder
public class Widget {
	private final String name;
	private final int id;
}
