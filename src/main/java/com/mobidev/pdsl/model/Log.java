package com.mobidev.pdsl.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "logs")
public class Log {

    @Id // defines the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // defines the primary key generation strategy.
    private Long id;

    @NotBlank // validates that the field is not null or empty.
    private String description;

    @NotBlank
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
