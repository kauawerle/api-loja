package app.loja.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "t_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String telefone;
    private int idade;
    private String endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties
    private List<Venda> venda;
}
