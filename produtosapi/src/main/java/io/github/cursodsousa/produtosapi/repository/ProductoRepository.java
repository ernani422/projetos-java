package io.github.cursodsousa.produtosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.cursodsousa.produtosapi.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {
	
	List <Producto> findByNome(String nome);

}
