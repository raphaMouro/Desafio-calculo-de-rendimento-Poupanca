public class DadosUsuario {
    private float invetismentoInicial;
    private String dataInicioFormatada;
    private String dataFimFormatada;

    public DadosUsuario(
        float invetismentoInicial, 
        String dataInicioFormatada, 
        String dataFimFormatada
    ){
        this.invetismentoInicial = invetismentoInicial;
        this.dataInicioFormatada = dataInicioFormatada;
        this.dataFimFormatada = dataFimFormatada;
    }

    // GETTER E SETTTERS
    public float getInvetismentoInicial() { return invetismentoInicial; }
    public String getDataInicioFormatada() { return dataInicioFormatada; }
    public String getDataFimFormatada() { return dataFimFormatada; }

}
