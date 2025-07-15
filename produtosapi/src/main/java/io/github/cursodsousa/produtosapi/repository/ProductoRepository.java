package io.github.cursodsousa.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.cursodsousa.produtosapi.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {

}
