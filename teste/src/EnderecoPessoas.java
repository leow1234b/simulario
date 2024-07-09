
    import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnderecoPessoas {
    public static void main(String[] args) {
        String pessoasFile = "src/csvs/Pessoa.csv";
        String enderecosFile = "src/csvs/Endereco.csv";
        String outputFile = "src/csvs/EnderecoPessoa.csv";

        try {
            Map<Integer, Pessoa> pessoas = readPessoas(pessoasFile);
            Map<Integer, Endereco> enderecos = readEnderecos(enderecosFile);

            FileWriter writer = new FileWriter(outputFile);
            writer.append("Codigo,Nome,Rua,Cidade\n");

            for (Map.Entry<Integer, Pessoa> entry : pessoas.entrySet()) {
                int codigo = entry.getKey();
                Pessoa pessoa = entry.getValue();
                Endereco endereco = enderecos.get(codigo);

                if (endereco != null) {
                    writer.append(codigo + "," + pessoa.getNome() + "," + endereco.getRua() + "," + endereco.getCidade() + "\n");
                }
            }

            writer.flush();
            writer.close();
            System.out.println("Arquivo 'EnderecoPessoa.csv' criado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Pessoa> readPessoas(String filePath) throws IOException {
        Map<Integer, Pessoa> pessoas = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            int codigo = Integer.parseInt(values[0]);
            String nome = values[1];
            pessoas.put(codigo, new Pessoa(codigo, nome));
        }
        br.close();
        return pessoas;
    }

    public static Map<Integer, Endereco> readEnderecos(String filePath) throws IOException {
        Map<Integer, Endereco> enderecos = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            String rua = values[0];
            String cidade = values[1];
            int codigo = Integer.parseInt(values[2]);
            enderecos.put(codigo, new Endereco(rua, cidade, codigo));
        }
        br.close();
        return enderecos;
    }
}


