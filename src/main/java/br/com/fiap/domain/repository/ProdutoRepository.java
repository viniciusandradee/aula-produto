package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.repository.abstracao.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdutoRepository implements Repository<Produto, Long> {

    private static List<Produto> produtos;


    static {

        Produto celular = new Produto( 1L, "Iphone", "14 PRO MAX", BigDecimal.valueOf( 14999.99 ) );
        Produto tablet = new Produto( 2L, "Ipad", "Topzera", BigDecimal.valueOf( 8999.99 ) );
        Produto pendrive = new Produto( 3L, "Pendrive Kingston", "Kingston 2TB", BigDecimal.valueOf( 2999.99 ) );
        Produto ssd = new Produto( 4L, "SSD KINGSTON", "Kingston SSD 4TB", BigDecimal.valueOf( 5999.99 ) );
        Produto celular2 = new Produto( 5L, "Iphone", "11 PRO MAX", BigDecimal.valueOf( 4999.99 ) );
        produtos = new ArrayList<>();
        produtos.addAll( Arrays.asList( celular, tablet, pendrive, ssd, celular2 ) );
    }

    public List<Produto> findAll() {
        return produtos;
    }

    public Produto findById(Long id) {

        for (Produto p : produtos) {
            if (p.getId().equals( id )) {
                return p;
            }
        }
        return null;
    }

    public List<Produto> findByName(String texto) {
        List<Produto> retorno = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase( texto )) {
                retorno.add( p );
            }
        }
        return retorno;
    }

    public Produto persist(Produto p) {
        p.setId( produtos.size() + 1L );
        produtos.add( p );
        return p;
    }
}
