import java.util.List;

public class SelicReferencial {
    private List<Float> valoresSelic;
    private float valorReferencialMensal;

    public SelicReferencial(
        List<Float> valoresSelic, 
        float valorReferencialMensal
    ){
        this.valoresSelic = valoresSelic;
        this.valorReferencialMensal = valorReferencialMensal;
    }

   
    public List<Float> getValoresSelic() { return valoresSelic; }
    public float getValorReferencialMensal() { return valorReferencialMensal; }

}
