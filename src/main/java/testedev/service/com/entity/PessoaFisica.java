package testedev.service.com.entity;

import java.util.Objects;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class PessoaFisica {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="email")
	private String email;
	
	public PessoaFisica() {
		
	}
	
	public PessoaFisica(Integer id, String nome, String cpf, String telefone, String email) {
		Id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
		
	} 
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, cpf, email, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& Objects.equals(nome, other.nome) && telefone == other.telefone;
	}

	@Override
	public String toString() {
		return "PessoaFisica [Id=" + Id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email="
				+ email + "]";
	}
	
	
}
