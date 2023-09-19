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

    // Nessa solução a lógica de check-In e Check-Out estão na classe certa, porém o método ainda está errado. 
    // Tiramos o void, pois o método tem que retornar uma String. 
    public String dadasAtualizadas(Date chekIn, Date chekOut) {
        // Se a data de check-in for anterior à data atual ou se a data de check-out for anterior à data atual vai exibir mensagem de erro
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "As datas de reserva para atualizações devem ser datas futuras";
        }
        if (!checkOut.after(checkIn)) {
            return "a data de check-out deve ser posterior à data de check-in";
        }
        this.checkIn = chekIn;
        this.checkOut = chekOut;
        return null;
    }

    @Override
    public String toString() {
        return "Quarto " + numeroQuarto + ", check-In: " + converteData.format(checkIn) + ", chek-Out:"
                + converteData.format(checkOut) + ", " + duracao() + " Noites";
    }

}
