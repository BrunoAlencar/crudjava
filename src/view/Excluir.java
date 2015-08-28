package view;

import db.AlunoDAO;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Aluno;

public class Excluir extends JFrame {

  
    private JLabel labelId = new JLabel("Digite o id");
    private JTextField textId = new JTextField();
    private JButton buttonExcluir = new JButton("Excluir");
    private Listener listener = new Listener();

    public Excluir() {
        GridLayout layout = new GridLayout(1, 3);
        this.setLayout(layout);
        this.add(labelId);
        this.add(textId);
        this.add(buttonExcluir);

        buttonExcluir.addActionListener(listener);

        this.pack();
        this.setVisible(true);
    }

    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Integer id = Integer.parseInt(textId.getText());

            if (e.getSource() == buttonExcluir) {

                try {
                    Aluno a = new AlunoDAO().consultar(id);
                    new AlunoDAO().excluir(a);
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        }
    }
  
    
}
