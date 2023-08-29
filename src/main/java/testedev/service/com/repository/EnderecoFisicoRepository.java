package testedev.service.com.repository;

import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import testedev.service.com.entity.EnderecoFisico;
import testedev.service.com.entity.PessoaFisica;

@ComponentScan("testedev.service.com.entity")
@Repository
public interface EnderecoFisicoRepository extends  CrudRepository<EnderecoFisico, Integer>{ 
	
	
	Optional<EnderecoFisico> findById(Integer idEnde);
	
	

}
