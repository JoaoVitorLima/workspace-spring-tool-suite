package com.produtoapi.service;

import com.produtoapi.model.Produto;
import com.produtoapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	 
	public List<Produto> listarTodos() {
		 return produtoRepository.findAll();
	}
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deletar(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public Produto atualizar(Long id, Produto produto) {
		if (produtoRepository.existsById(id)) {
			produto.setId(id);
			return produtoRepository.save(produto);
		} else {
			throw new RuntimeException("Produto não encontrado");
		}
	}
	
	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}
	
	public List<Produto> salvarLista(List<Produto> produtos) {
		return produtoRepository.saveAll(produtos);
	}
	
	
	
	// ==============================================================================
	// =================== BUSCAS DETALHADAS POR NOME DE PRODUTO ====================
	// ==============================================================================
	
	// Métodos de busca por nome
	public List<Produto> findByNome(String nome) {
		return produtoRepository.findByNome(nome);
	}
	
	public List<Produto> findByNomeContaining(String nome) {
		return produtoRepository.findByNomeContaining(nome);
	}
	
	public List<Produto> findByNomeAndStatus(String nome, String status) {
		return produtoRepository.findByNomeAndStatus(nome, status);
	}
	
	public List<Produto> findByNomeStartingWith(String prefix) {
		return produtoRepository.findByNomeStartingWith(prefix);
	}
	
	public List<Produto> findByNomeEndingWith(String suffix) {
		return produtoRepository.findByNomeEndingWith(suffix);
	}
}