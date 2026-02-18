public class Visita {
    private string nomePaziente;
    private string data;
    private string orario;
    private string stato;

    public Visita(String nomePaziente, String data, String orario){
        this.nomePaziente=nomePaziente;
        this.data=data;
        this.orario=orario;
        this.stato="prenotata";
    }

    public String getNomePaziente() {
        return nomePaziente;
    }

    public string getData() {
        return data;
    }

    public string getOrario() {
        return orario;
    }

    public string getStato(){
        return stato;
    }

    @Override
    public String toString() {
        return "Visita di: " + nomePaziente + "in data: " + data + "orario: " + orario + "stato visita: " +  stato;
    }
}
