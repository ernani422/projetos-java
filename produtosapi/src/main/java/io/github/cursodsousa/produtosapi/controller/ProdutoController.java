package io.github.cursodsousa.produtosapi.controller;

import java.util.List;
import java.util.UUID;

import org.apache.el.stream.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import io.github.cursodsousa.produtosapi.model.Producto;
import io.github.cursodsousa.produtosapi.repository.ProductoRepository;


@RestController
@RequestMapping("producto")
public class ProdutoController {
	
	private ProductoRepository productoRepository;
	
	public ProdutoController(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}


	@PostMapping
	public Producto salvar(@RequestBody Producto producto){
		System.out.println("producto teste" + producto);
		

        var id = UUID.randomUUID().toString();
        producto.setId(id); 
        
		productoRepository.save(producto);
		return producto;
	}
	
	
    @GetMapping("{id}")
    public Producto obterPorId(@PathVariable("id") String id){
        return productoRepository.findById(id).orElse(null);
    }
	
    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        productoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Producto produto){
        produto.setId(id);
        productoRepository.save(produto);
    }

//    @GetMapping
//    public List<Producto> buscar(@RequestParam("nome") String nome){
//        return productoRepository.findByNome(nome);
//    }
	

}
