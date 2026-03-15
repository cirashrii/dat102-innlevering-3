package Oppgave4Uke10;

public class HobbyMatchMain extends JavaSetToMengde<String>{
    public static double match(Person a, Person b){
        JavaSetToMengde<String> aHobbyer = a.getHobbyer();
        JavaSetToMengde<String> bHobbyer = b.getHobbyer();
        JavaSetToMengde<String> snittMengde = (JavaSetToMengde<String>) aHobbyer.snitt(bHobbyer);
        int TotalAntall = snittMengde.antallElementer() + aHobbyer.antallElementer() + bHobbyer.antallElementer();
        return snittMengde.antallElementer() - (double) (aHobbyer.antallElementer() - bHobbyer.antallElementer()) / TotalAntall;
    }

    public static void main(String[] args){
        JavaSetToMengde<String> hobby1 = new JavaSetToMengde<>();
        hobby1.leggTil("jakt");
        hobby1.leggTil("sykling");
        hobby1.leggTil("venner");
        JavaSetToMengde<String> hobby2 = new JavaSetToMengde<>();
        hobby2.leggTil("data");
        hobby2.leggTil("sykling");
        hobby2.leggTil("venner");
        JavaSetToMengde<String> hobby3 = new JavaSetToMengde<>();
        hobby3.leggTil("fotball");
        hobby3.leggTil("data");
        hobby3.leggTil("svømming");

        Person p1 = new Person("Arne", hobby1);
        Person p2 = new Person("Lise", hobby2);
        Person p3 = new Person("Per", hobby3);

        if(match(p1, p2) > match(p1, p3) && match(p1, p2) > match(p2,p3)){
            System.out.println(p1.getNavn() + " og " + p2.getNavn() + " har best match, og scoren er på " + match(p1, p2));
        }
        else if(match(p1, p3) > match(p2, p3)){
            System.out.println(p1.getNavn() + " og " + p3.getNavn() + " har best match, og scoren er på " + match(p1, p3));
        }
        else{
            System.out.println(p2.getNavn() + " og " + p3.getNavn() + " har best match, og scoren er på " + match(p2, p3));
        }

        System.out.println("Match score for " + p1.getNavn() + " og " + p2.getNavn() + " er " + match(p1, p2));
        System.out.println("Match score for " + p2.getNavn() + " og " + p1.getNavn() + " er " + match(p2, p1));
        System.out.println("Match score for " + p2.getNavn() + " med seg selv er " + match(p2, p2));
    }
}
