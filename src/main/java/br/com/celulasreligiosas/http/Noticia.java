package br.com.celulasreligiosas.http;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.mysql.jdbc.Blob;

@XmlRootElement
public class Noticia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2304498924298837346L;
	
	
	private int codigo;	
	private String autor;
	private String titulo;
	private String decricao;
	private String url;
	private Blob foto;
	
	public Noticia(){
		
	}
	
	public Noticia(int codigo, String autor, String titulo, String decricao, String url, Blob foto) {
		super();
		this.codigo = codigo;
		this.autor = autor;
		this.titulo = titulo;
		this.decricao = decricao;
		this.url = url;
		this.foto = foto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	
}
