package com.bine.pokejuizo;

import java.util.LinkedList;

public class Trainer {

    ///////////
    // Trainer's card window
    ///////////

    private String TrainersName;
    private int TrainersAge;
    private int TrainersRank;
    private String PlayersName;
    private String TrainersConcept;
    private int TrainersNature;
    private int TrainersConfidence;
    private float TrainersMoney;
    private int TrainersHP;
    private int TrainersWill;
    private LinkedList<Pokemon> TrainersActiveParty;

    /////////
    // Attributes and skills window
    /////////

    // Attributes
    private int Strength;
    private int Dexterity;
    private int Vitality;
    private int Insight;

    // Social attributes
    private int Tough;
    private int Cool;
    private int Beauty;
    private int Clever;
    private int Cute;

    // Fight skills
    private int Brawl;
    private int Throw;
    private int Evasion;
    private int Weapons;

    // Survival skills
    private int Alert;
    private int Athletic;
    private int Nature;
    private int Stealth;

    // Social skills
    private int Allure;
    private int Etiquette;
    private int Intimidate;
    private int Perform;

    // Knowledge skills
    private int Crafts;
    private int Lore;
    private int Medicine;
    private int Science;

    // Extra skills
    private LinkedList<Skill> ExtraSkills;

    // Achievements
    private LinkedList<Achivement> Achievements;

    // Pokemon
    private int PokemonCaught;
    private int PokemonSeen;

    /////////////////
    // BackPack window
    /////////////////

    // Potions pocket
    private SimplePotion SimplePotions;
    private SuperPotion SuperPotions;
    private HyperPotion HyperPotions;

    // Small pocket
    private LinkedList<Item> SmallPocketItems;

    // Main pocket
    private LinkedList<Item> MainPocketItems;

    // Gym Badges Case
    private LinkedList<Badge> Badges;
}
