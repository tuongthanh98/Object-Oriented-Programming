package fit.se.edu.entity;

import lombok.Builder;

public class ClientBuilder {
	
	@Builder(builderMethodName = "builder")
    public static ImmutableClient newClient(int id, String name) {
        return new ImmutableClient(id, name);
    }
}
