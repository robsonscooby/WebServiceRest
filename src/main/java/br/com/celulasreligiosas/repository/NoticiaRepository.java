package br.com.celulasreligiosas.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.celulasreligiosas.repository.entity.NoticiaEntity;


public class NoticiaRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	public NoticiaRepository(){
		
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void Salvar(NoticiaEntity noticiaEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(noticiaEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void Alterar(NoticiaEntity noticiaEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(noticiaEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/**
	 * RETORNA TODAS AS NOTICIAS CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<NoticiaEntity> TodasNoticias(){
		
		return this.entityManager.createQuery("SELECT p FROM NoticiaEntity p ORDER BY p.autor").getResultList();
	}
	
	/**
	 * CONSULTA UMA NOTICIA CADASTRA PELO CÓDIGO
	 * */
	public NoticiaEntity GetNoticia(Integer codigo){
		
		return this.entityManager.find(NoticiaEntity.class, codigo);
	}
	
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void Excluir(Integer codigo){
		
		NoticiaEntity noticia = this.GetNoticia(codigo);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(noticia);
		this.entityManager.getTransaction().commit();
		
	}
}
