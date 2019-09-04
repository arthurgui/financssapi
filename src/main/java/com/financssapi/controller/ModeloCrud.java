package com.financssapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ModeloCrud<T> {

    public List<T> listar();

    public T cadastrar(T obj);

    public T editar(T obj);

    public void remover(Long id);

    public Page<T> paginar(Pageable pageable);
}
