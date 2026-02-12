package com.mycompany.projeto_3bi;
import java.util.Scanner;
import com.mycompany.projeto_3bi.Reserva;

public class Projeto_3bi {

    public static void main(String[] args) {
   Reserva[] reservas = new Reserva[11]; // índices 1..10
        Reserva gerente = new Reserva();
        int numeroAgenda = 0;
        String nomeDono = "";
        String telefoneDono = "";
        int operacao = 1;
        int confirmacao;
        Scanner entradaDados = new Scanner(System.in);

        System.out.println("\n===============================");
        System.out.println("SISTEMA DE GERENCIAMENTO DE AGENDA DE BANHO PARA PETSHOP");
        System.out.println("===============================\n");

        while (true) {
            if (operacao == 0) break;

            System.out.println("===============================");
            System.out.println("AÇÕES");
            System.out.println("===============================\n");
            System.out.println("[1] - Agendar Banho");
            System.out.println("[2] - Consultar Agendamento");
            System.out.println("[3] - Consultar Horários");
            System.out.println("[4] - Editar Agendamento");
            System.out.println("[5] - Excluir Agendamento");
            System.out.println("[0] - Sair");
            System.out.println("\n===============================");
            System.out.print("Escolha uma opção: ");
            if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); continue; }
            operacao = entradaDados.nextInt();
            entradaDados.nextLine(); // consome quebra

