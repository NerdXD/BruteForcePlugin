package com.nerdxd.bruteforce;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BruteForce implements CommandExecutor {

    //I PROMISE THAT I DIDN'T JUST TAKE THE PASSWORD YOU GAVE AND PRINTED IT

    /*
    Note: The reason this is not the real thing is 1 because the intruders wouldn't know exactly
    how long the password is, and I think there are more reasons, but I can't think of them rn XD
     */

    public Main plugin;

    //original password
    public String password;

    //symbols
    public final String symbol = "`~!@#$%^&*_-+=|:;<,>.?(){}[]\"\'/\\";

    public char[] symbols = new char[symbol.length()];

    //lower case letters
    public final String lletter = "abcdefghijklmnopqrstuvwxyz";

    public char[] lletters = new char[lletter.length()];

    //Upper case letters
    public final String uletter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public char[] uletters = new char[uletter.length()];

    //Numbers
    public final String number = "1234567890";

    public char[] numbers = new char[number.length()];

    //the guessed password
    public String gpass = "";

    

    public BruteForce(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            //I did this because I wanted the program to go a bit faster and I just didnt want to google how to make some of this happen
            ((Player)sender).sendMessage("ONLY NUMBERS, SYMBOLS, AND LETTERS NO SPECIAL CHARACTERS AND SPACES OR SLASHES OF ANY KIND OR QUOTATION MARKS (because I don't wanna search up how to register these kind of things and to make it easier for the program :) )");

            if(args.length == 1) {
                password = args[0];

                char[] pass = new char[password.length()];

                makeArrays(pass);

                for(int i = 0; i < pass.length; i++) {

                    for(int j = 0; j < symbols.length; j++) {
                        if(pass[i] == symbols[j]) {
                            gpass = gpass + symbols[j];
                            break;
                        }

                    }

                    for(int j = 0; j < lletters.length; j++) {
                        if(pass[i] == lletters[j]) {
                            gpass = gpass + lletters[j];
                            break;
                        }

                    }

                    for(int j = 0; j < uletters.length; j++) {
                        if(pass[i] == uletters[j]) {
                            gpass = gpass + uletters[j];
                            break;
                        }

                    }

                    for(int j = 0; j < numbers.length; j++) {
                        if(pass[i] == numbers[j]) {
                            gpass = gpass + numbers[j];
                            break;
                        }

                    }

                }

                ((Player)sender).sendMessage(ChatColor.GREEN + "The guessed password was: " + gpass + "was I correct? To prove I didn't just take the password that you typed and printed it, check the project on Github: ");


            }

        }

        return false;
    }


    public void makeArrays(char[] pass) {
        for(int i = 0; i < password.length(); i++) {
            pass[i] = password.charAt(i);
        }

        for(int i = 0; i < symbol.length(); i++) {
            symbols[i] = symbol.charAt(i);
        }

        for(int i = 0; i < lletter.length(); i++) {
            lletters[i] = lletter.charAt(i);
        }

        for(int i = 0; i < uletter.length(); i++) {
            uletters[i] = uletter.charAt(i);
        }

        for(int i = 0; i < number.length(); i++) {
            numbers[i] = number.charAt(i);
        }
    }

}
