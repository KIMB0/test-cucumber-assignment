package cucumbertest;

import account.Account;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class Stepdefs {
    private Account account;
    private double amountToWithdraw;
    private String errorMessage = "Not enough money";


    @Given("^I have \\$(\\d+) in my account$")
    public void i_have_$_in_my_account(double amount) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        account = new Account(amount);
    }

    @When("^I choose to withdraw the fixed amount of \\$(\\d+)$")
    public void i_choose_to_withdraw_the_fixed_amount_of_$(double amount) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        try {
            amountToWithdraw = account.withdrawMoney(amount);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }
    }

    @Then("^I should Receive \\$(\\d+) cash$")
    public void i_should_Receive_$_cash(double amount) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        assertThat(amount, is(amountToWithdraw));
    }

    @Then("^the balance of my account should be \\$(\\d+)$")
    public void the_balance_of_my_account_should_be_$(double amount) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        double accountBalance = account.getAccountBalance();
    }

    @Then("^I should See an error message$")
    public void i_should_See_an_error_message() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(errorMessage, "Not enough money");
    }

}