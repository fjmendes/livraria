
package livraria.model;

/**
 *
 * @author Felipe
 */
public class Livro {
    
    private Integer idLivro;
    private String titulo;
    private String autor;
    private Double valor;
    private Integer qtdeEstoque;

  
    public Livro(Integer idLivro, String titulo, String autor, Double valor, Integer qtdeEstoque){
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.valor = valor;
        this.qtdeEstoque = qtdeEstoque;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQtdeEstoque() {
        return qtdeEstoque;
    }
    
    
    
    
    
    
}
