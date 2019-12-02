package construtor;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.lang.reflect.Array;

import javax.swing.JFrame;
import java.text.DecimalFormat;
import java.util.ArrayList;

import App.DadosMotos;

public class Motos {

	private String motoCodigo = "";
	private String motoNome;
	private Double motoOdometria;
	private int motoCC;
	private String motoCor;
	private double motoValor;

	// atributo que armazena o valor de custo beneficio
	private Double custoBeneficio;

	public Motos(DadosMotos motos , int _i) {
		this.motoCodigo = motos.getMotoCodigo(_i);
		this.motoNome = motos.getMotoNome(_i);
		this.motoOdometria = motos.getMotoOdometria(_i);
		this.motoCC = motos.getMotoCC(_i);
		this.motoCor = motos.getMotoCor(_i);	
		this.motoValor = motos.getMotoValor(_i);
		this.custoBeneficio = motos.getMotoCustoBeneficio(_i);
	}

	//métodos

	public static void testeMaiorCC(Motos [] _moto ) {
		Motos motoOrdenado[] = null;
		Motos[] aux = new Motos [1]; // uma posição, pois guarda uma moto
		int  i, j;
		if(_moto != null) {
			motoOrdenado = criaCopia(_moto);
			for (i = 1; i < motoOrdenado.length; i++) {
				aux[0] = motoOrdenado[i];
				for (j = i-1; j>=0 && motoOrdenado[j].motoCC>aux[0].motoCC; j--) {
					motoOrdenado[j+1] = motoOrdenado[j];
				}
				motoOrdenado[j+1] = aux[0];

			}
		}
		toStringMaior(motoOrdenado);
	}

	public static void testeMaiorOdometria(Motos [] _moto ) {
		Motos motoOrdenado[] = null;
		Motos[] aux = new Motos [1]; // uma posição, pois guarda uma moto
		int  i, j;
		if(_moto != null) {
			motoOrdenado = criaCopia(_moto);
			for (i = 1; i < motoOrdenado.length; i++) {
				aux[0] = motoOrdenado[i];
				for (j = i-1; j>=0 && motoOrdenado[j].motoOdometria>aux[0].motoOdometria; j--) {
					motoOrdenado[j+1] = motoOrdenado[j];
				}
				motoOrdenado[j+1] = aux[0];

			}
		}
		toStringMaior(motoOrdenado);
	}

	public static Motos [] testeMaiorMenor(Motos [] _moto ) {
		Motos motoOrdenado[] = null;
		Motos[] aux = new Motos [1]; // uma posição, pois guarda uma moto
		int  i, j;
		if(_moto != null) {
			motoOrdenado = criaCopia(_moto);
			for (i = 1; i < motoOrdenado.length; i++) {
				aux[0] = motoOrdenado[i];
				for (j = i-1; j>=0 && motoOrdenado[j].motoValor>aux[0].motoValor; j--) {
					motoOrdenado[j+1] = motoOrdenado[j];
				}
				motoOrdenado[j+1] = aux[0];
			}
		}
		return motoOrdenado;
	}

	public static void testeCustoBeneficio(Motos [] _moto ) {
		Motos motoOrdenado[] = null;
		Motos[] aux = new Motos [1]; // uma posição, pois guarda uma moto
		int  i, j;
		if(_moto != null) {
			motoOrdenado = criaCopia(_moto);
			for (i = 1; i < motoOrdenado.length; i++) {
				aux[0] = motoOrdenado[i];
				for (j = i-1; j>=0 && motoOrdenado[j].custoBeneficio>aux[0].custoBeneficio; j--) {
					motoOrdenado[j+1] = motoOrdenado[j];
				}
				motoOrdenado[j+1] = aux[0];
			}
		}
		Motos.toStringMaior(motoOrdenado);
	}

	public static void testeQuantidadeCor(Motos [] _moto) {
		boolean teste = false;
		ArrayList<String> cores = new ArrayList();
		cores.add(_moto[0].motoCor);
		int tamanho;

		for (int i = 1; i < _moto.length; i++) {
			tamanho = cores.size();
			teste = false;
			for (int k = 0; k < tamanho && teste == false; k++) {
				if(cores.get(k).equalsIgnoreCase(_moto[i].motoCor)) {
					teste = true;
				}
			}
			if(teste == false) {
				adicionaCor(_moto[i].motoCor, cores);
			}
		}

		quantidadeCor(cores, _moto);

	}
	
