package cores;

public class playerstats {

    /*These methods are my Setters, i'll Use them in the RunMe class in other to set The player's Statistics
     * According to which character class they chose
     * @param String that contains said class choice
     */


    public static int playerhp(String a) {
        int hp = 0;
        if (a.equalsIgnoreCase("Rogue"))
            hp = 150;
        else if (a.equalsIgnoreCase("Mage"))
            hp = 125;
        else if (a.equalsIgnoreCase("Warrior"))
            hp = 175;
        return hp;
    }

    public static int playerdmg(String a) {
        int dmg = 0;
        if (a.equalsIgnoreCase("Rogue"))
            dmg = 60;
        else if (a.equalsIgnoreCase("Mage"))
            dmg = 75;
        else if (a.equalsIgnoreCase("Warrior"))
            dmg = 40;
        return dmg;

    }

    public static int playerpotions(String a) {
        int potions = 0;
        if (a.equalsIgnoreCase("Rogue"))
            potions = 1;
        else if (a.equalsIgnoreCase("Mage"))
            potions = 2;
        else if (a.equalsIgnoreCase("Warrior"))
            potions = 3;
        return potions;

    }

    public static int Extralife(String a) {
        int Xtr = 0;
        if (a.equalsIgnoreCase("Rogue"))
            Xtr = 0;
        else if (a.equalsIgnoreCase("Mage"))
            Xtr = 0;
        else if (a.equalsIgnoreCase("Warrior"))
            Xtr = 1;
        return Xtr;

    }

    public static int Crit(String a) {
        int crt = 0;
        if (a.equalsIgnoreCase("Rogue"))
            crt = 60;
        else if (a.equalsIgnoreCase("Mage"))
            crt = 0;
        else if (a.equalsIgnoreCase("Warrior"))
            crt = 0;
        return crt;
    }

    public static int burnchance(String a) {
        int brnc = 0;
        if (a.equalsIgnoreCase("Rogue"))
            brnc = 0;
        else if (a.equalsIgnoreCase("Mage"))
            brnc = 50;
        else if (a.equalsIgnoreCase("Warrior"))
            brnc = 0;
        return brnc;

    }

    public static int burndamage(String a) {
        int brnd = 0;
        if (a.equalsIgnoreCase("Rogue"))
            brnd = 0;
        else if (a.equalsIgnoreCase("Mage"))
            brnd = 15;
        else if (a.equalsIgnoreCase("Warrior"))
            brnd = 0;
        return brnd;

    }
}
