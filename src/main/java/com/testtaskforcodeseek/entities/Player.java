package com.testtaskforcodeseek.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "players")
@EntityListeners(AuditingEntityListener.class)
public class Player extends BaseEntity {
    @NotBlank(message = "First name can't be blank")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters long")
    @Column(name = "firstName")
    private String firstName;
    @NotBlank(message = "Last name can't be blank")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters long")
    @Column(name = "lastName")
    private String lastName;
    @Min(0)
    @Column(name = "experience", nullable = false)
    private int experience;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @NotNull
    @Column(name = "birthdate", nullable = false)
    private LocalDateTime birthdate;
}
