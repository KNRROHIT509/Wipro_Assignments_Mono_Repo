package com.wipro.knr.exception;

import lombok.Getter;

@Getter
public class ProjectIdNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errorCode;
    private final String resource;
    private final String field;
    private final Object value;

    public ProjectIdNotFoundException(String resource, String field, Object value) {
        super(String.format("%s not found with %s: '%s'", resource, field, value));
        this.errorCode = "RESOURCE_NOT_FOUND";
        this.resource = resource;
        this.field = field;
        this.value = value;
    }
}