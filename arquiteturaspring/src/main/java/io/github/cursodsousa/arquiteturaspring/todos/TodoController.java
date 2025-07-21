package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("todos")
public class TodoController {
	
	private TodoService service;

	public TodoController(TodoService service) {
		super();
		this.service = service;
	}
	
	 @PostMapping
	    public TodoEntity salvar(@RequestBody TodoEntity todo){
	        try {
	            return this.service.salvar(todo);
	        }catch (IllegalArgumentException e){
	            var mensagemErro = e.getMessage();
	            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
	        }
	    }
	 
	
	@PutMapping("{id}")
	public void atualizar(
			@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
		todo.setId(id);
		service.atualizarStatus(todo);
		
	}

	@GetMapping("{id}")
	public TodoEntity buscar(@PathVariable("id") Integer id) {
		return service.buscarPorId(id);
	}

}
