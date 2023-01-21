package com.devsuperior.DesafioBackEnd.repositories;

import com.devsuperior.DesafioBackEnd.entidades.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

/*cada componente responsavel por acessar o banco de dados em relacao a uma entidade vai se chamar
o nome da entidade Ex: AtividadeRepository com o sufixo 'Repository', o componente AtividadeRepository
vai ser responsavel com operacoes com o banco de dados de 'Atividade'.
Para criar um repository usando spring é so colocar "extends JpaRepository<Entidade, ID>"
criado componente de sistema que vai ter varias operacoes
 */
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}
