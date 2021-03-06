package sd.oficina.oficinawebapp.person.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sd.oficina.oficinawebapp.person.services.CidadeService;
import sd.oficina.shared.model.person.Cidade;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/buscar/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Cidade> buscar(@PathVariable("id") int idDaCidade) {
        Cidade cidade = cidadeService.buscar(idDaCidade);
        return ResponseEntity.ok().body(cidade);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Cidade>> listar() {
        return ResponseEntity.ok().body(cidadeService.listar());
    }

    @GetMapping("/listarPorEstado/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Cidade>> listarPorEstado(@PathVariable("id") int idDoEstado) {
        return ResponseEntity.ok().body(cidadeService.listarPorEstado(idDoEstado));
    }
}
