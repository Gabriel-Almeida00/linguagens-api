package br.com.alura.linguagens.api;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;

    }

    @GetMapping("/linguagens/ranking")

    public List<Linguagem> obtetListaRankeada(){
        List<Linguagem> listNotRanked = repositorio.findAll();
        List<Linguagem> listRanked = listNotRanked.stream()
                .sorted(Comparator.comparing(Linguagem::getRating))
                .collect(Collectors.toList());
        return listRanked;

    }

    @PostMapping("/linguagens")
    public ResponseEntity<Linguagem> cadastroLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return ResponseEntity.ok(linguagemSalva);

    }

    @PutMapping("/linguagens/{id}")
    public ResponseEntity<Linguagem> atualizarLinguagem(@PathVariable String id, @RequestBody Linguagem linguagem) {
        Linguagem novaLinguagem = repositorio.findById(id).orElseThrow();
        novaLinguagem.setTitle(linguagem.getTitle());
        novaLinguagem.setImage(linguagem.getImage());
        novaLinguagem.setRating(linguagem.getRating());
        repositorio.save(novaLinguagem);
        return ResponseEntity.ok(novaLinguagem);

    }

    @DeleteMapping("linguagens/{id}")
    public String deletarLinguagem(@PathVariable String id){
        try{
            repositorio.deleteById(id);
            return "Apagado com sucesso";
        }catch (Exception e){
            return "Id não encontrado";

        }
    }
}
