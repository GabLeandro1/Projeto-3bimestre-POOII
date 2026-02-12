package com.mycompany.projeto_3bi;

public class ReservaBanhoETosa extends Reserva {

    public ReservaBanhoETosa(String nomeDono, String telefoneDono, String nomePet, String especiePet) {
        super(nomeDono, telefoneDono, nomePet, especiePet, "Tosa");
    }

    public String toString() {
        return super.toString() + " | Tipo: Banho + Tosa";
    }
}
