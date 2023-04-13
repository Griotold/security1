package com.cos.security1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Data
@Table(name = "user_1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
    private String provider; // "google"
    private String providerId; // google의 DB_id // 106842467834513592196
    @CreationTimestamp
    private Timestamp createdDate;
}
