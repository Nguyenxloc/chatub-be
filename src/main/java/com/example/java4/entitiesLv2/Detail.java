package com.example.java4.entitiesLv2;
import com.example.java4.entitiesLv1.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Detail {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name="userid",referencedColumnName = "id")
    private Account acc;
    @Column(name="message")
    private String message;
    @Column(name="date-time")
    private LocalDateTime dateTime;
    @Column(name="password")
    private String password;
}
