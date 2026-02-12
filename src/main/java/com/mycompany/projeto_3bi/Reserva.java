package com.mycompany.projeto_3bi;
public class Reserva {
    protected String nomeDono;
    protected String telefoneDono;
    protected String nomePet;
    protected String especiePet;
    protected String servicoAdicional;
    protected boolean ativa;

    public Reserva() {
        this.ativa = false;
    }

    public Reserva(String nomeDono, String telefoneDono, String nomePet, String especiePet, String servicoAdicional) {
        this.nomeDono = nomeDono;
        this.telefoneDono = telefoneDono;
        this.nomePet = nomePet;
        this.especiePet = especiePet;
        this.servicoAdicional = servicoAdicional;
        this.ativa = true;
    }

    // Métodos comuns
    public void reservarHorario(String nomeDono, String telefoneDono, String nomePet, String especiePet, String servicoAdicional) {
        this.nomeDono = nomeDono;
        this.telefoneDono = telefoneDono;
        this.nomePet = nomePet;
        this.especiePet = especiePet;
        this.servicoAdicional = servicoAdicional;
        this.ativa = true;
    }

    public void cancelarReserva() {
        this.ativa = false;
    }

    public void editarReserva(String novoNome, String novoTelefone) {
        this.nomeDono = novoNome;
        this.telefoneDono = novoTelefone;
    }

    public void listarReservas(Reserva[] reservas) {
        for (int i = 1; i < reservas.length; i++) {
            if (reservas[i] != null && reservas[i].ativa) {
                System.out.println("Reserva " + i + ": " + reservas[i]);
            }
        }
    }

    public void consultarReserva(int numero, Reserva[] reservas) {
        if (reservas[numero] != null && reservas[numero].ativa) {
            System.out.println("Consulta da reserva " + numero + ": " + reservas[numero]);
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    // Getters/Setters
    public String getNomeDono() { return nomeDono; }
    public String getTelefoneDono() { return telefoneDono; }
    public String getNomePet() { return nomePet; }
    public String getEspeciePet() { return especiePet; }
    public String getServicoAdicional() { return servicoAdicional; }

    public void setNomePet(String nomePet) { this.nomePet = nomePet; }
    public void setTelefoneDono(String telefone) { this.telefoneDono = telefone; }

    @Override
    public String toString() {
        return "Dono: " + nomeDono +
               ", Telefone: " + telefoneDono +
               ", Pet: " + nomePet +
               " (" + especiePet + ")" +
               (servicoAdicional != null && !servicoAdicional.isEmpty()
                 ? " | Serviço adicional: " + servicoAdicional
                 : "");
    }
}
