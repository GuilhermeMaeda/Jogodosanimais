
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
	
	static No root = new No();
	
	static JButton pensei;
	
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
		
		pensei = new JButton ("Pensei");
		jfWindow.add(pensei);
		pensei.setBounds(95,50,100,30);
		
		
				No no = new No();
				root = no;
				no.value = "O animal que você pensou vive na água?";
				Buttonaction();
	}
	
	public static void adivinar(No raíz, String Animal){
		if (JOptionPane.showConfirmDialog(null, raíz.value, "Jogo dos animais", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

			Animal = raíz.answer;
			if (raíz.left != null) {
				adivinar(raíz.left, Animal);

			} else {
				if (JOptionPane.showConfirmDialog(null, "O animal que você pensou é o(a) " + Animal + "?",
						"Jogo dos animais", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					JOptionPane.showMessageDialog(null, "Acertei novamente!");
				} else {

					No no = new No();
					no.answer = JOptionPane.showInputDialog("Em que animal você pensou?");
					no.value = "O animal que você pensou "
							+ JOptionPane.showInputDialog("Um(a) " + no.answer + " _____ mas um " + Animal + " não.")
							+ "?";

					raíz.left = no;

				}
			}

		} else {

			if (raíz.right!= null) {
				adivinar(raíz.right, Animal);

			} else {
				if (JOptionPane.showConfirmDialog(null, "O animal que você pensou é o " + Animal + "?",
						"Jogo dos animais", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					JOptionPane.showMessageDialog(null, "Acertei de novo!");
				} else {

					No no = new No();
					no.answer = JOptionPane.showInputDialog("Em que animal você pensou?");
					no.value = "O animal que você pensou "
							+ JOptionPane.showInputDialog("Um(a) " + no.answer + " _____ mas um " + Animal + " não.")
							+ "?";

					raíz.right = no;

				}
			}

		}
		
	}
	static void Buttonaction(){
		pensei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		if (JOptionPane.showConfirmDialog(null, root.value, "Jogo dos Animais",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			      if(root.left!=null){
			    	  adivinar(root.left,"Tubarão");
			      } else {
			    	  int shark = JOptionPane.showConfirmDialog(null, "O animal que você pensou é o Tubarão?");
			    	  if(shark == JOptionPane.YES_OPTION){
			    		  JOptionPane.showMessageDialog(null, "Acertei de novo!");
			    		  //Tela();
			    	  } else {
			    	  No no = new No();
			  		  no.answer = JOptionPane.showInputDialog("Em que animal você pensou?");
			  		  no.value = "O animal que você pensou " + JOptionPane.showInputDialog("Um(a) " + no.answer + " _____ mas um tubarão não.")+ "?";
			  		  root.left = no;
			    	  }
			        }
		} else {
			if(root.right!=null){
		    	  adivinar(root.right,"Macaco");
		      } else {
		    	  int monkey = JOptionPane.showConfirmDialog(null, "O animal que você pensou é o Macaco?");
		    	  if(monkey == JOptionPane.YES_OPTION){
		    		  JOptionPane.showMessageDialog(null, "Acertei de novo!");
		    	  } else {
		    		  No no = new No();
		    		  no.answer = JOptionPane.showInputDialog("Em que animal você pensou?");
		    		  no.value = "O animal que você pensou "+ JOptionPane.showInputDialog("Um(a) " + no.answer + " _____ mas um macaco não.")+ "?";
		    		  root.right = no;
		    		  
		    	   }
		         }
		       }
			}
		});
  }
}

