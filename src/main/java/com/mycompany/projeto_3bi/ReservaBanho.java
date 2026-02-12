package com.mycompany.projeto_3bi;

public class ReservaBanho extends Reserva {

    public ReservaBanho(String nomeDono, String telefoneDono, String nomePet, String especiePet) {
        super(nomeDono, telefoneDono, nomePet, especiePet, "");
    }

    public String toString() {
        return super.toString() + " | Tipo: Banho";
    }
}
