package com.example.java4.entitiesLv2;

import com.example.java4.entitiesLv1.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="conversation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Conversation {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name="userid1", referencedColumnName = "id")
    private Account acc1;
    @ManyToOne
    @JoinColumn(name="userid2", referencedColumnName = "id")
    private Account acc2;
    @ManyToOne
    @JoinColumn(name="userid3", referencedColumnName = "id")
    private Account acc3;
    @ManyToOne
    @JoinColumn(name="userid4", referencedColumnName = "id")
    private Account acc4;
    @ManyToOne
    @JoinColumn(name="userid5", referencedColumnName = "id")
    private Account acc5;
}
