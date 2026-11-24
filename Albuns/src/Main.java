import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Lê o arquivo CSV usando Java NIO.
        Path caminho = Path.of("albuns.csv");
        List<String> linhas = Files.readAllLines(caminho);

        // Cria o servidor na porta 8080.
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8080), 0);

        // Rota principal da aplicação
        servidor.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if (!validarRequisicao(exchange, "/")) {
                    return;
                }
                String html = "<h1>Bem-vindo(a) à aplicação</h1>"
                        + "<a href=\"http://localhost:8080/albuns\">Todos os álbuns (SRR)</a><br>"
                        + "<a href=\"http://localhost:8080/2026\">Só os de 2026 (Especializada)</a><br>"
                        + "<a href=\"http://localhost:8080/pop\">Só pop (Especializada)</a><br>"
                        + "<a href=\"http://localhost:8080/api/albuns\">Todos os álbuns em JSON (Rota JSON)</a>";
                enviarResposta(exchange, 200, "text/html; charset=UTF-8", html);
            }
        });


        // Rota SSR: apresenta todos os álbuns em HTML.
        servidor.createContext("/albuns", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if (!validarRequisicao(exchange, "/albuns")) {
                    return;
                }

                String html = gerarHtml("Todos os álbuns", linhas, "todos");
                enviarResposta(exchange, 200, "text/html; charset=UTF-8", html);
            }
        });

        // Rota especializada: apresenta somente os álbuns de 2026.
        servidor.createContext("/2026", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if (!validarRequisicao(exchange, "/2026")) {
                    return;
                }

                String html = gerarHtml("Álbuns lançados em 2026", linhas, "2026");
                enviarResposta(exchange, 200, "text/html; charset=UTF-8", html);
            }
        });

        // Rota especializada: apresenta somente os álbuns do gênero Pop.
        servidor.createContext("/pop", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if (!validarRequisicao(exchange, "/pop")) {
                    return;
                }

                String html = gerarHtml("Álbuns do gênero Pop", linhas, "Pop");
                enviarResposta(exchange, 200, "text/html; charset=UTF-8", html);
            }
        });

        // Rota que retorna os dados do CSV em formato JSON.
        servidor.createContext("/api/albuns", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if (!validarRequisicao(exchange, "/api/albuns")) {
                    return;
                }

                String json = gerarJson(linhas);
                enviarResposta(exchange, 200, "application/json; charset=UTF-8", json);
            }
        });

        servidor.setExecutor(null);
        servidor.start();

        System.out.println("Servidor rodando na porta 8080...");
        System.out.println("http://localhost:8080/");
        System.out.println("Álbuns carregados: " + (linhas.size() - 1));
    }

    // Verifica se a requisição usa GET e se o caminho é exatamente o da rota.
    private static boolean validarRequisicao(HttpExchange exchange, String caminhoEsperado)
            throws IOException {
        if (!exchange.getRequestURI().getPath().equals(caminhoEsperado)) {
            enviarResposta(exchange, 404, "text/plain; charset=UTF-8", "Rota não encontrada.");
            return false;
        }

        if (!exchange.getRequestMethod().equals("GET")) {
            enviarResposta(exchange, 405, "text/plain; charset=UTF-8", "Método não permitido.");
            return false;
        }

        return true;
    }

    // Monta a página HTML no próprio servidor (SSR).
    private static String gerarHtml(String titulo, List<String> linhas, String filtro) {
        String html = "<html><head><meta charset=\"UTF-8\"></head><body>";
        html += "<h1>" + titulo + "</h1>";
        html += "<ul>";

        int quantidade = 0;

        // A primeira linha contém o cabeçalho do CSV, por isso começamos em 1.
        for (int i = 1; i < linhas.size(); i++) {
            String linha = linhas.get(i);

            if (linha.isBlank()) {
                continue;
            }

            String[] album = separarCampos(linha);
            boolean exibir = filtro.equals("todos");

            if (filtro.equals("2026") && album[2].equals("2026")) {
                exibir = true;
            }

            if (filtro.equals("Pop") && album[4].equalsIgnoreCase("Pop")) {
                exibir = true;
            }

            if (exibir) {
                html += "<li><strong>" + escaparHtml(album[0]) + "</strong>";
                html += " — Artista: " + escaparHtml(album[1]);
                html += " — Ano: " + escaparHtml(album[2]);
                html += " — Faixas: " + escaparHtml(album[3]);
                html += " — Gênero: " + escaparHtml(album[4]) + "</li>";
                quantidade++;
            }
        }

        html += "</ul>";

        if (quantidade == 0) {
            html += "<p>Nenhum álbum encontrado.</p>";
        } else {
            html += "<p>Total de álbuns: " + quantidade + "</p>";
        }

        html += "</body></html>";
        return html;
    }

    // Converte as linhas do CSV em uma lista de objetos JSON.
    private static String gerarJson(List<String> linhas) {
        String json = "[";
        int quantidade = 0;

        for (int i = 1; i < linhas.size(); i++) {
            String linha = linhas.get(i);

            if (linha.isBlank()) {
                continue;
            }

            String[] album = separarCampos(linha);

            if (quantidade > 0) {
                json += ",";
            }

            json += "{\"nome_do_album\":\"" + escaparJson(album[0]) + "\",";
            json += "\"artista\":\"" + escaparJson(album[1]) + "\",";
            json += "\"ano_de_lancamento\":" + album[2] + ",";
            json += "\"n_faixas\":" + album[3] + ",";
            json += "\"genero\":\"" + escaparJson(album[4]) + "\"}";

            quantidade++;
        }

        json += "]";
        return json;
    }

    // Separa os cinco campos do CSV, respeitando vírgulas dentro de aspas.
    private static String[] separarCampos(String linha) {
        String[] campos = new String[5];
        String campo = "";
        boolean dentroDeAspas = false;
        int indice = 0;

        for (int i = 0; i < linha.length(); i++) {
            char caractere = linha.charAt(i);

            if (caractere == '"') {
                dentroDeAspas = !dentroDeAspas;
            } else if (caractere == ',' && !dentroDeAspas) {
                campos[indice] = campo;
                indice++;
                campo = "";
            } else {
                campo += caractere;
            }
        }

        campos[indice] = campo;
        return campos;
    }

    // Evita que caracteres especiais quebrem o HTML.
    private static String escaparHtml(String texto) {
        texto = texto.replace("&", "&amp;");
        texto = texto.replace("<", "&lt;");
        texto = texto.replace(">", "&gt;");
        texto = texto.replace("\"", "&quot;");
        return texto;
    }

    // Escapa caracteres necessários para manter o JSON válido.
    private static String escaparJson(String texto) {
        texto = texto.replace("\\", "\\\\");
        texto = texto.replace("\"", "\\\"");
        texto = texto.replace("\n", "\\n");
        texto = texto.replace("\r", "\\r");
        return texto;
    }

    // Envia a resposta HTTP com cabeçalho, tamanho e corpo.
    private static void enviarResposta(
            HttpExchange exchange,
            int status,
            String tipoConteudo,
            String resposta
    ) throws IOException {
        byte[] bytes = resposta.getBytes("UTF-8");

        exchange.getResponseHeaders().set("Content-Type", tipoConteudo);
        exchange.sendResponseHeaders(status, bytes.length);

        OutputStream saida = exchange.getResponseBody();
        saida.write(bytes);
        saida.close();
    }
}
