package com.userservice.dto;

public interface UserProjection {
	Long getId();
	String getName();
    String getPassword();
    String getRole();
}
