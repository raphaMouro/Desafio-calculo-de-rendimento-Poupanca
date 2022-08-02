import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CalculoPoupanca {
    public static void main(String[] args) throws Exception {
        DadosUsuario dados = inserirDados();

        SelicReferencial selicReferencial = buscarSelicReferencial(
            dados.getDataInicioFormatada(), 
            dados.getDataFimFormatada()
            );

        rendimentoPoupanca(
            dados.getInvetismentoInicial(),
            selicReferencial
            );
    }

    public static float rendimentoPoupanca(float investimentoInicial, SelicReferencial selicReferencial){
        int mes = 1;
        List<Float> rendimentos = new ArrayList<Float>();
        Float rendimentoTotal = 0f;

        
        System.out.println("Rendimento ao mes:");
        

        for(float valor : selicReferencial.getValoresSelic()){
            float referencial = selicReferencial.getValorReferencialMensal();
            float multiplicador = (valor >= 8.5) ? 0.05f : (float)((valor * 0.70f)/100f);
            float rendimentoMes = (float)(investimentoInicial * multiplicador + referencial);
        
            rendimentos.add(rendimentoMes);

            System.out.println(
                String.format(
                    "\nMes: %s:\n----\nTaxa SELIC: %s - Rendimento: R$ %.3f",
                    mes, valor, rendimentoMes
                    )
                );

            mes++;
            rendimentoTotal += rendimentoMes;
        }

        float resultadoInvestimento = rendimentoTotal + investimentoInicial;

        System.out.println(Arrays.toString(rendimentos.toArray()));
        
        System.out.println("Informações do investimento:");
        

        System.out.println(
            String.format(
                "Investimento inicial: R$ %.2f\nRendimento total: R$ %.2f\nResultado final do investimento: R$ %.2f",
                investimentoInicial, rendimentoTotal, resultadoInvestimento
                )
            );

        return resultadoInvestimento;
    }

    public static SelicReferencial buscarSelicReferencial(String inicio, String fim) {
        List<Float> valoresSelic = new ArrayList<Float>(Arrays.asList(12.2f, 34f, 4.3f));
        List<Float> valoresReferencial = new ArrayList<Float>(Arrays.asList(34.2f, 24f, 1.3f));
        float somaValores = 0;
        float meses = valoresSelic.size();

        for(float valor : valoresReferencial){
            somaValores += valor;
        }

        float valorReferencialMensal = (float)((somaValores / meses)/100f);

        return new SelicReferencial(valoresSelic, valorReferencialMensal);
    }

    public static DadosUsuario inserirDados() {
        try {
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            System.out.print("Digite o valor do investimento inicial: ");
            float valor = scanner.nextFloat();

            System.out.print("Digite a data de inicio do investimento: dd/mm/aaaa: ");
            Date inicio = formatter.parse(scanner.next());

            System.out.print("Digite a data final do investimento: dd/mm/aaaa: ");
            Date fim = formatter.parse(scanner.next());

            scanner.close();

            DadosUsuario dados = new DadosUsuario(
                valor,
                formatter.format(inicio),
                formatter.format(fim)
            );
            return dados;

        } catch(ParseException e) {
            throw new java.lang.Error("Dados digitados são inválidos.");
        }
    }

    public static void testRendimentoPoupanca(){
        
        System.out.println("Textando");
        
        SelicReferencial selicReferencial = new SelicReferencial(
            new ArrayList<Float>(Arrays.asList(10f, 5.0f, 0.20f, 0.30f)), 
            0
            );
            
        float resultado = rendimentoPoupanca(1, selicReferencial);
        if(resultado == 1.0885f){
            System.out.println("Teste ok");
        }else{
            System.out.println("O teste falhou");
            System.out.println(resultado);
        };
    }
}
