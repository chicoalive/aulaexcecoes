package model.excecoes;

// Exception obriga a tratar as exceções, enquanto que RuntimeException não, porém se não tratada o código pode quebrar com RuntimeExcption.
public class DominioExcecoes extends Exception {

// Criando um construtor que recebe um String como argumento. Assim consigo instanciar a classe Domínio.. passando um String para ela!
    public DominioExcecoes(String mensagem) {
        super(mensagem);
    }
}
