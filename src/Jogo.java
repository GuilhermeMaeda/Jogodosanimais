
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Jogo {

    static Font letra = new Font ("ARIAL",Font.BOLD,15);
	static JFrame jfWindow;
	
	static JTextField jtfAnimal;
	
	
	public static void main(String[] args) {
	      Tela();
	}

	public static void Tela (){
		jfWindow = new JFrame();
		jfWindow.setTitle("Jogo dos Animais");
		jfWindow.setSize(300,150);
		jfWindow.setLayout(null);
		jfWindow.setResizable(false);
		jfWindow.setLocationRelativeTo(null);
		jfWindow.setVisible(true);
		jfWindow.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JLabel pergunta = new JLabel ("Pense em um animal");
		jfWindow.add(pergunta);
		pergunta.setFont(letra);
		pergunta.setBounds(75, 0, 150, 50);
		
		JButton pensei = new JButton ("Pensei");
		jfWindow.add(pensei);
		pensei.setBounds(95,50,100,30);
		
		pensei.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				jfWindow.setVisible(false);
				No.root = "O animal que você pensou vive na água?";
				Buttonaction();
			}
		});
	}
	
	public static void advinha(No tree, String Animal){
		if (JOptionPane.showConfirmDialog(null, No.newAnimal, "Advinhar animal", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			Animal = No.answer;
			if (No.esquerda !=null){
				advinha(No.esquerda, Animal);
			} else{
				if (JOptionPane.showConfirmDialog(null, "O animal que você pensou é o " + Animal + "?",
						"Jogo dos animais", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					JOptionPane.showMessageDialog(null, "Acertei novamente!");
					Tela();
				} else {

					No no = new No();
					No.answer = JOptionPane.showInputDialog("Qual é o animal que você pensou?");
					//No.newAnimal = JOptionPane.showInputDialog("Um(a) " + No.answer + "_________, mas um "+ Animal + " não!");
					no.valor = "O animal que você pensou "
							+ JOptionPane.showInputDialog("Um(a) " + no.newAnimal + " _____ mas um " + Animal + " não.")
							+ "?";
					No.esquerda = no;

				}
			}
		} else {
			if (tree.direita != null) {
				advinha(tree.direita, Animal);

			} else {
				if (JOptionPane.showConfirmDialog(null, "O animal que você pensou é o " + Animal + "?",
						"Jogo dos animais", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					JOptionPane.showMessageDialog(null, "Acertei novamente!");
					Tela();
				} else {

					No no = new No();
					no.answer = JOptionPane.showInputDialog("Qual é o animal que você pensou?");
					No.newAnimal = JOptionPane.showInputDialog("Um(a) " + No.answer + "_________, mas um "+ Animal + " não!");

					tree.direita = no;

				}
			}
		}
		
	}
	static void Buttonaction(){
		if (JOptionPane.showConfirmDialog(null, No.root, "Jogo dos Animais",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			      if(No.esquerda!=null){
			    	  advinha(No.esquerda,"Tubarão");
			      } else {
			    	  int shark = JOptionPane.showConfirmDialog(null, "O animal que você pensou é o Tubarão?");
			    	  if(shark == JOptionPane.YES_OPTION){
			    		  JOptionPane.showMessageDialog(null, "Acertei novamente!");
			    		  Tela();
			    	  } else {
			    	  No no = new No();
			  		  No.answer = JOptionPane.showInputDialog("Em que animal você pensou?");
			  		  No.newAnimal = JOptionPane.showInputDialog("Um(a) " + No.answer + "_________, mas um Tubarão não!");
			  		  No.esquerda = no;
			  		  Tela(); 
			    	  }
			        }
		} else {
			if(No.direita!=null){
		    	  advinha(No.direita,"Macaco");
		      } else {
		    	  int monkey = JOptionPane.showConfirmDialog(null, "O animal que você pensou é o Macaco?");
		    	  if(monkey == JOptionPane.YES_OPTION){
		    		  JOptionPane.showMessageDialog(null, "Acertei novamente!");
		    		  Tela();
		    	  } else {
		    		  No no = new No();
		    		  No.answer = JOptionPane.showInputDialog("Em que animal você pensou?");
		    		  No.newAnimal = JOptionPane.showInputDialog("Um(a) " + No.answer + "_________, mas um Macaco não!");
		    		  No.direita = no;
		    		  Tela();
		    	  }
		        }
		}
			
	}
}

