import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        Pessoa pessoa = new Pessoa();
        for(int i = 1; i < 21 ; i++){
            pessoa.nome = JOptionPane.showInputDialog("Nome");
            pessoa.cpf = JOptionPane.showInputDialog("CPF");
            pessoa.numero = JOptionPane.showInputDialog("Numero:");
            lista.AdicionarNoComeco(pessoa);
        }
        System.out.println("Removendo do começo");
        while(lista.tamanho() != 0){
            if(lista.tamanho() == 9){
                System.out.println("Vencedor Pessoa " + lista.tamanho());
            }
            lista.removeDoComeco();
       }
    }
}