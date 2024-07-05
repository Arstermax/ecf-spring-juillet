package org.example.employer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "e_departement")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "e_departement_id")
    private long id;
}
