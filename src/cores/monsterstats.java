package cores;

public class monsterstats {
    /*Similarly to methods in the playerstats class, these Setters will used in the RunMe class in other to set The monsters's Statistics
     * According to which monster has been randomly chosen
     * @param String that contains said monster
     */

    public static int enemyhp(String E) {
        int hp = 0;
        if (E == "Mancubus") {
            hp = 100;
        }

        if (E == "Caragor") {
            hp = 75;
        }
        if (E == "Nazgul") {
            hp = 50;
        }
        return hp;
    }

    public static int enemydmg(String E) {
        int dmg = 0;
        if (E == "Mancubus") {
            dmg = 20;
        }

        if (E == "Caragor") {
            dmg = 25;
        }
        if (E == "Nazgul") {
            dmg = 30;
        }
        return dmg;
    }

}


