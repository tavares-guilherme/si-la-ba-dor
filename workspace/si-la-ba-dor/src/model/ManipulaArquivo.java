package model;
import java.io.*;

public class ManipulaArquivo {
		
	static int indices[];   // Armazena os índices de busca, referente a cada número de sílabas.
	static int numPalavras; // Armazena o número de palavras salvas no arquivo.
	static int dificuldade;
	String nomeArquivo;
	
	public ManipulaArquivo(int nivel)
	{
		File dados;
		dificuldade = nivel;
		
		if(nivel < 1 || nivel > 3)
		{
			indices = null;
			numPalavras = 0;
		}
		
		/*
		 * 		A condicional abaixo verificá qual nível foi escolhido para selecionar o arquivo selecionado
		 * 	e instanciar o vetor "indices", visto que, como cada nível possui um valor diferente de números de
		 *  sílabas selecionados, seu tamanho será diferente para cada arquivo.
		 */
		switch(nivel) 
		{
			case 1:
				nomeArquivo = "nivel1.txt";
				indices = new int[2];
				break;
			case 2:
				nomeArquivo = "nivel2.txt";
				indices = new int[3];
				break;
			case 3:
				nomeArquivo = "nivel3.txt";
				indices = new int[3];
				break;
			default:
				nomeArquivo = null;
				break;
		}
		
		dados = new File(nomeArquivo);
		
		
		try(FileReader fr = new FileReader(dados);
			BufferedReader br = new BufferedReader(fr)){
			// Lê e armazena o cabeçalho do arquivo.
			numPalavras   = Integer.parseInt(br.readLine());
			
			int tamanho = indices.length;
			for(int i = 0; i < tamanho; i++)
				indices[i] = Integer.parseInt(br.readLine());
			
		}catch(IOException e)
		{
			e.fillInStackTrace();
		}
	}
	
	public Palavra recebePalavra(int silabas)
	{
		/*
		 * 		Método que, dado um número de sílabas, percorre o arquivo, e escolhe uma palavra aleatória
		 * 	da quantidade de sílabas fornecida.
		 */
		
		File    dados = new File(nomeArquivo); // Armazena o arquivo de texto.s
		Palavra nova = null;     // Contem o objeto "palavra" a ser retornado.
		Random r = new Random(); // Classe utilizada para gerar valores aleatórios.
		int tamanhoCabecalho = 0;// Armazena o tamanho do cabeçalho.
		int numSilabas;          // Armazena o número de sílabas da palavra.	
		int palavraEscolhida; 	 // Variável que armazenará quantas linhas deverão ser puladas para chegar a palavra escolhida aleatoriamente.
		
		if(silabas < 2 || silabas > 7) return null;
		
		numSilabas = silabas;
		
		// A condicional abaixo altera o número de sílabas, para a variável para acessar o vetor "indices".
		switch(dificuldade)
		{
			case 1:
				silabas -= 2;
				tamanhoCabecalho = 3;
				break;
			case 2:
				silabas -= 2;
				tamanhoCabecalho = 4;
				break;
			case 3:
				silabas -= 5;
				tamanhoCabecalho = 4;
				break;
		}
				
		try(FileReader fr = new FileReader(dados);
				BufferedReader br = new BufferedReader(fr)){
			
			// Pula o cabeçalho:
			for(int i = 0; i < tamanhoCabecalho; i++)
				br.readLine();

			// Agora devemos, ou não, pular as linhas no arquivo para chegar no numero de silabas solicitado.
			for(int i = 0; i < indices[silabas]; i++)
				br.readLine();

			/*
			 *  	Atribui, a variável palavraEscolhida, o número de palavras com a quantidade e sílabas escolhida
			 */
			if(silabas == indices.length - 1) palavraEscolhida = (numPalavras -indices[silabas]);
			else palavraEscolhida = (indices[silabas+1] - indices[silabas]);
			
			// Define, aleatoriamente, quantas linhas deverão ser puladas para escolher uma palavra.
			palavraEscolhida = r.getIntRand(palavraEscolhida);
			
			// Pula a quantidade definida de linhas
			for(int i = 0; i < palavraEscolhida; i++)
				br.readLine();
			
			// Instancia o objeto a ser retornado.
			nova = new Palavra(br.readLine().toCharArray(), numSilabas);			
		}catch(IOException e)
		{
			e.fillInStackTrace();
		}
		
		return nova;
	}
	
	public static void main(String[] args)
	{
		ManipulaArquivo log = new ManipulaArquivo(1);
		Palavra nova = log.recebePalavra(3);
		System.out.println(nova.toString());
	}
}
