public class Client {
    private String cpf;
    private String name;

    public Client(String cpf, String name)
    {
        this.cpf = cpf;
        this.name = name;
    }

    public String cpf()
    {
        return this.cpf;
    }

    public String name()
    {
        return this.name;
    }

}
