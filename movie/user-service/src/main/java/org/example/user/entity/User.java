package org.example.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "\"user\"")
public class User {
    @Id
    private String login;
    private String name;
    private String genre;
}
