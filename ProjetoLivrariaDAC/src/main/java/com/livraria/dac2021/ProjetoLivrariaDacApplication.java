package com.livraria.dac2021;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import com.livraria.dac2021.controllers.AutorController;
import com.livraria.dac2021.controllers.ClienteController;
import com.livraria.dac2021.controllers.LivroController;
import com.livraria.dac2021.controllers.PedidoController;
import com.livraria.dac2021.model.Autor;
import com.livraria.dac2021.model.Cliente;
import com.livraria.dac2021.model.Livro;
import com.livraria.dac2021.model.Pedido;


@SpringBootApplication
public class ProjetoLivrariaDacApplication implements CommandLineRunner{
	private final AutorController autorController;
	private final ClienteController clienteController;
	private final LivroController livroController;
	private final PedidoController pedidoController;
	
	public ProjetoLivrariaDacApplication(AutorController autorController, ClienteController clienteController, LivroController livroController, PedidoController pedidoController) {
		this.livroController=livroController;
		this.pedidoController=pedidoController;
		this.autorController=autorController;
		this.clienteController=clienteController;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoLivrariaDacApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		int opcao=0;
		
		Scanner leitor = new Scanner(System.in);
		
		while (opcao!=15) {

			System.out.println(
					"1.Cadastrar Novo Usuário\n" 
					+"2.Pesquisar Email\n"
					+"3.Cadastrar Autor\n" 
					+"4.Alterar Autor\n"
					+"5.Cadastrar Livro\n"
					+"6.Editar Livro\n" 
					+"7.Excluir Livro\n" 
					+"8.Pesquisar Livro\n" 
					+"9.Consultar Todos os Livros\n"
					+"10.Consultar Livros em Estoque\n"
					+"11.Consultar Livros sem Estoque\n"
					+"12.Adicionar Livro ao Estoque\n"
					+"13.Consultar Livros Mais Baratos em Estoque\n"
					+"14.Adicionar Livro ao Carrinho\n"
					+"15.Sair");
			System.out.println("Escolha uma opção: ");
			
			opcao = Integer.parseInt(leitor.nextLine());

			if (opcao == 1) {
				System.out.println("Digite o Email : ");
				String email = leitor.nextLine();
				System.out.println("Digite a Senha: ");
				String senha = leitor.nextLine();
				System.out.println("Digite o Nome : ");
				String nome = leitor.nextLine();
				System.out.println("Digite o Cpf : ");
				String cpf = leitor.nextLine();
				System.out.println("Digite o Endereço : ");
				String endereco = leitor.nextLine();
				System.out.println("Digite o CEP : ");
				String cep = leitor.nextLine();
				System.out.println("Digite o telefone : ");
				String telefone = leitor.nextLine();
				Cliente cliente = new Cliente(email,senha,nome,cpf,endereco,cep,telefone);
				clienteController.save(cliente);
				System.out.println("Autor salvo!");

			}
			else if (opcao == 2) {
				System.out.println("Digite o Email do Cliente que Deseja Consultar : ");
				String email = leitor.nextLine();
				Optional<Cliente> consulta =  clienteController.findByEmail(email);
				if(consulta.isPresent()) {
					Cliente cliente = consulta.get();
					System.out.println(cliente.getNome());
				}
				else {
					System.err.println("Email inexistente");
				}
			} 
			
			else if (opcao == 3) {
				System.out.println("Digite o nome do autor: ");
				String nome = leitor.nextLine();
				System.out.println("Digite a nacionalidade do autor : ");
				String nac = leitor.nextLine();
				System.out.println("Digite a biografia do autor : ");
				String bio = leitor.nextLine();
				Autor autor = new Autor(nome,nac,bio);
				autorController.save(autor);
			
			} 
			else if (opcao == 4) {
				System.out.println("Digite o id do autor: ");
				Integer id = Integer.parseInt(leitor.nextLine());
				Optional<Autor> op = autorController.findById(id);
				if (op.isPresent()) {
					Autor autor = op.get();
					System.out.println("Digite o nome do autor: ");
					autor.setNome(leitor.nextLine());
					System.out.println("Digite a nacionalidade do autor : ");
					autor.setNacionalidade(leitor.nextLine());
					System.out.println("Digite a biografia do autor : ");
					autor.setBiografia(leitor.nextLine());
					autorController.update(autor);
				}
				else {
					System.err.println("Autor não encontrado");
				}
			} 
			else if (opcao == 5) {
				
				System.out.println("Digite o título do livro: ");
				String titulo = leitor.nextLine();
				System.out.println("Digite o preço do livro: ");
				Double preco =Double.parseDouble(leitor.nextLine());
				System.out.println("Quantos autores o livro possui? : ");
				ArrayList <Autor> autores = new ArrayList<>();
				for (int i=0; i<Integer.parseInt(leitor.nextLine());i++) {
					System.out.println("Digite o id do"+String.valueOf(i)+" autor: ");
					autores.add(autorController.findById(Integer.parseInt(leitor.nextLine())).get());
				}
				System.out.println("Digite o isbn do livro: ");
				String isbn = leitor.nextLine();
				System.out.println("Digite o descrição do livro: ");
				String descricao = leitor.nextLine();
				System.out.println("Digite a edição do livro: ");
				String edicao = leitor.nextLine();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
				System.out.println("Digite o isbn do livro: ");
				Date data = formato.parse(leitor.nextLine());
				Livro livro = new Livro(titulo,isbn,descricao,edicao,preco,autores,data);
				livroController.save(livro);
				
			} 
			
			else if (opcao == 6) {
				System.out.println("Digite o id do livro: ");
				Integer id = Integer.parseInt(leitor.nextLine());
				Optional<Livro> op = livroController.findById(id);
				if (op.isPresent()) {
					Livro livro = op.get();
					System.out.println("Digite o título do livro: ");
					livro.setTitulo(leitor.nextLine());
					System.out.println("Digite o preço do livro: ");
					livro.setPreco(Double.parseDouble(leitor.nextLine()));
					System.out.println("Quantos autores o livro possui? : ");
					ArrayList <Autor> autores = new ArrayList<>();
					for (int i=0; i<Integer.parseInt(leitor.nextLine());i++) {
						System.out.println("Digite o id do"+String.valueOf(i)+" autor: ");
						autores.add(autorController.findById(Integer.parseInt(leitor.nextLine())).get());
					}
					livro.setAutores(autores);
					System.out.println("Digite o isbn do livro: ");
					livro.setIsbn(leitor.nextLine());
					System.out.println("Digite o descrição do livro: ");
					livro.setDescricao(leitor.nextLine());
					System.out.println("Digite a edição do livro: ");
					livro.setEdicao(leitor.nextLine());
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
					System.out.println("Digite o isbn do livro: ");
					livro.setLancamento(formato.parse(leitor.nextLine()));
				}
				else {
					System.err.println("Livro não Encontrado");
				}
			} 
			
			else if (opcao == 7) {
				System.out.println("Digite o id do livro: ");
				Integer id = Integer.parseInt(leitor.nextLine());
				Optional<Livro> op = livroController.findById(id);
				if(op.isPresent()) {
					livroController.delete(op.get());
				}
				else {
					System.err.println("Livro não Encontrado");
				}
			} 
			
			else if (opcao == 8) {
				System.out.println("Digite o id do livro: ");
				Integer id = leitor.nextInt();
				Optional<Livro> op = livroController.findById(id);
				if(op.isPresent()) {
					Livro livro = op.get();
					System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
				}
				else {
					System.err.println("Livro não Encontrado");
				}
			}
			else if (opcao == 9) {
				int pag = 0;
				Page<Livro> livros = livroController.findAllByPage(pag);
				for (Livro livro:livros) {
					System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
				}
				int op1 = 0;
				while (op1!=4) {
					System.out.println(
							"1.Próxima Página\n" 
							+"2.Página Anterior\n"
							+"3.Ir para Página especifica\n"
							+"4.Sair\n");
					op1= Integer.parseInt(leitor.nextLine());
					if(op1==1) {
						pag+=1;
						livros = livroController.findAllByPage(pag);
						for (Livro livro:livros) {
							System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
						}
					}
					else if(op1==2) {
						pag-=1;
						livros = livroController.findAllByPage(pag);
						for (Livro livro:livros) {
							System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
						}
					}
					else if(op1==3) {
						System.out.println("Digite a página que deseja acessar: ");
						pag = Integer.parseInt(leitor.nextLine());
						livros = livroController.findAllByPage(pag);
						for (Livro livro:livros) {
							System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
						}
					}
					else if(op1==4) {
						break;
					}
					else {
						System.err.println("Opção inválida");
					}
				}
						
				
			}
			else if (opcao == 10) {
				int pag = 0;
				Page<Livro> livros = livroController.findAllByPageInEstoque(pag);
				for (Livro livro:livros) {
					System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
				}
				int op1 = 0;
				while (op1!=4) {
					System.out.println(
							"1.Próxima Página\n" 
							+"2.Página Anterior\n"
							+"3.Ir para Página especifica\n"
							+"4.Sair\n");
					op1= Integer.parseInt(leitor.nextLine());
					if(op1==1) {
						pag+=1;
						livros = livroController.findAllByPage(pag);
						for (Livro livro:livros) {
							System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
						}
					}
					else if(op1==2) {
						pag-=1;
						livros = livroController.findAllByPage(pag);
						for (Livro livro:livros) {
							System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
						}
					}
					else if(op1==3) {
						System.out.println("Digite a página que deseja acessar: ");
						pag = Integer.parseInt(leitor.nextLine());
						livros = livroController.findAllByPage(pag);
						for (Livro livro:livros) {
							System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
						}
					}
					else if(op1==4) {
						break;
					}
					else {
						System.err.println("Opção inválida");
					}
				}
				
			}
			else if (opcao == 11) {
				int pag = 0;
				Page<Livro> livros = livroController.findAllByPageNotInEstoque(pag);
				for (Livro livro:livros) {
					System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
				}
				int op1 = 0;
				while (op1!=4) {
					System.out.println(
							"1.Próxima Página\n" 
							+"2.Página Anterior\n"
							+"3.Ir para Página especifica\n"
							+"4.Sair\n");
					op1= Integer.parseInt(leitor.nextLine());
					if(op1==1) {
						pag+=1;
						livros = livroController.findAllByPage(pag);
						for (Livro livro:livros) {
							System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
						}
					}
					else if(op1==2) {
						pag-=1;
						livros = livroController.findAllByPage(pag);
						for (Livro livro:livros) {
							System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
						}
					}
					else if(op1==3) {
						System.out.println("Digite a página que deseja acessar: ");
						pag = Integer.parseInt(leitor.nextLine());
						livros = livroController.findAllByPage(pag);
						for (Livro livro:livros) {
							System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
						}
					}
					else if(op1==4) {
						break;
					}
					else {
						System.err.println("Opção inválida");
					}
				}
			}
			else if (opcao == 12) {
				System.out.println("Digite o id do livro: ");
				Integer id = Integer.parseInt(leitor.nextLine());
				Optional<Livro> op = livroController.findById(id);
				if (op.isPresent()) {
					Livro livro = op.get();
					System.out.println("Digite quantas unidades deseja adicionar ao estoque: ");
					livro.setEstoque(Integer.parseInt(leitor.nextLine()));
					livroController.update(livro);
					
				}
				else {
					System.err.println("Livro não Encontrado");
				}
			}
			else if (opcao == 13) {
				List<Livro>  livros = livroController.findCheapers();
				for (Livro livro:livros) {
					System.out.println("ID do livro: " + livro.getId() + "Titulo do livro: " + livro.getTitulo() + " Preço do livro: " + livro.getPreco().toString()+ " ISBN "+livro.getIsbn() );
				}
			}
			else if (opcao == 14) {
				System.out.println("Digite o id do cliente: ");
				Integer id = Integer.parseInt(leitor.nextLine());
				Optional <Cliente> consulta= clienteController.findByid(id);
				if(consulta.isPresent()) {
					Cliente cliente = consulta.get();
					System.out.println(cliente.getNome());
					Pedido pedido = new Pedido();
					pedido.setCliente(cliente);
					int op3=0;
					List<Livro> livros = new ArrayList<>();
					while(op3!=3) {
						System.out.println(
								"1.Adicionar Livro\n" 
								+"2.Sair\n");
						if(op3==1) {
							System.out.println("Digite o id do Livro que deseja adicionar:");
							int idLivro = Integer.parseInt(leitor.nextLine());
							Optional<Livro> op = livroController.findById(idLivro);
							if (op.isPresent()) {
								Livro livro = op.get();
								livros.add(livro);
								System.out.println("Livro adicionado ao carrinho");
							}
							
							else {
								System.err.println("Livro não Encontrado");
							}
							
						}
						else {
							break;
						}
						
					}
				}
				else {
					System.err.println("Email inexistente");
				
				}
			}
			else if (opcao == 15) {
				System.exit(0);
			}
			
			else {
				System.err.println("Opção inválida digite um número correto");
			}
		}

}

}
