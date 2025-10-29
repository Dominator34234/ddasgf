import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularzWeryfikacji extends JFrame {

    private JTextField poleWieku;
    private JCheckBox akceptacjaRegulaminu;
    private JButton przyciskZatwierdz;

    public FormularzWeryfikacji() {
        super("Formularz Weryfikacji");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(350, 150);

        // --- Utworzenie komponentów ---
        JLabel etykieta = new JLabel("Podaj wiek:");
        poleWieku = new JTextField(10);
        akceptacjaRegulaminu = new JCheckBox("Akceptuję regulamin");
        przyciskZatwierdz = new JButton("Zatwierdź");

        // --- Obsługa zdarzenia przycisku ---
        przyciskZatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int wiek = Integer.parseInt(poleWieku.getText()); // getText()
                    boolean regulamin = akceptacjaRegulaminu.isSelected(); // isSelected()

                    if (wiek >= 18 && regulamin) {
                        JOptionPane.showMessageDialog(FormularzWeryfikacji.this,
                                "Rejestracja pomyślna!",
                                "Sukces",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(FormularzWeryfikacji.this,
                                "Wymagany wiek 18+ i akceptacja regulaminu!",
                                "Błąd",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FormularzWeryfikacji.this,
                            "Podaj poprawny wiek (liczba całkowita)!",
                            "Błąd danych",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // --- Dodanie elementów do okna ---
        this.add(etykieta);
        this.add(poleWieku);
        this.add(akceptacjaRegulaminu);
        this.add(przyciskZatwierdz);

        this.setLocationRelativeTo(null); // Wyśrodkowanie okna
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormularzWeryfikacji::new);
    }
}
