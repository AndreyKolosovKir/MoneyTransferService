package com.example.moneytransferservice.loger;

import com.example.moneytransferservice.information.Amount;
import com.example.moneytransferservice.information.Cards;
import com.example.moneytransferservice.information.UsersCard;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class Logger {
    private static final String LOG_FILE_PATH = "logTransfer.txt";
    private static final String SERVICE_LOG_FILE_PATH = "logCard.txt";
    private String formattedDateTime;

    public void logCardsRepositoryData(Map<Long, Cards> informationCards, Map<Long, Amount> informationTrans) {
        try (FileWriter writer = new FileWriter(new File(LOG_FILE_PATH, String.valueOf(true)))) {

            displayingDateAndTime();

            writer.write("Transfer information (" + formattedDateTime + "):\n");
            for (Map.Entry<Long, Cards> entry : informationCards.entrySet()) {
                writer.write("Transaction ID: " + entry.getKey() + "\n");
                writer.write("Card From Number: " + entry.getValue().getCardFromNumber() + "\n");
                writer.write("Card From Valid Till: " + entry.getValue().getCardFromValidTill() + "\n");
                writer.write("Card From CVV: " + entry.getValue().getCardFromCVV() + "\n");
                writer.write("Card To Number: " + entry.getValue().getCardToNumber() + "\n");
                writer.write("Amount: " + entry.getValue().getAmount().getValue() + " " +
                        entry.getValue().getAmount().getCurrency() + "\n");
                writer.write("\n");
            }

            writer.write("\n");

            writer.write("Information about the transfer amount and currency (" + formattedDateTime + "):\\n");
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

    public void logServiceData(List<UsersCard> dataUserInformation) {
        try (FileWriter writer = new FileWriter(new File(SERVICE_LOG_FILE_PATH, String.valueOf(true)))) {

            displayingDateAndTime();

            writer.write("Information about the user's card and account (" + formattedDateTime + "):\\\\n");
            for (UsersCard userCard : dataUserInformation) {
                writer.write("User Number Card: " + userCard.getUserNumberCard() + "\n");
                writer.write("Amount of Money: " + userCard.getAmountOfMoney() + "\n");
                writer.write("\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayingDateAndTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedDateTime = now.format(formatter);
    }
}