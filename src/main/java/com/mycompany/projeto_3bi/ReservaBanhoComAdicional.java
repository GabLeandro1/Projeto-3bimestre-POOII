package com.mycompany.projeto_3bi;

public class ReservaBanhoComAdicional extends Reserva {

    public ReservaBanhoComAdicional(String nomeDono, String telefoneDono, String nomePet, String especiePet, String servicoAdicional) {
        super(nomeDono, telefoneDono, nomePet, especiePet, servicoAdicional);
    }

    public String toString() {
        return super.toString() + " | Tipo: Banho + Serviço adicional";
    }
}
