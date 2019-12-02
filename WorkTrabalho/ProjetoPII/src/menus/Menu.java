package menus;
import javax.swing.JOptionPane;

public class Menu {

	public static int menu () {

		try {
			String menu = "Informe a opção que deseja referente a motos:"+
					"\n\nDigite 1 para -> Apresentar as motos com maior CC"+
					"\nDigite 2 para -> Ordenar as motos de acordo com a odometria"+
					"\nDigite 3 para -> Contabilizar a quantidade de motos de acordo com a cor"+
					"\nDigite 4 para -> Calcular o melhor custo benefício para aquisição"+
					"\nDigite 5 para -> Pesquisa por preço máximo e mínimo"+
					"\n\nDigite 0 para -> Sair do programa ";
			int opc = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
			return opc;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null , "Atenção: Digite valores númericos de 0 a 5 de acordo com as opções.\nObrigado!");
			return menu(); // chama o menu se o erro for inserção de caracteres ou valor nulo
		// REVER 
		}
	}
	
	
	public static int subMenu() {
		try {
			String menu = "Informe a opção que deseja referente a motos:"+
					"\n\nDigite 1 para -> Pesquisa por preço máximo"+
					"\nDigite 2 para -> Pesquisa por preço mínimo"+
					"\n\nDigite 0 para -> Sair do programa ";
			int opc = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
			return opc;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null , "Atenção: Digite valores númericos de 0 a 2 de acordo com as opções.\nObrigado!");
			return subMenu(); // chama o menu se o erro for inserção de caracteres ou valor nulo
		// REVER 
		}
	}

}
