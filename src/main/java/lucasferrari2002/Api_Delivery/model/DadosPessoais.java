package lucasferrari2002.Api_Delivery.model;

import jakarta.validation.constraints.*;

public class DadosPessoais {
    @NotBlank(message = "O nome não pode estar vazio.")
    @Size(message = "O nome não pode estar vazio.")
    private String nome;

    @NotNull(message = "A idade é obrigatória.")
    @Min(value = 0, message = "A idade não pode ser negativa.")
    @Max(value = 120, message = "A idade não pode ser maior que 120 anos.")
    private Integer idade;

    @NotBlank(message = "O email não pode estar vazio.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 dígitos.")
    private String telefone;

    @NotNull(message = "O endereço é obrigatório.")
    private Address address;

    public DadosPessoais(String nome, Integer idade, String email, String telefone, Address address) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.address = address;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Address getAddress() {
        return address;
    }
}
