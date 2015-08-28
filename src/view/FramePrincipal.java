
package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FramePrincipal extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuAluno = new JMenu("Aluno");
    private JMenuItem menuItemCadastrar = new JMenuItem("Cadastrar");
    private JMenuItem menuItemConsultar = new JMenuItem("Consultar");
    private JMenuItem menuItemAtualizar = new JMenuItem("Atualizar");
    private JMenuItem menuItemExcluir = new JMenuItem("Excluir");
    private JMenuItem menuItemSair = new JMenuItem("Sair");
    private Listener listener = new Listener();

    
    public FramePrincipal(){
        this.setTitle("Sistema Acadêmico");
        
        menuAluno.add(menuItemCadastrar);
        menuAluno.add(menuItemConsultar);
        menuAluno.add(menuItemAtualizar);
        menuAluno.add(menuItemExcluir);
        menuAluno.addSeparator();
        menuAluno.add(menuItemSair);
        
        menuItemCadastrar.addActionListener(listener);
        menuItemConsultar.addActionListener(listener);
        menuItemAtualizar.addActionListener(listener);
        menuItemExcluir.addActionListener(listener);
        menuItemSair.addActionListener(listener);
        
        menuBar.add(menuAluno);
        this.setJMenuBar(menuBar);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        
    }
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            if(e.getSource() == menuItemCadastrar){
                new Cadastro();
            }if(e.getSource() == menuItemConsultar){
                new Consultar();
            }if(e.getSource() == menuItemAtualizar){
                new Atualizar();
            }if(e.getSource() == menuItemExcluir){
                new Excluir();
            }if(e.getSource() == menuItemSair){
                System.exit(0);
            }
                            
        }            
    }
    public static void main(String[] args) {
        new FramePrincipal();
    }
}
