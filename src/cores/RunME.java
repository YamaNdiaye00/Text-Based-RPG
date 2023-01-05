package cores;

import java.util.Scanner; //makes the Scanner Class available to use
import java.util.Random; // Makes the Random class available, to generate random numbers
import java.io.*; // This allows us to input or output files

public class RunME {

    public static void main(String[] args) throws FileNotFoundException { // Error Code in case a File is not found by the program

        playerstats PS = new playerstats();
        monsterstats MS = new monsterstats();
        // Created these 2 objects from different class to allow this class to use the methods on those classes

        Scanner kb = new Scanner(System.in); // this Scanner will allow us to use input from the usuer's keyboard
        Random rd = new Random(); // random object created to generate random numbers


        /* I initialized what will be the core statistics of the player, depending on which character class they want to use.
         * It was necessary to initialize them before hand so that they can be used in other methods or while-loops and/or if statements with no errors
         */
        int health = 0;
        int damage = 0;
        int potions = 0;
        int potionsHPR = 50;
        int ExtraLife = 0;
        int CriticalChance = 0;
        int burnchance = 0;
        int burndamage = 15;
        boolean burn = false;

        // An array of Strings which contains the different enemies
        String enemies[] = {"Mancubus", "Caragor", "Nazgul"};

        // Initialized the statistics of what will be the boss
        int BHealth = 250;
        int BDamage = 50;
        boolean Lifesteal = false;
        boolean Shield = false;
        boolean thornmail = false;

        File intro = new File("intro.txt"); //creates the file where the introduction texts are
        Scanner rdintro = new Scanner(intro); //creates a Scanner to read the contents of the file

        while (rdintro.hasNext()) {  // This loop will print out every lines of the text file until there is none left
            String para1 = rdintro.nextLine();
            System.out.println(para1);
        }

        /* Same 2 concepts with the introduction texts file is repeated here.
         *  First statement to make the file available to use,
         *  Second Statement Creates the Scanner that can be used to read the contents
         */
        File clsslct = new File("ClassSelect.txt");
        Scanner rdclsslct = new Scanner(clsslct);

        File RStat = new File("RogueStat.txt");
        Scanner rdRStat = new Scanner(RStat);

        File WStat = new File("WarStat.txt");
        Scanner rdWStat = new Scanner(WStat);

        File MStat = new File("MageStat.txt");
        Scanner rdMStat = new Scanner(MStat);

        while (rdclsslct.hasNext()) { // Loop to display the files contents
            String para = rdclsslct.nextLine();
            System.out.println(para);
        }


        boolean ClassSelect = true;
        /* I initialized this Boolean to be able to create the while loop below,
         * Could translate to "While the player is in the Class Selection Phase, do these statements
         */
        while (ClassSelect) {
            String Classchoice = kb.nextLine(); // String to hold the player's class choice
            String ClassConfirm; // String for the player to either confirm their choice or make another decision
            String para; // a String that will hold the lines contained by the Class Descriptions Files, which will then be displayed on the console

            while (!Classchoice.equalsIgnoreCase("Rogue") && !Classchoice.equalsIgnoreCase("Warrior") && !Classchoice.equalsIgnoreCase("Mage")) {
                System.out.println("You are suppose to be the One save us all! Act like it and heed my words. \nChoose between the 3 boons i've presented you!");
                Classchoice = kb.nextLine();
                //This nested while loop is in case the user makes an invalid command, it will prompt the user to re-make a choice and loop back to the main while loop
            }

            /* If the User selects the Rogue, the program will read the character class description file
             * Giving the user some information  about that class
             */
            if (Classchoice.equalsIgnoreCase("Rogue")) {
                while (rdRStat.hasNext()) {
                    para = rdRStat.nextLine();
                    System.out.println(para);
                }
                System.out.println("Do you choose this class?\n\tYes to Confirm");
                ClassConfirm = kb.nextLine();
                /* After having a better idea of this character class statistics,
                 * The program will prompt the user to confirm their choice
                 */
                if (ClassConfirm.equalsIgnoreCase("yes")) {
                    /* If they type in "yes", the pre-initialized variables from before will get new values
                     * by calling in the methods below from an other class, through the object we PS created
                     * @param String that contains the class choice
                     */
                    health = PS.playerhp(Classchoice);
                    damage = PS.playerdmg(Classchoice);
                    potions = PS.playerpotions(Classchoice);
                    ExtraLife = PS.Extralife(Classchoice);
                    CriticalChance = PS.Crit(Classchoice);
                    burnchance = PS.burnchance(Classchoice);
                    burndamage = PS.burndamage(Classchoice);
                    ClassSelect = false;
                } else {
                    System.out.println("Then choose another: ");
                    /* else if the user types something other than "yes", the program will loop back again to the main loop
                     * precisely on the first statement where the user has to put another String to select their class
                     */
                }
            }

            /* The process where the String would be "Rogue" is applied here too.
             * only differences being that obviously in this case it's another String "warrior"
             * A different Character Class Description file will be read,
             * The same methods are used but the Parameter is different, so the methods will set values accordingly
             */
            else if (Classchoice.equalsIgnoreCase("Warrior")) {
                while (rdWStat.hasNext()) {
                    para = rdWStat.nextLine();
                    System.out.println(para);
                }

                System.out.println("Do you choose this class?\n\tYes to Confirm");
                ClassConfirm = kb.nextLine();
                if (ClassConfirm.equalsIgnoreCase("yes")) {
                    health = PS.playerhp(Classchoice);
                    damage = PS.playerdmg(Classchoice);
                    potions = PS.playerpotions(Classchoice);
                    ExtraLife = PS.Extralife(Classchoice);
                    CriticalChance = PS.Crit(Classchoice);
                    burnchance = PS.burnchance(Classchoice);
                    burndamage = PS.burndamage(Classchoice);
                    ClassSelect = false;
                } else {
                    System.out.println("Then choose another: ");
                }

                // Same routine here with a different String, "Mage"
            } else if (Classchoice.equalsIgnoreCase("Mage")) {
                while (rdMStat.hasNext()) {
                    para = rdMStat.nextLine();
                    System.out.println(para);
                }

                System.out.println("Do you choose this class?\n\tYes to Confirm");
                ClassConfirm = kb.nextLine();
                if (ClassConfirm.equalsIgnoreCase("yes")) {
                    health = PS.playerhp(Classchoice);
                    damage = PS.playerdmg(Classchoice);
                    potions = PS.playerpotions(Classchoice);
                    ExtraLife = PS.Extralife(Classchoice);
                    CriticalChance = PS.Crit(Classchoice);
                    burnchance = PS.burnchance(Classchoice);
                    burndamage = PS.burndamage(Classchoice);
                    ClassSelect = false;
                } else {
                    System.out.println("Then choose another: ");
                }
            }

        }


        System.out.println("--------------------------------------------------------");
        /* This String will hold the name of the enemy that will be fought in this first phase.
         * That enemy will be chosen randomly from the enemies[] String array initialized at the beginning.
         * I used the Random class in order to create a random number that'll be used as an index for the array
         * That random number will be between 0 and the number of elements in the array minus 1,
         * as the number of elements in the array is set as the upper-bound
         */
        String enemy = enemies[rd.nextInt(enemies.length)];

        /*calls in methods from another class in order to set the statistics of the enemy
         * @param String holding the enemy
         * Method sets values accordingly
         */
        int EnemyHealth = MS.enemyhp(enemy);
        int EnemyDamage = MS.enemydmg(enemy);

        // Just like the introduction file, Creates, Reads, Displays
        File Fenc = new File("firstencounter.txt");
        Scanner rdFenc = new Scanner(Fenc);
        while (rdFenc.hasNext()) {
            String sentence = rdFenc.nextLine();
            System.out.println(sentence);
        }

        System.out.println(" Your are facing a " + enemy + "!");
        System.out.println(" It has " + EnemyHealth + " Health Points and " + EnemyDamage + " of attack damage ");


        while (EnemyHealth > 0) {                        // Programmed the fighting sequence using this one while loop
            System.out.println("HP:" + health);
            System.out.println(enemy + "'s HP:" + EnemyHealth);

            //Displays these sentences as a Guide for the User
            System.out.println("Choose an Action!");
            System.out.println("\t\tA. Attack");
            System.out.println("\t\tB. Use a Health Potion");
            System.out.println("\t\tC. Escape The Dungeon");

            String action = kb.nextLine(); //String created to hold the user's actions in this fight sequence

            //if the player chooses to attack
            if (action.equalsIgnoreCase("A")) {

                /*Initialized variables to hold the damages dealt and taken
                 *
                 * The damage taken is equal to a random number between 0 and the maximum value set as damage stats for the monsters by the enemydmg() method
                 * That value is then decremented from the current health of the player
                 *
                 * Vice-Versa
                 * The damage dealt is equal to a random number between 0 and the maximum value set as damage stats for the player by the playerdmg() method
                 * That value is then decremented from the current health of the monster
                 */
                int damagetaken = rd.nextInt(EnemyDamage);
                int damagedealt = rd.nextInt(damage);
                EnemyHealth -= damagedealt;
                health -= damagetaken;

                System.out.println("You have dealt " + damagedealt + " damage to " + enemy +
                        "!");
                System.out.println(enemy + " has dealt " + damagetaken + " damage to you " +
                        "!");

                // only if player is a mage, these sets of command emulates a damage overtime effect.
                if (burn == false) { //while the burn boolean is false
                    if (burnchance > rd.nextInt(100)) {
                        // if the value of burnchance is superior to a random value between 0 and 100.
                        System.out.println("\tYour Fireball has set " + enemy + " on fire!");
                        burn = true;
                        //boolean becomes true, this if statement wont run again at other iterations of the loop
                    }
                }

                if (burn) { // if boolean true
                    EnemyHealth -= burndamage; // Current value of the enemy's health will be decremented by the burn damage every time the player attacks
                    System.out.println(enemy + " is still burning! dealing an additional " + burndamage + " damage!");
                    break;
                }

                //only if player is a rogue, these sets of command emulates a double attack.
                if (CriticalChance > rd.nextInt(100)) {
                    // if the value of CriticalChance is superior to a random value between 0 and 100.
                    int DoubleStrike = rd.nextInt(damage);
                    /*Initialize a new variable that take a new value at every loop, and everytime this if statement runs
                     * just like the regular attack, it will hold a random value between 0 and the total player damage
                     * which will be again decremented from the monster's health
                     */
                    System.out.println("You have landed a double strike! Damaging " + enemy + " for an additional " + DoubleStrike + "!");
                    EnemyHealth -= DoubleStrike;
                }

                //If the player is a warrior, this set of commands emulates a resurrection
                if (health <= 0 && ExtraLife >= 1) {
                    //If the player's health falls to 0 AND the extra life variavle is superior to zero
                    System.out.println("\t You have taken lethal damage!. \n\t\tSecond wind \n\tyour proud warrior spirit prevails, you rise back up to the fight!");
                    // the value of health is reset again to 150
                    health = 150;
                    ExtraLife--;
                    // variable decremented by 1
                } else if (health <= 0 && ExtraLife < 1) {
                    // else, after attacking, for all classes, the player is dead, the loop breaks
                    System.out.println("\tYou have taken lethal damage");
                    break;
                }

            }


            // If the player chooses to take a healing potion
            else if (action.equalsIgnoreCase("B")) {
                if (potions >= 1) {    // if the value of potion is superior to 0 (if the player has potions)

                    //current value of health increased by the amount of healing a potion gives, defined by variable potionsHPR set above
                    health += potionsHPR;

                    // number of potion available decreases by 1
                    potions--;

                    System.out.println("\tYou drank a Healing Potion. Your current  health is" + health);
                    System.out.println(" You have " + potions + " potions left.");
                } else { // Else the player has no potions, loops back to the main loop
                    System.out.println("You have no Health Potions available");
                }


            }

            // else the player chooses to run away
            else if (action.equalsIgnoreCase("C")) {
                System.out.println("\t You leave your arms to the ground and run to the nearest Dungeon's exit.\n You have failed to protect Riverrun");
                System.out.println("Calanthur shall reign over this region and Darkness will be its veil");

                // loop breaks
                break;

            }

            // If the user inputs an invalid command, something that's not a b or c
            else if (!(action.equalsIgnoreCase("A")) && !(action.equalsIgnoreCase("A")) && !(action.equalsIgnoreCase("C"))) {
                System.out.println("This Command doesn't exist! Please try again");
                // loops back to main loop
            }

            if (EnemyHealth <= 0) { // if the enemy dies, fight loop breaks
                break;
            }

        }

// Now, The program basically figures out why the fighting phase is over			

        if (health <= 0 && ExtraLife < 1) {    //If the player simply died, Message is displayed and the program as a whole is terminated

            System.out.println("\tYou died a proud warrior, now your corpse will join Calanthur's Army.\n You have failed to protect Riverrun");
            System.out.println("Calanthur shall reign over this region and Darkness will be its veil");
        } else if (EnemyHealth <= 0) { // else if the enemy died, the player is prompted to either continue the game or leave
            System.out.println("You won the battle with your head held up high. \nYou continue to explore the Dungeon and come across a path Door.\nA dark Aura emerges from it.\nWill you continue on your quest or turn back while your still can?");
            System.out.println("A. Continue");
            System.out.println("B. Flee");
        }

        String Decision1 = kb.nextLine();

        while (!Decision1.equalsIgnoreCase("A") && !Decision1.equalsIgnoreCase("B")) {
            System.out.println("Invalid Command!");
            System.out.println("A. Continue");
            System.out.println("B. Exit");
            Decision1 = kb.nextLine();
        }

        if (Decision1.equalsIgnoreCase("B")) { // If the user types B to leave, messages are displayed, the game ends, protgram terminated
            System.out.println("You flee the dungeon");
            System.out.println("It appears that the old man was wrong about you and there may be no hope after all");
            System.out.println("Calanthur shall reign over this region and Darkness will be its veil");
        } else if (Decision1.equalsIgnoreCase("A")) { // case where user wants to continue

            // Same concept of creating the file, reading the file and displaying content
            File Senc = new File("secondencounter.txt");
            Scanner rdSenc = new Scanner(Senc);
            while (rdSenc.hasNext()) {
                String sentence = rdSenc.nextLine();
                System.out.println(sentence);
            }


            System.out.println("I Shall inherit the abilities of the " + enemy + " you have beaten");
            System.out.println("Calanthur has absorbed the  " + enemy + "!");
// depending on which enemy the player fought in the first phase, the boss has a new passive ability

//if it were a mancubus, boolean is true
            if (enemy == "Mancubus") {
                Shield = true;
                System.out.println("He may protect himself against your next attack");
            }

//if it were a Caragor, boolean is true
            else if (enemy == "Caragor") {
                thornmail = true;
                System.out.println("You might suffer when attacking his sawtoothed armour");
            }

//if it were a Nazgul, boolean is true
            else if (enemy == "Nazgul") {
                Lifesteal = true;
                System.out.println("Calanthur heals for a percentage of damage he deals to you");
            }
            burn = false;
            while (BHealth > 0) {                    // Second fight phase programmed in a similar manner as the first on in its core
                System.out.println("HP:" + health);
                System.out.println("Calanthur's HP:" + BHealth);
                System.out.println("Choose an Action!");
                System.out.println("\t\tA. Attack");
                System.out.println("\t\tB. Use a Health Potion");
                System.out.println("\t\tC. Escape The Dungeon");

                String action = kb.nextLine();
                if (action.equalsIgnoreCase("A")) {
                    // player chooses to attack, types A or a

                    int damagetaken = rd.nextInt(BDamage);
                    int damagedealt = rd.nextInt(damage);
                    BHealth -= damagedealt;
                    health -= damagetaken;


                    if (Shield) { // if Shield boolean is true
                        int ShieldChance = 35;
                        if (ShieldChance > rd.nextInt(100)) {
                            // if the value of ShieldChance is superior to a random value between 0 and 100.
                            BHealth += damagedealt;
                            /* This cancels out the subtraction of the Boss's Health (BHealth) by the damage dealt,
                             * Emulating a "Shield"
                             */
                            System.out.println("Calanthur has protected himself against your attack!");
                        }

                        // Else If the value of Shield chance was inferior to the random value between 0 and 100
                        else System.out.println("You have dealt " + damagedealt + " damage to Calanthur!");
                    }

                    // Shield boolean is false, fight should proceed like the first phase
                    if (Shield == false) {
                        System.out.println("You have dealt " + damagedealt + " damage to Calanthur!");
                    }

                    if (thornmail == true) { // If boolean is true,
                        int scale = 10;
                        int scaledmg = (damagedealt * scale) / 100; //To calculate the percentage of the damage that will be received back
                        health -= scaledmg; //player loses that percentage's value in health
                        System.out.println("you received " + scaledmg + " from your attack");
                    }

                    System.out.println("Calanthur has dealt " + damagetaken + " damage to you!");

                    if (Lifesteal == true) { // If boolean is true, sets of command emulates a health regeneration from attacking
                        int heal = 20;
                        int healing = (damagetaken * heal) / 100; // to calculate the healing percentage
                        BHealth += healing; //Boss health is increased by calculated value
                        System.out.println("Calanthur healed himself for " + healing + "!");
                    }

                    //Mage's Passive
                    if (burn == false) {
                        if (burnchance > rd.nextInt(100)) {
                            System.out.println("\tYour Fireball has set Calanthur on fire!");
                            burn = true;
                        }
                    }

                    if (burn) {
                        BHealth -= burndamage;
                        System.out.println("Calanthur is still burning! dealing an additional " + burndamage + " damage!");

                    }

                    //Rogue's passive
                    if (CriticalChance > rd.nextInt(100)) {
                        int DoubleStrike = rd.nextInt(damage);
                        System.out.println("You have landed a double strike! Damaging Calanthur for an additional " + DoubleStrike + "!");
                        EnemyHealth -= DoubleStrike;
                    }

                    //Warrior's Passive
                    if (health <= 0 && ExtraLife >= 1) {
                        System.out.println("\t You have taken lethal damage!. \n\t\tSecond wind \n\tyour proud warrior spirit prevails, you rise back up to the fight!");
                        health = 150;
                        ExtraLife--;
                    }

                    // player died
                    else if (health <= 0 && ExtraLife < 1) {
                        System.out.println("\tYou have taken lethal damage");
                        break;
                    }

                }


                // Player wants to use a potion, types in B
                else if (action.equalsIgnoreCase("B")) {
                    if (potions >= 1) {
                        health += potionsHPR;
                        potions--;

                        System.out.println("\tYou drank a Healing Potion. Your current  health is" + health);
                        System.out.println(" You have " + potions + " potions left.");
                    } else {
                        System.out.println("You have no Health Potions available");
                    }

                }

                //Player flees the dungeon, Types C, ends program
                else if (action.equalsIgnoreCase("C")) {
                    System.out.println("\t You leave your arms to the ground and run to the nearest Dungeon's exit.\n You have failed to protect Riverrun");
                    System.out.println("Calanthur shall reign over this region and Darkness will be its veil");

                    break;

                }

                //Invalid command
                else if (!(action.equalsIgnoreCase("A")) && !(action.equalsIgnoreCase("A")) && !(action.equalsIgnoreCase("C"))) {
                    System.out.println("This Command doesn't exist! Please try again");
                }

                // Boss dies, loop breaks
                if (BHealth <= 0) {
                    burn = false;
                    break;
                }

            }

// program figures out why the loop ended

//Player died, program terminates, Game Over
            if (health <= 0 && ExtraLife < 1) {
                System.out.println("\tYou died a proud warrior, now your corpse will join Calanthur's Army.\n You have failed to protect Riverrun");
                System.out.println("Calanthur shall reign over this region and Darkness will be its veil");
            }

/// Player won against the Boss
            else if (BHealth <= 0) {

                // Same concept of creting, reading and displaying
                File end = new File("endgame.txt");
                Scanner endS = new Scanner(end);
                while (endS.hasNext()) {
                    String sentence = endS.nextLine();
                    System.out.println(sentence);
                }

                System.out.println("---------------------------------------------");
                System.out.println("GAME OVER!");

// Reached the Game Over Screen !
            }


        }

    }
}

