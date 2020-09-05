package Interface.Background;

public class ContextBackground {
    private EtatBackground etat;

    public ContextBackground()
    {
        etat = new NeutreBackground();
    }

    public void setEtat(EtatBackground etat)
    {
        this.etat = etat;
    }

    public EtatBackground getEtat()
    {
        return etat;
    }
}
