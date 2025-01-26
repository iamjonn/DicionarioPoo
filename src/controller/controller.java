package Controller;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Controller {

    // Método para atualizar a imagem no JLabel
    public void updateImage(JLabel label, String imageName) {
        try {
            String imagePath = "imagens/" + imageName;
            ImageIcon icon = new ImageIcon(getClass().getResource("/" + imagePath));
            Image scaledImage = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage));
            label.setText(""); // Remove texto
        } catch (Exception ex) {
            label.setText("Imagem não encontrada: " + imageName);
            label.setIcon(null);
        }
    }

    // Método para buscar uma palavra no arquivo CSV do idioma
    public ArrayList<String> buscarPalavra(String idioma, String termo) {
        ArrayList<String> resultados = new ArrayList<>();
        String filePath = "dados/" + idioma + ".csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.toLowerCase().contains(termo.toLowerCase())) { // Busca parcial, ignorando maiúsculas
                    resultados.add(linha);
                }
            }
        } catch (Exception ex) {
            resultados.add("Erro ao ler o arquivo: " + ex.getMessage());
        }

        return resultados;
    }
}
