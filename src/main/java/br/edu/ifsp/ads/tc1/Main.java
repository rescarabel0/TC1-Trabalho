package br.edu.ifsp.ads.tc1;

import br.edu.ifsp.ads.tc1.domains.Cliente;
import br.edu.ifsp.ads.tc1.domains.Compra;
import br.edu.ifsp.ads.tc1.domains.Produto;
import br.edu.ifsp.ads.tc1.services.ClienteService;
import br.edu.ifsp.ads.tc1.services.CompraService;
import br.edu.ifsp.ads.tc1.services.ProdutoService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ClienteService clienteService = new ClienteService();
    private static final ProdutoService produtoService = new ProdutoService();
    private static final CompraService compraService = new CompraService();

    public static void main(String[] args) {
        int option = -1;
        var reader = new Scanner(System.in);
        while (option != 4) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Clientes \n" +
                    "2 - Produtos \n" +
                    "3 - Compras \n" +
                    "4 - Sair\n");
            option = reader.nextInt();
            reader.nextLine();
            switch (option) {
                case 1: {
                    System.out.println("Escolha uma opção: ");
                    System.out.println(submenu());
                    int subOption = reader.nextInt();
                    reader.nextLine();
                    switch (subOption) {
                        case 1: {
                            System.out.println(clienteService.listaTodos());
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o CPF: ");
                            String cpf = reader.nextLine();
                            System.out.println(clienteService.listaUm(cpf));
                            break;
                        }
                        case 3: {
                            System.out.println("CPF: ");
                            String cpf = reader.nextLine();
                            System.out.println("Nome: ");
                            String nome = reader.nextLine();
                            System.out.println("Data de Nascimento: ");
                            String dataDeNascimento = reader.nextLine();
                            System.out.println("Sexo: ");
                            String sexo = reader.nextLine();
                            System.out.println("Salário: ");
                            float salario = reader.nextFloat();
                            reader.nextLine();
                            System.out.println("Emails: ");
                            List<String> emails = List.of(reader.nextLine().split(","));
                            System.out.println("Telefones: ");
                            List<String> telefones = List.of(reader.nextLine().split(","));

                            var cliente = new Cliente(cpf, nome, new Date(dataDeNascimento), sexo, salario, emails, telefones);
                            try {
                                clienteService.salvar(cliente);
                            } catch (Exception e) {
                                System.out.println("Erro!");
                                break;
                            }
                            System.out.println("Pronto!");
                            break;
                        }
                        case 4: {
                            System.out.println("Digite o CPF: ");
                            String cpf = reader.nextLine();
                            Cliente cliente = clienteService.listaUm(cpf);
                            System.out.printf("Nome [%s]: ", cliente.getNome());
                            String nome = reader.nextLine();
                            System.out.printf("Data de Nascimento [%s]: ", cliente.getDataDeNascimento());
                            String dataDeNascimento = reader.nextLine();
                            System.out.printf("Sexo [%s]: ", cliente.getSexo());
                            String sexo = reader.nextLine();
                            System.out.printf("Salário [%s]: ", cliente.getSalario());
                            float salario = reader.nextFloat();
                            System.out.printf("Emails [%s]: ", cliente.getEmails());
                            List<String> emails = List.of(reader.nextLine().split(","));
                            System.out.printf("Telefones [%s]: ", cliente.getTelefones());
                            List<String> telefones = List.of(reader.nextLine().split(","));

                            cliente = new Cliente(cpf, nome, new Date(dataDeNascimento), sexo, salario, emails, telefones);
                            try {
                                clienteService.atualizar(cliente);
                            } catch (Exception e) {
                                System.out.println("Erro!");
                                break;
                            }
                            System.out.println("Pronto!");
                            break;
                        }
                        case 5: {
                            System.out.println("Digite o CPF: ");
                            String cpf = reader.nextLine();
                            clienteService.excluir(cpf);
                            System.out.println("Pronto!");
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Escolha uma opção: ");
                    System.out.println(submenu());
                    int subOption = reader.nextInt();
                    reader.nextLine();
                    switch (subOption) {
                        case 1: {
                            System.out.println(produtoService.listaTodos());
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o código: ");
                            int cod = reader.nextInt();
                            reader.nextLine();
                            System.out.println(produtoService.listaUm(cod));
                            break;
                        }
                        case 3: {
                            System.out.println("Código: ");
                            int cod = reader.nextInt();
                            reader.nextLine();
                            System.out.println("Descrição: ");
                            String descricao = reader.nextLine();
                            System.out.println("Tamanho: ");
                            int tamanho = reader.nextInt();
                            reader.nextLine();
                            System.out.println("Peso: ");
                            float peso = reader.nextFloat();
                            reader.nextLine();
                            System.out.println("Altura: ");
                            int altura = reader.nextInt();
                            reader.nextLine();
                            System.out.println("Largura: ");
                            int largura = reader.nextInt();
                            reader.nextLine();
                            System.out.println("Preço: ");
                            float preco = reader.nextFloat();
                            reader.nextLine();
                            System.out.println("Desconto: ");
                            float desconto = reader.nextFloat();
                            reader.nextLine();
                            System.out.println("Data de Validade: ");
                            String dataValidade = reader.nextLine();

                            Produto produto = new Produto(
                                    cod,
                                    descricao,
                                    tamanho,
                                    peso,
                                    altura,
                                    largura,
                                    preco,
                                    desconto,
                                    new Date(dataValidade)
                            );
                            produtoService.salvar(produto);
                            System.out.println("Pronto!");
                            break;
                        }
                        case 4: {
                            System.out.println("Digite o código: ");
                            int cod = reader.nextInt();
                            reader.nextLine();

                            Produto produto = produtoService.listaUm(cod);
                            System.out.printf("Descrição [%s]: ", produto.getDescricao());
                            String descricao = reader.nextLine();
                            System.out.printf("Tamanho [%s]: ", produto.getTamanho());
                            int tamanho = reader.nextInt();
                            reader.nextLine();
                            System.out.printf("Peso [%s]: ", produto.getPeso());
                            float peso = reader.nextFloat();
                            reader.nextLine();
                            System.out.printf("Altura [%s]: ", produto.getAltura());
                            int altura = reader.nextInt();
                            reader.nextLine();
                            System.out.printf("Largura [%s]: ", produto.getLargura());
                            int largura = reader.nextInt();
                            reader.nextLine();
                            System.out.printf("Preço [%s]: ", produto.getPreco());
                            float preco = reader.nextFloat();
                            reader.nextLine();
                            System.out.printf("Desconto [%s]: ", produto.getDesconto());
                            float desconto = reader.nextFloat();
                            reader.nextLine();
                            System.out.printf("Data de Validade [%s]: ", produto.getDataDeValidade());
                            String dataValidade = reader.nextLine();

                            produto = new Produto(
                                    cod,
                                    descricao,
                                    tamanho,
                                    peso,
                                    altura,
                                    largura,
                                    preco,
                                    desconto,
                                    new Date(dataValidade)
                            );
                            produtoService.atualizar(produto);
                            System.out.println("Pronto!");
                            break;
                        }
                        case 5: {
                            System.out.println("Digite o Código: ");
                            int cod = reader.nextInt();
                            reader.nextLine();
                            produtoService.excluir(cod);
                            System.out.println("Pronto!");
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Escolha uma opção: ");
                    System.out.println("1 - Listar todos\n" +
                            "2 - Listar um\n" +
                            "3 - Inserir\n" +
                            "4 - Excluir\n");
                    int subOption = reader.nextInt();
                    reader.nextLine();
                    switch (subOption) {
                        case 1: {
                            System.out.println(compraService.listaTodos());
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o id: ");
                            int cod = reader.nextInt();
                            reader.nextLine();
                            System.out.println(compraService.listaUm(cod));
                            break;
                        }
                        case 3: {
                            System.out.println("Código do Produto: ");
                            int cod = reader.nextInt();
                            reader.nextLine();

                            System.out.println("CPF do Cliente: ");
                            String cpf = reader.nextLine();

                            Produto produto = produtoService.listaUm(cod);
                            Cliente cliente = clienteService.listaUm(cpf);

                            if (produto == null || cliente == null) {
                                System.out.println("Erro!\n");
                                return;
                            }
                            Compra compra = new Compra(
                                    compraService.listaTodos().size(),
                                    cliente,
                                    produto
                            );
                            compraService.salvar(compra);
                            System.out.println("Pronto!");
                            break;
                        }
                        case 4: {
                            System.out.println("Digite o id: ");
                            int id = reader.nextInt();
                            reader.nextLine();
                            compraService.excluir(id);
                            System.out.println("Pronto!");
                        }
                    }
                    break;
                }
            }
        }
    }

    private static String submenu() {
        return "1 - Listar todos\n" +
                "2 - Listar um\n" +
                "3 - Inserir\n" +
                "4 - Editar\n" +
                "5 - Excluir\n";
    }
}