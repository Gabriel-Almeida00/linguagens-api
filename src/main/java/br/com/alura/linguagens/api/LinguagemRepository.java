package br.com.alura.linguagens.api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepository extends MongoRepository<Linguagem,String > {
    
    public Linguagem findByTitleContainingIgnoreCase(String title);
    public Linguagem findAllByRating(int ranking);
}
