package com.example.moneytransferservice.loger;

import com.example.moneytransferservice.information.Amount;
import com.example.moneytransferservice.information.Cards;
import com.example.moneytransferservice.information.UsersCard;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class Logger {
    private static final String LOG_FILE_PATH = "logTransfer.txt";
    private static final String SERVICE_LOG_FILE_PATH = "logCard.txt";

    public static void logCardsRepositoryData(Map<Long, Cards> informationCards, Map<Long, Amount> informationTrans) {
        try (FileWriter writer = new FileWriter(new File(LOG_FILE_PATH, String.valueOf(true)))) {
            writer.write("Transfer information:\n");
            for (Map.Entry<Long, Cards> entry : informationCards.entrySet()) {
                writer.write("Transaction ID: " + entry.getKey() + "\n");
                writer.write("Card From Number: " + entry.getValue().getCardFromNumber() + "\n");
                writer.write("Card From Valid Till: " + entry.getValue().getCardFromValidTill() + "\n");
                writer.write("Card From CVV: " + entry.getValue().getCardFromCVV() + "\n");
                writer.write("Card To Number: " + entry.getValue().getCardToNumber() + "\n");
                writer.write("Amount: " + entry.getValue().getAmount().getValue() + " " + entry.getValue().getAmount().getCurrency() + "\n");
                writer.write("\n"); // Разделяем записи пустой строкой
            }

            writer.write("\n");

            writer.write("Information about the transfer amount and currency\n");
            for (Map.Entry<Long, Amount> entry : informationTrans.entrySet()) {
                writer.write("Transaction ID: " + entry.getKey() + "\n");
                writer.write("Amount: " + entry.getValue().getValue() + " " + entry.getValue().getCurrency() + "\n");
                writer.write("\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<UsersCard> logServiceData(List<UsersCard> dataUserInformation) {
        try (FileWriter writer = new FileWriter(new File(SERVICE_LOG_FILE_PATH, String.valueOf(true)))) {
            writer.write("Information about the user's card and account:\n");
            for (UsersCard userCard : dataUserInformation) {
                writer.write("User Number Card: " + userCard.getUserNumberCard() + "\n");
                writer.write("Amount of Money: " + userCard.getAmountOfMoney() + "\n");
                writer.write("\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataUserInformation;
    }
}