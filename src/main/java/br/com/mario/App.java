package br.com.mario;
import br.com.mario.model.Produto;
public class App 
{
    public static void main( String[] args )
    {
        Produto produto = new Produto();
        produto.setNome("lata de oleo");
        System.out.println(produto.toString());
        
    }
}
