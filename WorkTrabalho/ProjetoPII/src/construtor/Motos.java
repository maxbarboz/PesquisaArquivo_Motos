package construtor;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import App.DadosMotos;

public class Motos {

	private String motoCodigo = "";
	private String motoNome;
	private Double motoOdometria;
	private int motoCC;
	private String motoCor;

	public Motos(DadosMotos motos , int _i) {
		this.motoCodigo = motos.getMotoCodigo(_i);
		this.motoNome = motos.getMotoNome(_i);
		this.motoOdometria = motos.getMotoOdometria(_i);
		this.motoCC = motos.getMotoCC(_i);
		this.motoCor = motos.getMotoCor(_i);	
	}

	//métodos

	public static Motos [] testeMaiorCC(Motos [] _moto ) {
		Motos vetOrdenado[] = null;
		Motos[] aux = new Motos [1]; // uma posição, pois guarda uma moto
		int  i, j;
		if(_moto != null) {
			vetOrdenado = criaCopia(_moto);
			for (i = 1; i < vetOrdenado.length; i++) {
				aux[0] = vetOrdenado[i];
				for (j = i-1; j>=0 && vetOrdenado[j].motoCC>aux[0].motoCC; j--) {
					vetOrdenado[j+1] = vetOrdenado[j];
				}
				vetOrdenado[j+1] = aux[0];

			}
			toString(vetOrdenado);
		}
		return vetOrdenado;
	}
	
	public static Motos [] testeMaiorOdometria(Motos [] _moto ) {
		Motos vetOrdenado[] = null;
		Motos[] aux = new Motos [1]; // uma posição, pois guarda uma moto
		int  i, j;
		if(_moto != null) {
			vetOrdenado = criaCopia(_moto);
			for (i = 1; i < vetOrdenado.length; i++) {
				aux[0] = vetOrdenado[i];
				for (j = i-1; j>=0 && vetOrdenado[j].motoOdometria>aux[0].motoOdometria; j--) {
					vetOrdenado[j+1] = vetOrdenado[j];
				}
				vetOrdenado[j+1] = aux[0];

			}
			toString(vetOrdenado);
		}
		return vetOrdenado;
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

	public static void toString(Motos [] vetOrdenado) {
		String texto = "| Código \t| Nome \t\t\t| CC \t| Odometria \t| Cor \t\n\n";
		for (int i = vetOrdenado.length-1; i >= 0; i--) {
         texto += "| "+vetOrdenado[i].motoCodigo+" \t|"+vetOrdenado[i].motoNome+" \t\t| "+vetOrdenado[i].motoCC+" \t| "+vetOrdenado[i].motoOdometria+" \t| "+vetOrdenado[i].motoCor+" \t\n";
		}
		JTextArea JtxArea = new JTextArea(texto);
		JOptionPane.showMessageDialog(null, JtxArea);
		// O JTextArea é uma área para textos que pode conter várias linhas e várias colunas
	}

}
