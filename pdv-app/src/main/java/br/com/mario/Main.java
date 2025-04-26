package br.com.mario;

import br.com.mario.repository.ProdutoCrud;

public class Main {
    public static void main(String[] args) {
        ProdutoCrud crud = new ProdutoCrud();
        
        try {
            System.out.println(crud.listExec());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}