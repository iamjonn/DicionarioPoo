package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

public class JPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblNewLabel; // Declarar o JLabel como campo da classe

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JPrincipal frame = new JPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 699, 481);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(42, 42, 42));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Botão de tradução para português
        JButton btnNewButton = new JButton("traduzir");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica de tradução pode ser implementada aqui
            }
        });
        btnNewButton.setBounds(127, 181, 169, 23);
        contentPane.add(btnNewButton);

        // ComboBox para selecionar idiomas
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "ingles", "espanhol", "alemao" }));
        comboBox.setBounds(221, 148, 95, 22);
        contentPane.add(comboBox);

        // JLabel para exibir a imagem
        lblNewLabel = new JLabel();
        lblNewLabel.setIcon(new ImageIcon(JPrincipal.class.getResource("/imagens/ingles.png")));
        lblNewLabel.setBounds(399, 130, 205, 87);
        contentPane.add(lblNewLabel);

        // Adicionar o ActionListener ao ComboBox
        Controller controller = new Controller(); // Instancia o controlador
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLanguage = (String) comboBox.getSelectedItem();
                controller.updateImage(lblNewLabel, selectedLanguage + ".png");
            }
        });

        // Botão de tradução para outro idioma
        JButton btnNewButton_1 = new JButton("BUSCAR");
        btnNewButton_1.setToolTipText("");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica de tradução pode ser implementada aqui
            }
        });
        btnNewButton_1.setBounds(465, 83, 79, 36);
        contentPane.add(btnNewButton_1);

        // Campo de texto para entrada do usuário
        textField = new JTextField();
        textField.setBounds(116, 83, 350, 36);
        contentPane.add(textField);
        textField.setColumns(10);

        // Área de texto para exibir a tradução
        JTextArea textArea = new JTextArea();
        textArea.setBounds(46, 228, 592, 182);
        contentPane.add(textArea);

        // Título da interface
        JLabel lblNewLabel_1 = new JLabel("DIGITE A PALAVRA QUE QUER TRADUZIR");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNewLabel_1.setBounds(106, 33, 473, 39);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Selecione o idioma:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1_1.setBounds(64, 141, 158, 33);
        contentPane.add(lblNewLabel_1_1);
    }
}
