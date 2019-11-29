package App;
import javax.swing.JOptionPane;

import construtor.Motos;
import menus.Menu;

public class AppDados {

	public static void main(String[] args) {

		//------- TRABALHO DE P2
		//------- Prof(s): Archimedes e Miltin
		//------- 2019

		final int tamanhoArquivo = 20952; // tamanho máximo de arquivos txt
		int tamanhoDados = getQtoMotos(tamanhoArquivo); // pergunta quantos dados se quer análisar

		DadosMotos motos = new DadosMotos("motos.txt", tamanhoDados);

		Motos [] moto= new Motos [tamanhoDados];

		for (int i = 0; i < moto.length; i++) {
			moto [i] = new Motos(motos, i);
		}

		int opcao = Menu.menu();
		
		int [] teste = new int[tamanhoArquivo];

		switch (opcao) {
		case 1:
			Motos.testeMaiorCC(moto);
			//Apresentar as motos com maior CC
			break;
		case 2:
			Motos.testeMaiorOdometria(moto);
			//Ordenar as motos de acordo com a odometria
			break;
		case 3:
			//Contabilizar a quantidade de motos de acordo com a cor
			break;
		case 4:
			//Calcular o melhor custo benefício para aquisição
			break;
		case 5:
			//Pesquisa por preço máximo e mínimo
			break;
		case 0:
			JOptionPane.showMessageDialog(null , "Programa finalizado pelo usuário");
			break;
		default:
			JOptionPane.showMessageDialog(null , "Atenção: Digite valores númericos de 0 a 5 de acordo com as opções.\nObrigado!");
			Menu.menu(); // chama o menu se o número informado for negativo ou >5
			break;
		}
	}

	// método de inserção da quantidade de valores que seram carregado do arquivo txt
	public static int getQtoMotos(int _tamanhoArquivo) {
		int qtoMotos = 0 ; int tamanhoArquivo = _tamanhoArquivo;
		try {
			do {
				qtoMotos= Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas motos deseja pesquisar?"));	
				if(qtoMotos <= 0 || qtoMotos > tamanhoArquivo) {
					JOptionPane.showMessageDialog(null, "Erro ! Informe um valor maior que zero, inteiro e menor que "+tamanhoArquivo+" que é o tamanho máximo de dados.");
				}
			}while (qtoMotos <= 0 || qtoMotos > tamanhoArquivo);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ! Informe um valor numérico, maior que zero e inteiro.");
			getQtoMotos(tamanhoArquivo);
		}
		return qtoMotos;
	}

}