	public static void quantidadeCor(ArrayList cores, Motos [] _moto) {
		int tamanho = cores.size();
		int [] somaCores = new int [tamanho];
		
		for (int i = 0; i < _moto.length; i++) {
			for (int k = 0; k < tamanho; k++) {
				if(cores.get(k).equals(_moto[i].motoCor)) {
					somaCores[k]++;
				}
			}
		}
		toStringCores(cores, somaCores);	
	}

	private static void adicionaCor(String cor, ArrayList cores) {
		cores.add(cor);
	}

	public static Motos [] criaCopia(Motos vet[]) {
		Motos [] vetorOrdenado = null;
		if(vet != null) {
			vetorOrdenado = new Motos[vet.length];
			for (int i = 0; i < vetorOrdenado.length; i++) {
				vetorOrdenado[i] = vet[i];
			}
		}
		return vetorOrdenado;
	}
	
	// to string de cores
	public static void toStringCores(ArrayList cores, int [] somaCores) {
		
		String texto = "| Cores \t\t\t| Quantidade\n\n";
		for (int i = 0; i< somaCores.length; i++) {
			texto += cores.get(i) + " \t\t\t "+somaCores[i]+" uni\n";
		}
		JTextArea JtxArea = new JTextArea(texto);
		JOptionPane.showMessageDialog(null, JtxArea);
		// O JTextArea é uma área para textos que pode conter várias linhas e várias colunas
	}

	// to string para exibição do maior valor de motos
	public static void toStringMaior(Motos [] motoOrdenado) {
		// uso de decimal format para a impressãp do custo beneficio com apenas duas casas decimais
		DecimalFormat df = new DecimalFormat("#00.00");

		String texto = "| Código \t| Nome \t\t\t\t\t\t| CC \t| Odometria \t| Preço R$ \t| Cor \t |Custo Benefício\n\n";
		for (int i = motoOrdenado.length-1; i >= 0; i--) {
			texto += "| "+motoOrdenado[i].motoCodigo+" \t"+
					identacaoQuebra(motoOrdenado[i].motoNome)+" \t\t| "+
					motoOrdenado[i].motoCC+" \t| "+
					motoOrdenado[i].motoOdometria+" \t| "+
					motoOrdenado[i].motoValor+" \t| "+
					motoOrdenado[i].motoCor+" \t|"+
					df.format(motoOrdenado[i].custoBeneficio)+"\n";
		}
		JTextArea JtxArea = new JTextArea(texto);
		JOptionPane.showMessageDialog(null, JtxArea);
		// O JTextArea é uma área para textos que pode conter várias linhas e várias colunas
	}


	// to string para exibição do menor valor de motos
	public static void toStringMenor(Motos [] motoOrdenado) {
		// uso de decimal format para a impressãp do custo beneficio com apenas duas casas decimais
		DecimalFormat df = new DecimalFormat("#00.00");

		String texto = "| Código \t| Nome \t\t\t\t\t\t\t| CC \t| Odometria \t| Preço R$ \t| Cor \t |Taxa de Custo Benefício\n\n";
		for (int i = 0; i < motoOrdenado.length; i++) {
			texto += "| "+motoOrdenado[i].motoCodigo+" \t"+
					identacaoQuebra(motoOrdenado[i].motoNome)+" \t\t\t| "+
					motoOrdenado[i].motoCC+" \t| "+
					motoOrdenado[i].motoOdometria+" \t| "+
					motoOrdenado[i].motoValor+" \t| "+
					motoOrdenado[i].motoCor+" \t|"+
					df.format(motoOrdenado[i].custoBeneficio)+"\n";;
		}
		JTextArea JtxArea = new JTextArea(texto);
		JOptionPane.showMessageDialog(null, JtxArea);

	}

	// método de identação ( quebra de string )
	public static String identacaoQuebra(String motoOrdenado) {
		int tamanhoString = 35; // 35 será o tamanho padrão para as strings
		String [] identacao = new String [tamanhoString];

		identacao = motoOrdenado.split("");

		return identacaoJuncao(identacao, tamanhoString);
	}

	// método de identação ( junção de string )
	public static String identacaoJuncao(String [] identacao, int tamanhoString) {
		String identacaoText = "";

		for (int i = 0; i < tamanhoString; i++) {
			try {
				identacaoText += identacao[i]+" ";
			} catch (Exception e) {
				identacaoText += "   ";
			}
		}
		return identacaoText;
	}

}