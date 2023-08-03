package br.com.fiap;

import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.repository.ProdutoRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        List<Produto> produtos = ProdutoRepository.findAll();
//
//        for (Produto produto : produtos) {
//            System.out.println( produto );
//        }


//        Produto prod = ProdutoRepository.findById( 8L );
//
//        System.out.println(prod);


        List<Produto> produtos = ProdutoRepository.findByName( "ipad" );

        produtos.forEach( System.out::println );

    }
}