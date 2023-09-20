package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entidades.Reserva;
import model.excecoes.DominioExcecoes;

public class Programa {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
// Colocando uma SimpleDateFormat para converter String em datas e horas.
        SimpleDateFormat convertStringHoras = new SimpleDateFormat("dd/MM/yyyy");

// Tratando as exceções: 
        try {
// obtendo dados do usuário
            System.out.print("Numero do quarto: ");
            int numeroQuarto = teclado.nextInt();
// Convertendo uma String para objeto Date com a mascará dd/MM/yyyy.
            System.out.print("Data do check-in - Digite a data no formato dd/MM/yyyy: ");
            Date checkIn = convertStringHoras.parse(teclado.next());
            System.out.print("Data do check-Out - Digite a data no formato dd/MM/yyyy: ");
            Date checkOut = convertStringHoras.parse(teclado.next());

            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
// Atualizando  as datas da reserva
            System.out.println("");
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Data do check-in - Digite a data no formato dd/MM/yyyy: ");
            checkIn = convertStringHoras.parse(teclado.next());
            System.out.print("Data do check-Out - Digite a data no formato dd/MM/yyyy: ");
            checkOut = convertStringHoras.parse(teclado.next());
// O reserva.dadasAtualizadas retornara uma string e será esse String que vai identificar se houve erro ou não. 
            reserva.dadasAtualizadas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        } catch (ParseException erroParse) {
            System.out.println("Data invalida!");
// Lanço outro catch capturando a exceção  que criei lá em reserva a IllegalArgumentException
        } catch (DominioExcecoes erro) {
// erroilegal.getMessage pega a mensagem que criamos lá em reserva (linha 60)
            System.out.println("Erro na reserva: "+erro.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado");
        }

        teclado.close();

    }

}
