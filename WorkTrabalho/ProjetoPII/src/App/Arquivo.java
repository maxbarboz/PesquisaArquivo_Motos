package App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Arquivo {	
	public String nomeLeitura;
	
	private InputStream is;
	private InputStreamReader in;
	private BufferedReader br;	
	
	public void setNomeLeitura(String nome) {
		this.nomeLeitura = nome;	
		abrirLeitura();
	}
	
	public int getTotalLinha() {
		int total = 0;
		
		if(is == null)
			return 0;
		else {
			while(this.pegaLinha() != null) {
				total++;
			}
		}
		
		abrirLeitura(); //inicializa novamente a leitura do arquivo
		return total;
	}
	
	public void abrirLeitura()  {
		try {
			is = new FileInputStream(nomeLeitura);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in = new InputStreamReader(is);
		br = new BufferedReader(in);
	}
	
	public String pegaLinha() {
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
	}
	
		
	public void fechar()  {
		if(br != null)
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