            while (operacao < 0 || operacao > 5) {
                System.out.print("\nOpção inválida! Digite novamente: ");
                if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); continue; }
                operacao = entradaDados.nextInt();
                entradaDados.nextLine();
            }

            switch (operacao) {
                case 1: // Agendar banho
                    while (true) {
                        System.out.println("\n-------------------------------");
                        System.out.print("Digite o nome do dono: ");
                        nomeDono = entradaDados.nextLine();

                        System.out.print("Digite o telefone do dono: ");
                        telefoneDono = entradaDados.nextLine();

                        System.out.print("Digite o nome do pet: ");
                        String nomePet = entradaDados.nextLine();

                        System.out.print("Digite a espécie do pet(ex.: cachorro, gato, etc.): ");
                        String especiePet = entradaDados.nextLine();

                        System.out.print("Digite o serviço adicional (ou deixe vazio): ");
                        String servicoAdicional = entradaDados.nextLine();

                        System.out.println("-----------------------------------");
                        System.out.print("Digite o número do horário disponível (1-10): ");
                        if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); continue; }
                        numeroAgenda = entradaDados.nextInt();
                        entradaDados.nextLine();

                        while (numeroAgenda < 1 || numeroAgenda > 10) {
                            System.out.print("Horário inválido, digite entre (1-10): ");
                            if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); continue; }
                            numeroAgenda = entradaDados.nextInt();
                            entradaDados.nextLine();
                        }

                        if (reservas[numeroAgenda] == null || reservas[numeroAgenda].getNomeDono().isEmpty()) {
                            // Decide qual subclasse instanciar
                            if (servicoAdicional.equalsIgnoreCase("tosa")) {
                                reservas[numeroAgenda] = new ReservaBanhoETosa(nomeDono, telefoneDono, nomePet, especiePet);
                            } else if (!servicoAdicional.isEmpty()) {
                                reservas[numeroAgenda] = new ReservaBanhoComAdicional(nomeDono, telefoneDono, nomePet, especiePet, servicoAdicional);
                            } else {
                                reservas[numeroAgenda] = new ReservaBanho(nomeDono, telefoneDono, nomePet, especiePet);
                            }
                            System.out.println("\nHorário reservado com sucesso!");
                            System.out.println("-----------------------------------");
                            break;
                        } else {
                            System.out.println("\nO horário " + numeroAgenda + " já está ocupado pelo pet: " +
                            reservas[numeroAgenda].getNomePet());
                            System.out.println("-----------------------------------");
                            System.out.print("Deseja tentar outro horário? (1-sim/2-não): ");
                            if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); continue; }
                            confirmacao = entradaDados.nextInt();
                            entradaDados.nextLine();
                            if (confirmacao == 1) continue;
                            else break;
                        }
                    }
                    break;

                case 5: // Excluir agendamento
                    while (true) {
                        System.out.println("\n-------------------------------");
                        System.out.print("Deseja excluir o agendamento? (1-sim/2-não): ");
                        if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); break; }
                        confirmacao = entradaDados.nextInt();
                        entradaDados.nextLine();

                        if (confirmacao == 1) {
                            System.out.print("Digite o número da reserva (1-10): ");
                            if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); break; }
                            numeroAgenda = entradaDados.nextInt();
                            entradaDados.nextLine();

                            while (numeroAgenda < 1 || numeroAgenda > 10) {
                                System.out.print("Número inválido, digite entre (1-10): ");
                                if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); continue; }
                                numeroAgenda = entradaDados.nextInt();
                                entradaDados.nextLine();
                            }

                            if (reservas[numeroAgenda] != null && !reservas[numeroAgenda].getNomeDono().isEmpty()) {
                                reservas[numeroAgenda].cancelarReserva();
                                System.out.println("\nCancelamento do horário " + numeroAgenda + " realizado com sucesso.");
                            } else {
                                System.out.println("\nO horário " + numeroAgenda + " já está disponível.");
                            }
                        }
                        break;
                    }
                    System.out.println("-----------------------------------");
                    break;

                case 3: // Listar horários
                    System.out.println("\n-----------------------------------");
                    System.out.println("       LISTA DE HORÁRIOS          ");
                    System.out.println("-----------------------------------");
                    System.out.println("1-(7:00) \n2-(9:00) \n3-(11:00) \n4-(13:00) \n5-(14:00) \n6-(15:00) \n7-(17:00) \n8-(19:00) \n9-(21:00) \n10-(23:00)");
                    gerente.listarReservas(reservas);
                    System.out.println("-----------------------------------");
                    break;

                case 2: // Consultar reserva
                    System.out.println("\n-----------------------------------");
                    System.out.print("Digite o número da reserva (1-10): ");
                    if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); break; }
                    numeroAgenda = entradaDados.nextInt();
                    entradaDados.nextLine();

                    while (numeroAgenda < 1 || numeroAgenda > 10) {
                        System.out.print("Número inválido, digite entre (1-10): ");
                        if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); continue; }
                        numeroAgenda = entradaDados.nextInt();
                        entradaDados.nextLine();
                    }

                    if (reservas[numeroAgenda] != null && !reservas[numeroAgenda].getNomeDono().isEmpty()) {
                        gerente.consultarReserva(numeroAgenda, reservas);
                    } else {
                        System.out.println("\nA reserva " + numeroAgenda + " não está ocupada ou não existe.");
                    }
                    System.out.println("-----------------------------------");
                    break;

                case 4: // Editar reserva
                    System.out.println("\n-----------------------------------");
                    System.out.print("Digite o número da reserva para editar (1-10): ");
                    if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); break; }
                    numeroAgenda = entradaDados.nextInt();
                    entradaDados.nextLine();

                    while (numeroAgenda < 1 || numeroAgenda > 10) {
                        System.out.print("Número inválido, digite entre (1-10): ");
                        if (!entradaDados.hasNextInt()) { entradaDados.nextLine(); continue; }
                        numeroAgenda = entradaDados.nextInt();
                        entradaDados.nextLine();
                    }

                    if (reservas[numeroAgenda] != null && !reservas[numeroAgenda].getNomeDono().isEmpty()) {
                        System.out.print("Novo nome do dono (atual: " + reservas[numeroAgenda].getNomeDono() + "): ");
                        String novoNome = entradaDados.nextLine();
                        System.out.print("Novo telefone do dono (atual: " + reservas[numeroAgenda].getTelefoneDono() + "): ");
                        String novoTelefone = entradaDados.nextLine();
                        reservas[numeroAgenda].editarReserva(novoNome, novoTelefone);
                        System.out.println("Reserva atualizada.");
                    } else {
                        System.out.println("\nO horário " + numeroAgenda + " não está ocupado ou não existe.");
                    }
                    System.out.println("-----------------------------------");
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("\n-----------------------------------");
                    System.out.println("Opção inválida! O número digitado não está listado entre as ações disponíveis.");
                    System.out.println("-----------------------------------");
                    break;
            }
        }
        entradaDados.close();
    }
}