package classes;


import java.util.Scanner;

public class Teste {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//INSTANCIAS DO SISTEMA
		Scanner entrada = new Scanner(System.in);
		
		//INSTANCIAS DAO
		EnderecoDAO enderecoDao = new EnderecoDAO();

		
		
		System.out.println("Entre com os dados do Endereço: ");
		
		//ENTRADA ENDEREÇO CLIENTE
			
		System.out.println("Cidade:  ");
		String cidade = entrada.next();
					
		System.out.println("Estado (UF): ");
		String estadoUf = entrada.next();
		
		System.out.println("Logradouro: ");
		String logradouro = entrada.next();
		
		System.out.println("Bairro: ");
		String bairro = entrada.next();
		
		System.out.println("Numero: ");
		String numero = entrada.next();
		
		entrada.close();
		
			
		Endereco endereco = new Endereco(cidade, estadoUf, logradouro, bairro, numero);
		enderecoDao.save(endereco);
				

	}

}
