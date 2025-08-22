package com.careNcure.backend.authentication;

@Entity
public class UserCredentials{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String email;
    private long mobile;
    private String password;
}