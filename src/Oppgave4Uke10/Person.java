package Oppgave4Uke10;

public class Person{
    private String navn;
    private JavaSetToMengde<String> hobbyer;

    public Person(String navn, JavaSetToMengde<String> hobbyer){
        this.navn = navn;
        this.hobbyer = hobbyer;
    }

    public String getNavn() {return navn;}
    public JavaSetToMengde<String> getHobbyer() {return hobbyer;}
}
