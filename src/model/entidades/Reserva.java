package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat converteData = new SimpleDateFormat("dd/MM/yyyy");

    // Construtores
    public Reserva() {
    }

    public Reserva(Integer numeroQuarto, Date chekIn, Date checkOut) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = chekIn;
        this.checkOut = checkOut;

    }

    // Get e Set
    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getChekOut() {
        return checkOut;
    }

    // Não é gerado Set para ChekIn e ChekOut, pois existe um método para isso.
    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    // Métodos. Long é um tipo de dado que pode armazenar números inteiros, mas não é um tipo de inteiro.
    // Implementando a diferença entre duas dadas. Vamos começar a calcular a diferença das dadas em milissegundos  e depois converter para dias!
    public long duracao() {
        // Devolver a quantidade de milissegundos da dada
        long diferenca = checkOut.getTime() - checkIn.getTime();
        // Convertendo milissegundos para dias
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void dadasAtualizadas(Date chekIn, Date chekOut) {
        this.checkIn = chekIn;
        this.checkOut = chekOut;
    }

    @Override
    public String toString() {
        return "Quarto " + numeroQuarto + ", check-In: " + converteData.format(checkIn) + ", chek-Out:" 
                + converteData.format(checkOut)+ ", "+ duracao() + " Noites";
    }
    
    
}
