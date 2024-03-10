package Livraria_CRUD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        LivroDAO livroDao = new LivroDAO();

        System.out.println("MENU");
        System.out.println("1-Cadastrar livro" +
                "\n 2-Listar Livros" +
                "\n 3-Atualizar Livro" +
                "\n 4-Deletar Livro");
        System.out.println("Qual a opção desejada?");
        int opcao = input.nextInt();
        switch (opcao){
            case 1:
                Livro livro = new Livro();
                System.out.println("Informe o nome do livro: ");
                String nome = input.next();
                livro.setNome(nome);
                System.out.println("Informe a quantidade de páginas: ");
                int qtdPag = input.nextInt();
                livro.setQtdPag(qtdPag);
                System.out.println("Informe a nota: ");
                int nota = input.nextInt();
                livro.setNota(nota);
                livroDao.save(livro);
                break;
            case 2:
                System.out.println("Livros cadastrados");
                for (Livro l: livroDao.exibirLivros()){
                    System.out.println("Id do livro: "+l.getId());
                    System.out.println("Nome do livro: "+l.getNome());
                    System.out.println("Quantidade de páginas: "+l.getQtdPag());
                    System.out.println("Nota: "+l.getNota());
                }
                break;
            case 3:
                Livro l1 = new Livro();
                System.out.println("Digite o novo nome: ");
                String novoNome = input.next();
                l1.setNome(novoNome);
                System.out.println("Digite a nova qtd de páginas: ");
                int novaqtd = input.nextInt();
                l1.setQtdPag(novaqtd);
                System.out.println("Informe a nova nota: ");
                int novaNota = input.nextInt();
                l1.setNota(novaNota);
                System.out.println("Informe o ID");
                int idantigo = input.nextInt();
                l1.setId(idantigo);
                livroDao.update(l1);
                System.out.println("Livro atualizado");
                break;
            case 4:
                System.out.println("Informe o id do livro que deseja deletar: ");
                int id = input.nextInt();
                livroDao.deleteById(id);
                System.out.println("Livro deletado");
                break;
            default:
                System.out.println("opção inválida");
                break;
        }



    }
}
