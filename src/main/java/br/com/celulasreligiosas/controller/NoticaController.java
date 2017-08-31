package br.com.celulasreligiosas.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.celulasreligiosas.http.Noticia;
import br.com.celulasreligiosas.repository.NoticiaRepository;
import br.com.celulasreligiosas.repository.entity.NoticiaEntity;


/**
 * Essa classe vai expor os nosso métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/serviceNoticia")
public class NoticaController {
		
	private final  NoticiaRepository repository = new NoticiaRepository();

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método cadastra uma nova notica
	 * */
	@POST	
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/cadastrar")
	public String Cadastrar(Noticia noticia){
		
		NoticiaEntity entity = new NoticiaEntity();
				
		try {

			entity.setAutor(noticia.getAutor());
			entity.setTitulo(noticia.getTitulo());
			entity.setDecricao(noticia.getDecricao());
			entity.setUrl(noticia.getUrl());
			entity.setFoto(noticia.getFoto());
			
			repository.Salvar(entity);
			
			return "Registro cadastrado com sucesso!";
			
		} catch (Exception e) {
			
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	
	}
	
	/**
	 * Essse método altera uma noticia já cadastrada
	 * **/
	@PUT
	@Produces("application/json")
	@Consumes("application/json")	
	@Path("/alterar")
	public String Alterar(Noticia noticia){
		
		NoticiaEntity entity = new NoticiaEntity();
		
		try {

			entity.setCodigo(noticia.getCodigo());
			entity.setAutor(noticia.getAutor());
			entity.setTitulo(noticia.getTitulo());
			entity.setDecricao(noticia.getDecricao());
			entity.setUrl(noticia.getUrl());
			entity.setFoto(noticia.getFoto());
			
			repository.Alterar(entity);
			
			return "Registro alterado com sucesso!";
			
		} catch (Exception e) {
			
			return "Erro ao alterar o registro " + e.getMessage();
			
		}

	}
	/**
	 * Esse método lista todas noticias cadastradas na base
	 * */
	@GET
	@Produces("application/json")
	@Path("/todasNoticias")
	public List<Noticia> TodasNoticias(){
		
		List<Noticia> noticias =  new ArrayList<Noticia>();
		
		List<NoticiaEntity> listaEntityNoticias = repository.TodasNoticias();
		
		for (NoticiaEntity entity : listaEntityNoticias) {
			noticias.add(new Noticia(entity.getCodigo(), 
									 entity.getAutor(),
									 entity.getTitulo(), 
									 entity.getDecricao(),
									 entity.getUrl(),
									 entity.getFoto()));
		}
		
		return noticias;
	}
	
	/**
	 * Esse método busca uma notica cadastrada pelo código
	 * */
	@GET
	@Produces("application/json")
	@Path("/getNoticia/{codigo}")
	public Noticia GetNoticia(@PathParam("codigo") Integer codigo){
		
		NoticiaEntity entity = repository.GetNoticia(codigo);
		
		if(entity != null)
			return new Noticia(entity.getCodigo(), 
							entity.getAutor(),
							entity.getTitulo(), 
							entity.getDecricao(),
							entity.getUrl(), 
							entity.getFoto());
		
		return null;
	}
	
	/**
	 * Excluindo uma pessoa pelo código
	 * */
	@DELETE
	@Produces("application/json")
	@Path("/excluir/{codigo}")	
	public String Excluir(@PathParam("codigo") Integer codigo){
		
		try {
			
			repository.Excluir(codigo);
			
			return "Registro excluido com sucesso!";
			
		} catch (Exception e) {
		
			return "Erro ao excluir o registro! " + e.getMessage();
		}
		
	}
	
	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método cadastra uma nova pessoa
	 * */
	@GET	
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/teste")
	public String teste(){				
		try {
			
			return "Web service funcionando!";
			
		} catch (Exception e) {
			
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	
	}
	
}
