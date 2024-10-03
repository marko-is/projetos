import java.util.Scanner;

    public class AvaliacaoAlimentos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita a quantidade de alimentos
        System.out.print("Digite a quantidade de alimentos: ");
        int quantidadeAlimentos = scanner.nextInt();

        // Array para armazenar as notas de cada alimento
        double[][] notas = new double[quantidadeAlimentos][5]; // 5 avaliações por alimento
        int alimentosBons = 0;
        int alimentosRuins = 0;

        // Loop para cadastrar as avaliações de cada alimento
        for (int i = 0; i < quantidadeAlimentos; i++) {
            System.out.println("\nAlimento " + (i + 1) + ":");

            for (int j = 0; j < 5; j++) {
                System.out.print("Digite a nota da avaliação " + (j + 1) + " (0 a 10): ");
                double nota = scanner.nextDouble();

                // Validação da nota
                while (nota < 0 || nota > 10) {
                    System.out.println("Nota inválida! A nota deve estar entre 0 e 10.");
                    System.out.print("Digite novamente a nota da avaliação " + (j + 1) + " (0 a 10): ");
                    nota = scanner.nextDouble();
                }

                notas[i][j] = nota; // Armazena a nota no vetor
            }

            // Cálculo da média das notas do alimento
            double soma = 0;
            for (double nota : notas[i]) {
                soma += nota;
            }
            double media = soma / notas[i].length;

            // Classificação do alimento
            if (media >= 6) {
                alimentosBons++;
            } else {
                alimentosRuins++;
            }

            System.out.printf("Média das avaliações do alimento %d: %.2f\n", (i + 1), media);
        }

        // Exibição dos resultados
        System.out.println("\nQuantidade de alimentos bons (nota >= 6): " + alimentosBons);
        System.out.println("Quantidade de alimentos ruins (nota < 6): " + alimentosRuins);

        scanner.close();
    }
}
