package br.edu.utfpr.jhony.testes.data;

import br.edu.utfpr.jhony.testes.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
