import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KineticEnergy extends JFrame {
    public JTextField kineticEnergy;

    public KineticEnergy() {
        setupUI();
    }

    private void setupUI() {
        GridBagConstraints constr = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();

        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Kinetic Energy Application");
        setLayout(layout);

        JLabel bodyWeight = new JLabel("Маса тіла: ");
        constr.gridx = 0;
        constr.gridy = 0;
        add(bodyWeight, constr);

        JTextField bodyWeightField = new JTextField(5);
        constr.gridx = 1;
        constr.gridy = 0;
        add(bodyWeightField, constr);

        JLabel bodyVelocity = new JLabel("Швидкість руху тіла: ");
        constr.gridx = 0;
        constr.gridy = 1;
        add(bodyVelocity, constr);

        JTextField bodyVelocityField = new JTextField(5);
        constr.gridx = 1;
        constr.gridy = 1;
        add(bodyVelocityField, constr);

        JButton calculateBtn = new JButton("Обчислити");
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateKineticEnergy(bodyWeightField, bodyVelocityField, kineticEnergy);
            }
        });
        constr.gridx = 0;
        constr.gridy = 2;
        add(calculateBtn, constr);

        JLabel resultLabel = new JLabel("Кінетична енергія: ");
        constr.gridx = 0;
        constr.gridy = 4;
        add(resultLabel, constr);

        kineticEnergy = new JTextField(5);
        constr.gridx = 1;
        constr.gridy = 4;
        add(kineticEnergy, constr);
        kineticEnergy.setEditable(false);

        setVisible(true);
    }

    private void calculateKineticEnergy(JTextField bodyWeightField, JTextField bodyVelocityField, JTextField kineticEnergyField) {
        try {
            double bodyWeight = Double.parseDouble(bodyWeightField.getText());
            double bodyVelocity = Double.parseDouble(bodyVelocityField.getText());

            double kineticEnergy = bodyWeight * Math.pow(bodyVelocity, 2) / 2;
            kineticEnergyField.setText(String.format("%.2f", kineticEnergy));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Будь ласка введіть натуральне число");
        }
    }

    public static void main(String[] args) {
        new KineticEnergy();
    }
}