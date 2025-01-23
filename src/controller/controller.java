package Controller;

import javax.swing.*;
import java.awt.*;

public class Controller {
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
}
