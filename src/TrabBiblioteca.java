
import java.util.ArrayList;
import java.util.Scanner;

public class TrabBiblioteca {

    public static ArrayList<String> usuarios = new ArrayList();
    public static ArrayList<String> livros = new ArrayList();
    public static ArrayList<String> nomec = new ArrayList();
    public static ArrayList<String> autors = new ArrayList();
    public static ArrayList<String> empres = new ArrayList();
    public static ArrayList<String> livrosEmpres = new ArrayList();

    public static void main(String[] args) {
        int comp = 0;
        Scanner s = new Scanner(System.in);

        do {

            System.out.println("\n\t// menu // \n");
            System.out.println("1. cadastrar usuario:  ");
            System.out.println("2. cadastrar livro: ");
            System.out.println("3. cadastrar emprestimo: ");
            System.out.println("4. consultar livros: ");
            System.out.println("5. consultar usuarios: ");
            System.out.println("6. consultar emprestimo: ");
            System.out.println("0. sair:\n ");
            comp = s.nextInt();
            switch (comp) {
                case 1:
                    cadastroUsuario();
                    break;
                case 2:
                    cadastrolivro();
                    break;
                case 3:
                    emprestimo();
                    break;
                case 4:
                    listalivros();
                    break;
                case 5:
                    listausuarios();
                    break;
                case 6:
                    listaemprestimo();
                    break;
                default:
                    System.out.println("\nprograma finalizado! \n");

            }
        } while (comp != 0);

    }

    public static void cadastroUsuario() {

        Scanner s1 = new Scanner(System.in);

        System.out.println("\nCadastrar usuario: \n");
        String nome = s1.nextLine();
        boolean existe = false;
        for (String usuario : usuarios) {
            if (usuario.equals(nome)) {
                existe = true;
                break;
            }
        }
        if (existe) {
            System.out.println("\nUsuario já cadastrado\n");
        } else {
            usuarios.add(nome);
        }
        for (int i = 0; i < livros.size(); i++) {

            System.out.println("\nusuario : " + usuarios.get(i));
        }

    }

    public static void emprestimo() {

        Scanner s = new Scanner(System.in);
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("[" + i + "] Livro : " + livros.get(i) + " (" + autors.get(i) + ") ");
        }
        System.out.println("\nDigite o codigo do livro que deseja pegar emprestado: \n");
        int indexlivros = s.nextInt();

        if (indexlivros >= 0 && indexlivros < livros.size()) {
            String livroTarget = livros.get(indexlivros);
            if (livrosEmpres.contains(livroTarget)) {
                System.out.println("\nlivro já emprestado\n");
            } else {
                livrosEmpres.add(livroTarget);
                for (int i = 0; i < usuarios.size(); i++) {

                    System.out.println("[" + i + "] Usuario : " + usuarios.get(i) + "\n");
                }
                System.out.println("\nDigite o codigo do usuario que deseja utilizar: \n");
                int indexusuarios = s.nextInt();
                if (indexusuarios >= 0 && indexusuarios < usuarios.size()) {
                    empres.add(livros.get(indexlivros) + " : " + usuarios.get(indexusuarios));
                    System.out.println("\nSeu emprestimo foi feito com sucesso!\n");
                } else {
                    System.out.println("\nUsuario não existente\n");
                }
            }
        } else {
            System.out.println("\n livro não existente");
        }

    }

    public static void cadastrolivro() {
        Scanner s2 = new Scanner(System.in);

        System.out.println("\nCadastrar livro:\n");
        String nomelivro = s2.nextLine();
        boolean existe = false;
        for (String livro : livros) {
            if (livro.equals(nomelivro)) {
                existe = true;
                break;
            }
        }
        if (existe) {
            System.out.println("\nLivro já cadastrado\n");
        } else {

            System.out.println("\nCadastrar Autor:\n");
            String nomeautor = s2.nextLine();

            for (String autor : autors) {
                if (autor.equals(nomeautor)) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                System.out.println("\nAutor já cadastrado, cadastro de livro cancelado\n");
            } else {
                autors.add(nomeautor);
                livros.add(nomelivro);

            }
            for (int i = 0; i < livros.size(); i++) {
                System.out.println("\n" + livros.get(i) + " (" + autors.get(i) + ")");
            }
        }
    }

    public static void listalivros() {
        if (livros.isEmpty()) {
            System.out.println("\nNão há livros cadastrados");
        } else {
            for (int i = 0; i < livros.size(); i++) {
                System.out.println("\nLivro : " + livros.get(i) + " (" + autors.get(i) + ")");
            }
        }
    }

    public static void listaemprestimo() {
        if (empres.isEmpty()) {
            System.out.println("\nNão há emprestimos cadastrados");
        } else {
            System.out.println("\nLista de emprestimos\n");
            for (int i = 0; i < empres.size(); i++) {
                System.out.println(empres.get(i));

            }
        }

    }

    public static void listausuarios() {

        if (usuarios.isEmpty()) {
            System.out.println("\nNão há usuarios cadastrados");
        } else {
            System.out.println("\nLista de usuarios\n");
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println(usuarios.get(i));
            }
        }
    }
}
