package io.github.cursodsousa.produtosapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import io.github.cursodsousa.produtosapi.model.Producto;


@RestController
@RequestMapping("producto")
public class ProdutoController {
	
	@PostMapping
	public void salvar(Producto producto){
		System.out.println("producto teste" + producto);
	}
	
	

}
