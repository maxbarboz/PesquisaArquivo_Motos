package menus;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Scroll extends JFrame {
	public Scroll(String texto) {
		JTextArea caixaDeTexto = new JTextArea(texto); // O JTextArea é uma área para textos que pode conter várias linhas e várias colunas
		JScrollPane scroll = new JScrollPane(caixaDeTexto); // O JScrollPane adiciona um scroll de rolagem
		
		// configurações do scroll
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1250, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(scroll , JOptionPane.YES_NO_OPTION);
		
	}
}
