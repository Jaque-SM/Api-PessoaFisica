package testedev.service.com.repository;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import testedev.service.com.entity.PessoaFisica;

@ComponentScan("testedev.service.com.entity")
@Repository
public interface PessoaFisicaRepository extends  CrudRepository<PessoaFisica, Integer> {
	
    @Query("SELECT p FROM PessoaFisica p WHERE p.nome = :nome")
	List<PessoaFisica> findByNome(@Param("nome") String nome);
    
    @Query("SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf")
    List<PessoaFisica> findByCpf(@Param("cpf") String cpf);

}
