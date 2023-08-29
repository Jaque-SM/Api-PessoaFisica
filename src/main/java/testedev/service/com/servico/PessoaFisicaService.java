package testedev.service.com.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import testedev.service.com.entity.PessoaFisica;
import testedev.service.com.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	
	@Autowired
	private PessoaFisicaRepository pessoaFisica;
	
	PessoaFisica findByCpf(PessoaFisica pessoa){
		
		List<PessoaFisica> pessoaCpf=this.pessoaFisica.findByCpf(pessoa.getCpf());
    	
    	if (pessoaCpf!=null&&pessoaCpf.isEmpty()) {
    		throw new ResourceNotFoundException("Já existe uma pessoa com esse CPF");
    	}
    	
		
		return null;
	}
	
	

}
