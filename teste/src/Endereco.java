public class Endereco {
    private String rua;
    private String cidade;
    private int codigo;

    public Endereco(String rua, String cidade, int codigo) {
        this.rua = rua;
        this.cidade = cidade;
        this.codigo = codigo;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public int getCodigo() {
        return codigo;
    }
}
