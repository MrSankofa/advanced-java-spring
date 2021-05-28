package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "soil_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SoilType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double ph;

    @Column(nullable = false)
    private boolean dry;

}
