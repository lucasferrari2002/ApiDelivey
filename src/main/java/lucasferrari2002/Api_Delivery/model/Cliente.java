package lucasferrari2002.Api_Delivery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O CPF é obrigatório.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos.")
    @Column(unique = true)
    private String cpf;

    @Embedded
    private DadosPessoais dadosPessoais;

    @OneToMany(mappedBy = "cliente")
    private List<Order> orders = new ArrayList<>();

    public Cliente(String cpf, DadosPessoais dadosPessoais) {
        this.cpf = cpf;
        this.dadosPessoais = dadosPessoais;
    }
}
