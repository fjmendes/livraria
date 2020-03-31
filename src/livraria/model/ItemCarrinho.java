package livraria.model;

/**
 *
 * @author Felipe
 */
public class ItemCarrinho {
    
    private Integer idItem;
    private Double valorOriginal;
    private Integer qtdeItem;
    private Double subTotalItem;
    private String titulo;
    private String autor;

    public Integer getIdItem() {
        return idItem;
    }

    public Double getValorOriginal() {
        return valorOriginal;
    }

    public Integer getQtdeItem() {
        return qtdeItem;
    }

    public Double getSubTotalItem() {
        return subTotalItem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public ItemCarrinho(int idItem, String titulo, String autor, Double valorOriginal, int qtdeItem, Double subTotalItem) {
        this.idItem=idItem;
        this.titulo=titulo;
        this.autor=autor;
        this.valorOriginal=valorOriginal;
        this.qtdeItem=qtdeItem;
        this.subTotalItem=subTotalItem;
    }

    public void ItemCarrinho(Integer idItem, Double valorOriginal, Integer qtdeItem, Double subTotalItem){
        this.idItem=idItem;
        this.valorOriginal=valorOriginal;
        this.qtdeItem=qtdeItem;
        this.subTotalItem=subTotalItem;
    }
    
   
}
