package com.testtaskforcodeseek.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teams")
@EntityListeners(AuditingEntityListener.class)
public class Team extends BaseEntity {
    @NotBlank(message = "Title can't be blank")
    @Size(min = 2, max = 50, message = "Title must be between 2 and 50 characters long")
    @Column(name = "title", nullable = false)
    private String title;
    @OneToMany(
            mappedBy = "team"
    )
    private List<Player> players;
    @NotNull
    @Column(name = "commission")
    private double commission;
    @Column(name = "funds")
    private double funds;
}
