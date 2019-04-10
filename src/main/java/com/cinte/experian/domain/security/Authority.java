package com.cinte.experian.domain.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "AUTHORITY")
@Data
public class Authority {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<User> users;


	public Authority(Long id, @NotNull AuthorityName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Authority(){}
    
    
}