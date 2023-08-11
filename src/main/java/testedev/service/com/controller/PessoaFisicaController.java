package testedev.service.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import testedev.service.com.entity.PessoaFisica;
import testedev.service.com.repository.PessoaFisicaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public  class PessoaFisicaController {
	
    public static Logger logger = LogManager.getLogger(PessoaFisicaController.class);

	@Autowired
	private PessoaFisicaRepository pessoaFisica;
	
	
	@GetMapping("/pessoas")
	public List<PessoaFisica> getAllPessoas() {
		return (List<PessoaFisica>) pessoaFisica.findAll();
	}
	
    @RequestMapping(value = "/pessoas", method = RequestMethod.POST)
	public PessoaFisica createPessoaFisica(@RequestBody PessoaFisica pessoa) {	
    	
    	System.out.println("Valor telefone: "+pessoa.getTelefone());
    	
		return pessoaFisica.save(pessoa);
	}
	
    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.GET)
	public PessoaFisica getPessoaFisicaByName(@PathVariable("id") Integer id) {
 

		return pessoaFisica.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não existe Pessoa com esse Id"));
				
    }
    
    @PutMapping("/pessoas/{id}")
    public ResponseEntity<PessoaFisica> updatePessoaFisica(@PathVariable Integer id, @RequestBody PessoaFisica personDetails) {
    	  
    	PessoaFisica pessoa=pessoaFisica.findById(id).orElseThrow(()
    			-> new ResourceNotFoundException("PessoaFisica not exist with id :" + id) );
  
    	pessoa.setNome(personDetails.getNome());
    	pessoa.setCpf(personDetails.getCpf());
    	pessoa.setEmail(personDetails.getEmail());
    	pessoa.setTelefone(personDetails.getTelefone());
    	
    	PessoaFisica updatePessoa=pessoaFisica.save(pessoa);
    	
    	return ResponseEntity.ok(updatePessoa);
    	
    }
    
    @DeleteMapping("/pessoa/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePessoaFisica(@PathVariable("id") Integer id){
		
		PessoaFisica pessoa=pessoaFisica.findById(id).orElseThrow(()
    			-> new ResourceNotFoundException("PessoaFisica not exist with id :" + id) );
  
		pessoaFisica.delete(pessoa);
		Map<String, Boolean> response =new HashMap<String, Boolean>();
		
		response.put("deletado com sucesso!", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
