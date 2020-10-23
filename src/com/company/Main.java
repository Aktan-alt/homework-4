package com.company;

import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int[] heroesHealth = {260, 270, 300, 200};
    public static int[] heroesDamage = {10, 20, 5};
    public static String[] heroesAttackType = {"Physical", "Magical", "Mental", "Medic"};

    public static void main(String[] args) {
        printStatistic();
        while (!isFinished()){
            round();
        }
    }
    public static void round(){
        printStatistic();
        System.out.println("Round was started");
        if (heroesHealth[3] == 0){
            medicHelp();
        }
        changeBossDefence();
        heroesHit();
        if (bossHealth > 0){
            bossHit();
        }
        printStatistic();
        }

    public static void medicHelp() {
        Random r = new Random();
        int chance = r.nextInt (3);
        int min = heroesHealth[0];
        int indexHeroNeedHill = 0;

        for (int i = 0; i < heroesDamage.length; i++){
            if (heroesHealth[i] < min) {
                min = heroesHealth[i];
                indexHeroNeedHill = i;
            }
        }
        if (min < 100 && min != 100){
            heroesHealth[indexHeroNeedHill] += chance;
            System.out.println("Hill " + heroesAttackType[indexHeroNeedHill] + " on " + chance);
        }
    }


    public static void printStatistic() {
        System.out.println("__________");
        System.out.println("Boss health:" + bossHealth);
        for (int i = 0; i < heroesAttackType.length; i++) {
            System.out.println(heroesAttackType[i]
                    + " health: " + heroesHealth[i]);
            System.out.println("__________");
        }
    }

        public static boolean isFinished() {
            if (bossHealth <= 0) {
                System.out.println("Heroes won!!!");
                return true;
            }
            boolean allHeroesDead = true;
            for (int i = 0; i < heroesHealth.length; i++) {
                if(heroesHealth[i] > 0){
                    allHeroesDead = false;
                    break;
                }
            }
            return allHeroesDead;

        }
    public static void bossHit(){
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                }else heroesHealth[i] = heroesHealth[i] - bossDamage;
            }
        }
    }
    public static void heroesHit(){
        for (int i = 0; i < heroesDamage.length ; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0){
                if (bossHealth - heroesDamage[i] < 0){
                    heroesHealth[i] = 0;
                }else heroesHealth[i] = bossHealth - heroesDamage[i];
            }
        }
    }
    public static void changeBossDefence(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomIndex];
        System.out.println("Boss defence type" + heroesAttackType[randomIndex]);
    }
}
