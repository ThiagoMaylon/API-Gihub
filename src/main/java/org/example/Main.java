package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Profile Github");
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setSize(500, 350);

        JLabel text = new JLabel();
        text.setText("Digite o Login!");
        text.setBounds(20, 30, 100, 20);

        JTextField textArea = new JTextField();
        textArea.setBounds(110, 30, 150, 20);

        JButton button = new JButton();
        button.setBounds(270, 30, 100, 20);
        button.setText("Encontrar");
        button.addActionListener(event -> {
            String login = textArea.getText();
            Profile profile = new Profile(login);
            profile.consumer();
            String mensage = "Nome: "+profile.getNome() +"\nId: "+profile.getId()+"\nEndereço: "+profile.getEndereco()+"\nBio: "+profile.getBio();
            JOptionPane.showMessageDialog(janela, mensage);
        });

        janela.setLayout(null);
        janela.getContentPane().add(text);
        janela.getContentPane().add(textArea);
        janela.getContentPane().add(button);
        janela.setVisible(true);

    }
}