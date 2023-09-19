package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entidades.Reserva;

public class Programa {

    public static void main(String[] args) throws ParseException {
        Scanner teclado = new Scanner(System.in);
        // Colocando uma SimpleDateFormat para converter String em datas e horas.
        SimpleDateFormat convertStringHoras = new SimpleDateFormat("dd/MM/yyyy");

        // obtendo dados do usuário
        System.out.print("Numero do quarto: ");
        int numeroQuarto = teclado.nextInt();
        // Convertendo uma String para objeto Date com a mascará dd/MM/yyyy.
        System.out.print("Data do check-in - Digite a data no formato dd/MM/yyyy: ");
        Date checkIn = convertStringHoras.parse(teclado.next());
        System.out.print("Data do check-Out - Digite a data no formato dd/MM/yyyy: ");
        Date checkOut = convertStringHoras.parse(teclado.next());

        // Tratando a exceções de forma errada, pois a mesma devia ser tratada na classe reserva
        // Se a data de saída não for posterior a data de entrada o programa vai tratar a exceção apresentado uma mensagem de erro.
        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
            // Se as datas de check-in e check-out tiverem correta o método inicia.  
        } else {
            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
            // Atualizando  as datas da reserva
            System.out.println("");
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Data do check-in - Digite a data no formato dd/MM/yyyy: ");
            checkIn = convertStringHoras.parse(teclado.next());
            System.out.print("Data do check-Out - Digite a data no formato dd/MM/yyyy: ");
            checkOut = convertStringHoras.parse(teclado.next());

            // Se a data de check-in for anterior à data atual ou se a data de check-out for anterior à data atual vai exibir mensagem de erro
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Erro na reserva: As datas de reserva para atualizações devem ser datas futuras");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
            } else {
            reserva.dadasAtualizadas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
            }
        }

        teclado.close();

    }

}
