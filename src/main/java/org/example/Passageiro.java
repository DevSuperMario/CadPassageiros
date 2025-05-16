package org.example;

import java.util.regex.Pattern;

public class Passageiro {
    private int id;
    private String nome;
    private String cpf;
    private String email;

    public Passageiro(int id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", "");
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        int soma1 = 0, soma2 = 0;
        for (int i = 0; i < 9; i++) {
            int num = Character.getNumericValue(cpf.charAt(i));
            soma1 += num * (10 - i);
            soma2 += num * (11 - i);
        }
        int dig1 = soma1 % 11 < 2 ? 0 : 11 - soma1 % 11;
        soma2 += dig1 * 2;
        int dig2 = soma2 % 11 < 2 ? 0 : 11 - soma2 % 11;

        return dig1 == Character.getNumericValue(cpf.charAt(9)) &&
                dig2 == Character.getNumericValue(cpf.charAt(10));
    }

    public static boolean validarEmail(String email) {
        String regex = "^[\\w-.]+@[\\w-]+\\.[a-z]{2,}$";
        return Pattern.matches(regex, email.toLowerCase());
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | CPF: " + cpf + " | Email: " + email;
    }
}
