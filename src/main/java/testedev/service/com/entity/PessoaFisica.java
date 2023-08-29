package testedev.service.com.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pessoafisica")
public class PessoaFisica {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="email")
	private String email;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private EnderecoFisico endereco;
	
	public void setEnderecoFisico(EnderecoFisico endereco) {
		this.endereco=endereco;
		this.endereco.setPessoa(this);
		
	}
	
	
}
