import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 1. TOP-LEVEL CONTAINER: JFrame
public class MainGUI extends JFrame {

    public MainGUI() {
        super("Eksplorasi GUI Java - Muzakir Mataho (F1D02510018)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);

        // 4. LAYOUT CLASS #1: BorderLayout (susunan utama frame)
        setLayout(new BorderLayout(10, 10));

        // 2. INTERMEDIATE CONTAINER: JPanel (3 panel)
        // Layout #2: FlowLayout (panel header)
        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Layout #3: GridLayout (panel konten)
        JPanel panelKonten = new JPanel(new GridLayout(3, 1, 5, 5));
        // Layout #2 lagi: FlowLayout (panel tombol)
        JPanel panelTombol = new JPanel(new FlowLayout());

        panelKonten.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        // 3. ATOMIC COMPONENT: JLabel, JTextField, JButton
        JLabel lblJudul = new JLabel("Eksplorasi GUI Java");
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 18));

        JLabel lblNama = new JLabel("Masukkan nama:", SwingConstants.CENTER);
        JTextField txtNama = new JTextField();
        JLabel lblHasil = new JLabel("Klik tombol Sapa", SwingConstants.CENTER);

        JButton btnSapa = new JButton("Sapa");
        JButton btnReset = new JButton("Reset");

        panelHeader.add(lblJudul);
        panelKonten.add(lblNama);
        panelKonten.add(txtNama);
        panelKonten.add(lblHasil);
        panelTombol.add(btnSapa);
        panelTombol.add(btnReset);

        // 5. EVENT LISTENER (a): ActionListener (Interface)
        btnSapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText().trim();
                lblHasil.setText(nama.isEmpty() ? "Nama belum diisi!" : "Halo, " + nama + "!");
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                lblHasil.setText("Klik tombol Sapa");
            }
        });

        // 5. EVENT LISTENER (b): MouseAdapter (Adapter Class)
        MouseAdapter hover = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ((JButton) e.getSource()).setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JButton) e.getSource()).setBackground(null);
            }
        };
        btnSapa.addMouseListener(hover);
        btnReset.addMouseListener(hover);

        // Pasang panel ke frame
        add(panelHeader, BorderLayout.NORTH);
        add(panelKonten, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}