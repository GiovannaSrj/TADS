import java.io.*;
import java.util.*;

public class MegaSenaApp {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 60;
    private static final int NUMBERS_PER_GAME = 6;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Integer>> games = new ArrayList<>();
    private static List<Integer> sortedNumbers = new ArrayList<>();
    private static List<Integer> drawNumbers = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("------- MENU -------");
            System.out.println("1. Lançar jogos");
            System.out.println("2. Apresentar jogos lançados");
            System.out.println("3. Realizar sorteio");
            System.out.println("4. Verificar acertos");
            System.out.println("5. Verificar ganhadores");
            System.out.println("0. Sair");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    launchGames();
                    break;
                case 2:
                    presentGames();
                    break;
                case 3:
                    performDraw();
                    break;
                case 4:
                    checkHits();
                    break;
                case 5:
                    showWinners();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static int getUserChoice() {
        int choice = -1;
        try {
            System.out.print("Escolha uma opção: ");
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }

    private static void launchGames() {
        games.clear();

        int numGames = getPositiveNumber("Informe a quantidade de jogos a serem lançados: ");

        for (int i = 1; i <= numGames; i++) {
            List<Integer> game = new ArrayList<>();
            System.out.println("Jogo " + i + ":");
            if (getUserConfirmation("Deseja gerar números aleatórios para este jogo? (S/N): ")) {
                game = generateRandomGame();
            } else {
                game = getUserSelectedNumbers();
            }
            games.add(game);
        }

        saveGamesToFile("Lancados.txt");
        System.out.println("Jogos lançados com sucesso!");
    }

    private static List<Integer> generateRandomGame() {
        List<Integer> game = new ArrayList<>();
        Random random = new Random();

        while (game.size() < NUMBERS_PER_GAME) {
            int number = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            if (!game.contains(number)) {
                game.add(number);
            }
        }

        Collections.sort(game);
        return game;
    }

    private static List<Integer> getUserSelectedNumbers() {
        List<Integer> game = new ArrayList<>();
        Set<Integer> selectedNumbers = new HashSet<>();

        while (selectedNumbers.size() < NUMBERS_PER_GAME) {
            int number = getPositiveNumber("Informe um número entre " + MIN_NUMBER + " e " + MAX_NUMBER + ": ");
            if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
                if (!selectedNumbers.contains(number)) {
                    selectedNumbers.add(number);
                    game.add(number);
                } else {
                    System.out.println("Número já selecionado. Tente novamente.");
                }
            } else {
                System.out.println("Número inválido. Tente novamente.");
            }
        }

        Collections.sort(game);
        return game;
    }

    private static void saveGamesToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (List<Integer> game : games) {
                StringBuilder sb = new StringBuilder();
                for (int number : game) {
                    sb.append(number).append(" ");
                }
                writer.println(sb.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void presentGames() {
        List<List<Integer>> sortedGames = new ArrayList<>(games);
        for (List<Integer> game : sortedGames) {
            Collections.sort(game);
            System.out.println(game);
        }
    }

    private static void performDraw() {
        sortedNumbers.clear();
        drawNumbers.clear();

        while (drawNumbers.size() < NUMBERS_PER_GAME) {
            int number = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            if (!drawNumbers.contains(number)) {
                drawNumbers.add(number);
            }
        }

        sortedNumbers.addAll(drawNumbers);
        Collections.sort(sortedNumbers);

        saveDrawNumbersToFile("Sorteio.txt");
        System.out.println("Sorteio realizado com sucesso!");
    }

    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static void saveDrawNumbersToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            StringBuilder sb = new StringBuilder();
            for (int number : sortedNumbers) {
                sb.append(number).append(" ");
            }
            writer.println(sb.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkHits() {
        List<Integer> hits = new ArrayList<>();

        for (List<Integer> game : games) {
            int count = countHits(game);
            hits.add(count);
            System.out.println("O jogo " + game + " acertou " + count + " número(s).");
        }

        saveHitsToFile(hits, "Resultado.txt");
    }

    private static int countHits(List<Integer> game) {
        int count = 0;
        for (int number : game) {
            if (drawNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static void saveHitsToFile(List<Integer> hits, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            List<String> results = new ArrayList<>();
            for (int i = 0; i < games.size(); i++) {
                String result = games.get(i).toString() + " - " + hits.get(i) + " acerto(s)";
                results.add(result);
            }
            results.sort(Collections.reverseOrder());
            for (String result : results) {
                writer.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showWinners() {
        int quadraCount = 0;
        int quinaCount = 0;
        int senaCount = 0;

        for (List<Integer> game : games) {
            int count = countHits(game);
            if (count == 4) {
                quadraCount++;
                System.out.println("Ganhador de quadra: " + game);
            } else if (count == 5) {
                quinaCount++;
                System.out.println("Ganhador de quina: " + game);
            } else if (count == 6) {
                senaCount++;
                System.out.println("Ganhador de sena: " + game);
            }
        }

        System.out.println("Total de ganhadores: ");
        System.out.println("Quadra: " + quadraCount);
        System.out.println("Quina: " + quinaCount);
        System.out.println("Sena: " + senaCount);
    }

    private static int getPositiveNumber(String message) {
        int number = -1;
        while (number <= 0) {
            try {
                System.out.print(message);
                number = Integer.parseInt(reader.readLine());
                if (number <= 0) {
                    System.out.println("Número inválido. Tente novamente.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
        return number;
    }

    private static boolean getUserConfirmation(String message) {
        String input = "";
        while (!input.equalsIgnoreCase("S") && !input.equalsIgnoreCase("N")) {
            try {
                System.out.print(message);
                input = reader.readLine();
                if (!input.equalsIgnoreCase("S") && !input.equalsIgnoreCase("N")) {
                    System.out.println("Resposta inválida. Tente novamente.");
                }
            } catch (IOException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
        return input.equalsIgnoreCase("S");
    }
}
