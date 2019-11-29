package App;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DadosMotos {

	String nomeArquivo;
	int totalLinhasParaLeitura;

	//-- dados das motos
	String[] motoCodigo;
	String[] motoNome;
	double[] motoOdometria;
	int[] motoCC;
	String[] motoCor;
	String [] codNaoSei; // código que eu nem sei oque é

	public DadosMotos(String arquivo, int linhas) {
		this.nomeArquivo = arquivo;
		this.totalLinhasParaLeitura = linhas;
		abrirArquivo();
	}

	private void abrirArquivo() {
		Arquivo arquivo = new Arquivo();
		arquivo.setNomeLeitura("arquivos/" + this.nomeArquivo);

		int total = arquivo.getTotalLinha();
		if(this.totalLinhasParaLeitura > total || this.totalLinhasParaLeitura == -1)
			this.totalLinhasParaLeitura = total;

		JOptionPane.showMessageDialog(null, "Abrindo arquivo: \t" + this.nomeArquivo +"\n\n▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ 100%\nDados carregados com sucesso");		
		carregarMotos(arquivo);
	}


	private void carregarMotos(Arquivo arquivo) {
		motoCodigo = new String[this.totalLinhasParaLeitura];
		motoNome  = new String[this.totalLinhasParaLeitura];
		motoOdometria  = new double[this.totalLinhasParaLeitura];
		motoCC  = new int[this.totalLinhasParaLeitura];
		motoCor = new String[this.totalLinhasParaLeitura];
		codNaoSei = new String [this.totalLinhasParaLeitura];

		for(int k=0; k<totalLinhasParaLeitura; k++) {
			//System.out.println(k + "\t" + arquivo.pegaLinha());
			String linha = arquivo.pegaLinha();
			String[] info = linha.split(";");

			//-- quebra a linha com o sperador ";"
			motoCodigo[k] = info[0];
			motoNome[k] = info[1];
			motoOdometria[k] = Double.parseDouble(info[2]);
			motoCC[k] = (int) Double.parseDouble(info[3]);
			codNaoSei[k]= info[4]; // código que eu nem sei oque é
			motoCor[k] = info[5];
		}				
	}


	// gets
	public String getMotoCodigo(int i) {
		return motoCodigo[i];
	}

	public String getMotoNome(int i) {
		return motoNome[i];
	}

	public double getMotoOdometria(int i) {
		return motoOdometria[i];
	}

	public int getMotoCC(int i) {
		return motoCC[i];
	}

	public String getMotoCor(int i) {
		return motoCor[i];
	} 

}
