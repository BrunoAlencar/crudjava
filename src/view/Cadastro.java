
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


public class Cadastro extends JFrame{
    private JButton buttonCadastrar = new JButton("Cadastrar");
    private JLabel labelNome = new JLabel("Nome");
    private JLabel labelEmail = new JLabel("Email");
    private JLabel labelTelefone = new JLabel("Telefone");
    private JLabel labelEspaco = new JLabel("");
    private JTextField textNome = new JTextField();
    private JTextField textEmail = new JTextField();
    private JTextField textTelefone = new JTextField();
    private Listener listener = new Listener();
    
    public Cadastro(){
        
        GridLayout layout = new GridLayout(4,2);
        this.setLayout(layout);
        this.add(labelNome);
        this.add(textNome);
        this.add(labelEmail);
        this.add(textEmail);
        this.add(labelTelefone);
        this.add(textTelefone);
        this.add(labelEspaco);
        this.add(buttonCadastrar);
        
        buttonCadastrar.addActionListener(listener);
        this.pack();
        this.setVisible(true);
    }
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String nome = String.valueOf(textNome.getText());
            String email = String.valueOf(textEmail.getText());
            String telefone = String.valueOf(textTelefone.getText());
            
                
                    if(e.getSource() == buttonCadastrar){
                    Aluno a = new Aluno(nome, email, telefone);
                        try{
                        new AlunoDAO().cadastrar(a);
                        }catch(Exception err){
                            System.out.println(err);
                        }
                    }
                            
        }            
    }
   
}
