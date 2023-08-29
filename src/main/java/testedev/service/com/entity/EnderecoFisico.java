package testedev.service.com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="enderecofisico")
public class EnderecoFisico {
	
	@Id
	@Column(name = "pessoa_id")
	private Integer idPessoa;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="bairro")
	private String Bairro;
	
	@Column(name="cep")
	private String CEP;
	
	@Column(name="cidade")
	private String Cidade;
	
	@Column(name="uf")
	private String Uf;
	
    @JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "pessoa_id")
	private PessoaFisica pessoa;
	

}
