package br.com.minimercado;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.emailUsuario.JavaMailApp;
import br.com.minimercadouser.Endereco;
import br.com.minimercadouser.Itens;
import br.com.minimercadouser.Pessoa;

public class MercadoMini {
	
	List<Pessoa> PESSOALISTA = new ArrayList<Pessoa>();
	List<Endereco> ENDERECOLISTA = new ArrayList<Endereco>();
	List<Itens> ITENSLISTA = new ArrayList<Itens>();

	Pessoa DADOSCLIENTES;
	Endereco ENDERECOCLIENTES;
	Itens ITENSCLIENTES;
	
	public void miniMercado() throws InterruptedException, IOException {
		dadosoClients();

	}

	private void dadosoClients() throws InterruptedException, IOException {
		
		Calendar c1 = Calendar.getInstance();
		int hora = c1.get(Calendar.HOUR_OF_DAY);

		int op = 3;
		
		if (hora > 6 && hora < 12) {
			JOptionPane.showMessageDialog(null, "Bom Dia", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
		} else if (hora > 12 && hora < 18) {
			JOptionPane.showMessageDialog(null, "Boa Tarde", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Boa Noite", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
		}
		

		do {
			
			op = Integer.parseInt(JOptionPane.showInputDialog(null, "\t\tMERCADO MINI\n\n1: Cadastrar Pedido\n2: Pedidos Cadastrados\n3: Enviar messagem por email\n4: Buscar pedido pelo cpf\n5: Sair\n\n", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

			if (op == 1) {

				DADOSCLIENTES = new Pessoa();
				ENDERECOCLIENTES = new Endereco();
				ITENSCLIENTES = new Itens();
				
				DADOSCLIENTES.setNome(JOptionPane.showInputDialog(null, "Nome", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

				DADOSCLIENTES.setEmail(JOptionPane.showInputDialog(null, "E-mail", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

				DADOSCLIENTES.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Idade", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE)));

				DADOSCLIENTES.setCpf(JOptionPane.showInputDialog(null, "Cpf", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

				JOptionPane.showMessageDialog(null, "ADICIONE O ENDEREÇO", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);

				ENDERECOCLIENTES.setRua(JOptionPane.showInputDialog(null, "Rua", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

				ENDERECOCLIENTES.setEstado(JOptionPane.showInputDialog(null, "Estado", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

				ENDERECOCLIENTES.setCep(Integer.parseInt(JOptionPane.showInputDialog(null, "Cep", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE)));

				ENDERECOCLIENTES.setTipoDeRecidencia(JOptionPane.showInputDialog(null, "Casa ou Apartamento", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

				if (ENDERECOCLIENTES.getTipoDeRecidencia().equals("apartamento")) {
					ENDERECOCLIENTES.setBloco(JOptionPane.showInputDialog(null, "Bloco", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));
					ENDERECOCLIENTES.setNumeroApartamento(JOptionPane.showInputDialog(null, "Numero", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));
				} else if (ENDERECOCLIENTES.getTipoDeRecidencia().equals("casa")) {
					ENDERECOCLIENTES.setCasa(Integer.parseInt(JOptionPane.showInputDialog(null, "Numero", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE)));
				}

				ENDERECOCLIENTES.setObservacao(JOptionPane.showInputDialog(null, "Alguma Obervação?", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

				JOptionPane.showMessageDialog(null, "FAÇA SEU PEDIDO", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);

				ITENSCLIENTES.setProduto(JOptionPane.showInputDialog(null, "Produto", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

				ITENSCLIENTES.setQuantidade(Double.parseDouble(JOptionPane.showInputDialog(null, "Quantidade", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE)));

				ITENSCLIENTES.setPreco(Double.parseDouble(JOptionPane.showInputDialog(null, "Preço", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE)));

				double TAXA = 2.10;
				double TOTAL = ITENSCLIENTES.getPreco() * ITENSCLIENTES.getQuantidade();
				double TOTALTAXA = TOTAL + TAXA;

				ITENSCLIENTES.setMarca(JOptionPane.showInputDialog(null, "Marca", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

				ITENSCLIENTES.setValorFinal(Double.parseDouble(JOptionPane.showInputDialog(null, "Valor final com juros R$ " + TOTALTAXA + "0 Reedigite o valor", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE)));
				
				if(ITENSCLIENTES.getValorFinal() == TOTALTAXA) {
					
					JOptionPane.showMessageDialog(null, "Valor Correto", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Reedigite o valor", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
					ITENSCLIENTES.setValorFinal(Double.parseDouble(JOptionPane.showInputDialog(null, "Valor final com juros R$ " + TOTALTAXA + "0 Reedigite o valor", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE)));
				}

				JOptionPane.showMessageDialog(null, "OBRIGADO!", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);

				PESSOALISTA.add(DADOSCLIENTES);
				ENDERECOLISTA.add(ENDERECOCLIENTES);
				ITENSLISTA.add(ITENSCLIENTES);

			} else if (op == 2) {
				if (PESSOALISTA.isEmpty() && ENDERECOLISTA.isEmpty() && ITENSLISTA.isEmpty()) {
					JOptionPane.showMessageDialog(null, "NENHUMA INFORMAÇÃO ENCONTRADA OU CADASTRADA, CLIQUE EM OK", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, PESSOALISTA.toString() + ENDERECOLISTA.toString() + ITENSLISTA.toString());
					JOptionPane.showMessageDialog(null, "CLICA EM OK, PARA CONTINUAR.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
					
					int RESP2;
					do {
						
					RESP2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria salvar as informações em um Txt?\n\n1: Para SIM\n2: Para NÃO\n\n", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));
					
					if(RESP2 == (1)) {
						gravaInfo();
					}else if(RESP2 == (2)) {
					    JOptionPane.showMessageDialog(null, "INFORMAÇÕES GRAVADAS COM SUCESSO, SEM UM TXT.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
					    Thread.sleep(2000);
					    dadosoClients();
					}else {
						JOptionPane.showMessageDialog(null, "Opção invalida, digite uma opção valida.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
					}
					}while(RESP2 != 0);
				}
			}else if(op == 3) {
				int RESP3;
				
				JavaMailApp email;
				email = new JavaMailApp();
				
				do {
					
				RESP3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de enviar uma menssagem por email?\n\n1: Para SIM\n2: Para NÃO\n\n", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));
				
				if (RESP3 == (1)) {

					String respEmail = JOptionPane.showInputDialog(null, "Gostaria de ver os Emails Cadastrado?", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);

					if (respEmail.equals("sim")) {
						if(PESSOALISTA.isEmpty()) {
							JOptionPane.showMessageDialog(null, "NENHUMA INFORMAÇÃO CADASTRADA, CLIQUE EM OK E VOLTE PARA MENU E CADASTRE UMA.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
						}else{
						JOptionPane.showMessageDialog(null, PESSOALISTA.toString(), "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
						email.emailUsuario();
						}
		
					} else {
						email.emailUsuario();
					}
				} else if (RESP3 == (2)) {
					dadosoClients();
				} else {
					JOptionPane.showMessageDialog(null, "Opção invalida 1 ou 2.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
				}

			} while (RESP3 != 0);
		
			} else if (op == 5) {
				int resposta = 0;

				do {
					
					resposta = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de sair mesmo?\n\n1: Para SIM\n2: Para NÃO\n\n", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE));

					if (resposta == (1)) {
						Thread.sleep(3000);
						JOptionPane.showMessageDialog(null, "aguarde....", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
						Thread.sleep(2000);
						JOptionPane.showMessageDialog(null, "SISTEMA ENCERRADO.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);

					} else if (resposta == (2)) {
						dadosoClients();
					} else {
						JOptionPane.showMessageDialog(null, "Opção invalida!", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
					}
				} while (resposta != 0);
			}else if(op == 4) {
				
				String pergt01 = "0";
				do {
					
				pergt01 = JOptionPane.showInputDialog(null, "Gostaria de ver os Cpf?", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
				
				if(pergt01.equals("sim")) {
					JOptionPane.showMessageDialog(null, DADOSCLIENTES.getCpf(), "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
				}else {
					
				}
			String codigoVerifica = JOptionPane.showInputDialog(null, "Digite o Cpf.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
			
			if(codigoVerifica.equals(DADOSCLIENTES.getCpf())) {
				JOptionPane.showMessageDialog(null, "Esse codigo seria de "+DADOSCLIENTES.getNome()+"\nPedido: "+ITENSCLIENTES.toString()+"\n\n", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
			}else if(codigoVerifica.equals(DADOSCLIENTES.getCpf())) {
				JOptionPane.showMessageDialog(null, "Codigo invalido", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Opçao Invalida, escolha uma opção do menu.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
			}
				}while(pergt01.equals("0"));
			} else{
				JOptionPane.showMessageDialog(null, "Opção invalida, digite uma opção valida.");
			}

		} while (op != 3);
	}

	private void gravaInfo() throws InterruptedException, IOException {
		
		String caminho = JOptionPane.showInputDialog(null, "Digite ou Copie e Cole o caminho que deseja que o arquivo seja salvo.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
		String nome = JOptionPane.showInputDialog(null, "Nome da pasta", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
		Thread.sleep(3000);
		JOptionPane.showMessageDialog(null, "Pasta gerada com sucesso!", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
		File file = new File(caminho+"\\"+nome);
		
		String txt = JOptionPane.showInputDialog(null, "Muito bem, agora digite o nome do arquivo Txt.", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
		File file2 = new File(caminho+"\\"+nome+"\\"+txt+".txt");
		Thread.sleep(3000);
		JOptionPane.showMessageDialog(null, "Txt gerado com sucesso!", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
		
		file.mkdirs();
		file.createNewFile();
		file2.createNewFile();

		FileWriter arq = new FileWriter(file2);
		PrintWriter gravarArq = new PrintWriter(arq);

		gravarArq.printf(PESSOALISTA.toString() + ENDERECOLISTA.toString() + ITENSLISTA.toString());

	     JOptionPane.showMessageDialog(null, "INFORMAÇÕES GRAVADAS COM SUCESSO", "Mini Mercado", JOptionPane.INFORMATION_MESSAGE);
		 arq.close();

	}
}
